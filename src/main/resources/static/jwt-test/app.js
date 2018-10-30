
// https://github.com/auth0-blog/angularjs-jwt-authentication-tutorial

angular.module('myApp', [])

.config(function() {

})

.service('SecurityService', function($http) {
    var TOKEN_KEY = "jwtToken";

    return {

        getToken: function () {
            return localStorage.getItem(TOKEN_KEY);
        },

        setToken: function (token) {
            localStorage.setItem(TOKEN_KEY, token);
        },

        removeToken: function () {
            localStorage.removeItem(TOKEN_KEY);
        },

        createAuthorizationTokenHeader: function () {
            var token = localStorage.getItem(TOKEN_KEY);
            if (token) {
                return {"Authorization": token};
            } else {
                return {};
            }
        },

        auth : function(username, password) {
            return $http.post('/api/auth', {
                username: username,
                password: password
            });
        },

        getUserInfo : function(role) {
            return $http.get('/api/user', {
                headers: this.createAuthorizationTokenHeader()
            });
        }
    };
});
