$(function(){
    $initMenu();
    // $initUploadExcel();
});


function $initMenu() {
    $("[component_type='menu']").each(function(i,target){
        // $(target).html("");
        // $.postJSON("getMenu",null,function(e){
        //     if(e&&e.success){
        //
        //     }
        // });
    });
}

var core = new core_script();
function core_script() {

   this.initDialog = function (id,title,url) {
       $('<div/>').dialog({
            id : id,
           title : title,
           href :  url,
           width : 640,
           height : 250,
           iconCls : 'icon-edit',
           modal : true,
           // buttons : [ {
           //     text : '确定',
           //     iconCls : 'icon-ok',
           //     handler : function() {
           //
           //     }
           // }, {
           //     text : '取消',
           //     iconCls : 'icon-cancel',
           //     handler : function() {
           //         p.dialog('destroy');
           //     }
           // } ],
           onClose : function() {
               $(this).dialog('destroy');
           },
           onLoad : function() {

           }
       });
   }

    this.closeDialog = function (id) {
        $("#"+id).dialog('destroy');
    }
}