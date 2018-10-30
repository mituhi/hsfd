$(function () {
    // VARIABLES =============================================================
    var TOKEN_KEY = "token"
    var $notLoggedIn = $("#notLoggedIn");
    var $loggedIn = $("#loggedIn").hide();
    var $response = $("#response");
    var $login = $("#login");
    var $userInfo = $("#userInfo");

    function setCookie(name, value, days) {
        days = days || 30;
        var expires = new Date();
        expires.setTime(expires.getTime() + days*24*60*60*1000);
        document.cookie = name + "="+ escape (value) + ";path=/" + ";expires=" + expires.toGMTString();
    }

    function removeCookie(name) {
        setCookie(name, '', -1);
    }


    // FUNCTIONS =============================================================
    function getJwtToken() {
        return localStorage.getItem(TOKEN_KEY);
    }

    function setJwtToken(token) {
        setCookie(TOKEN_KEY, token);
        localStorage.setItem(TOKEN_KEY, token);
    }

    function removeJwtToken() {
        removeCookie(TOKEN_KEY);
        localStorage.removeItem(TOKEN_KEY);
    }

    function doLogin(loginData) {
        $.ajax({
            url: "/api/support/auth/login",
            type: "POST",
            data: JSON.stringify(loginData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                setJwtToken(data.token);
                location.href = "showHomepage";
                // $login.hide();
                // $notLoggedIn.hide();
                // showTokenInformation()
                // showUserInformation();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                if (jqXHR.status === 401) {
                    layer.msg("账户或密码错误，请检查后重试");
                } else {
                    layer.msg("登录异常，请联系管理员");
                }
            }
        });
    }

    function doLogout() {
        removeJwtToken();
        $login.show();
        $userInfo
            .hide()
            .find("#userInfoBody").empty();
        $loggedIn
            .hide()
            .attr("title", "")
            .empty();
        $notLoggedIn.show();
    }

    function createAuthorizationTokenHeader() {
        var token = getJwtToken();
        if (token) {
            return {"Authorization": token};
        } else {
            return {};
        }
    }

    function showUserInformation() {
        $.ajax({
            url: "/api/user",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
                var $userInfoBody = $userInfo.find("#userInfoBody");

                $userInfoBody.append($("<div>").text("Username: " + data.username));

                var $authorityList = $("<ul>");
                data.authorities.forEach(function (authorityItem) {
                    $authorityList.append($("<li>").text(authorityItem.authority));
                });
                var $authorities = $("<div>").text("Authorities:");
                $authorities.append($authorityList);

                $userInfoBody.append($authorities);
                $userInfo.show();
            }
        });
    }

    function showTokenInformation() {
        $loggedIn
            .text("Token: " + getJwtToken())
            .attr("title", "Token: " + getJwtToken())
            .show();
    }

    function showResponse(statusCode, message) {
        $response
            .empty()
            .text("status code: " + statusCode + "\n-------------------------\n" + message);
    }

    // REGISTER EVENT LISTENERS =============================================================
    $("#loginForm").submit(function (event) {
        event.preventDefault();

        var $form = $(this);
        var formData = {
            username: $form.find('input[name="username"]').val(),
            password: $form.find('input[name="password"]').val()
        };

        doLogin(formData);
    });

    $("#logoutButton").click(doLogout);

    $("#exampleServiceBtn").click(function () {
        $.ajax({
            url: "/api/hello",
            type: "GET",
            contentType: "application/text; charset=utf-8",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
                showResponse(jqXHR.status, data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                showResponse(jqXHR.status, errorThrown);
            }
        });
    });

    $("#adminServiceBtn").click(function () {
        $.ajax({
            url: "/api/protected",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
                showResponse(jqXHR.status, data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                showResponse(jqXHR.status, errorThrown);
            }
        });
    });

    $loggedIn.click(function () {
        $loggedIn
            .toggleClass("text-hidden")
            .toggleClass("text-shown");
    });

    // INITIAL CALLS =============================================================
    $userInfo.hide();
    return;
    if (getJwtToken()) {
        $login.hide();
        $notLoggedIn.hide();
        showTokenInformation();
        showUserInformation();
    }
});
