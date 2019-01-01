/*
* 后台页面iframe布局框架，包括头部标题，左侧菜单栏，底部声明信息
* */

//iframe框架
const menuFrame = document.getElementById('menuFrame');

//项目名称
const basePath = getContextPath(); //取自common.js

//异步加载菜单栏
getMenus();

//设置iframe框架的高度自适应
function setIframeHeight(iframe){
    if(!iframe){
        return;
    }
    let win = iframe.contentWindow;
    if (!win.document.body) {
        return;
    }
    let height = win.document.body.scrollHeight;
    height = height > window.innerHeight - 101 ? height : window.innerHeight - 101;
    iframe.height = height;
}

//每200毫秒高度自适应刷新
window.setInterval(function(){
    setIframeHeight(menuFrame);
}, 200);

//构建菜单栏
function buildMenu(data){
    let $menuRoot = $('#menuRoot');
    for(let i in data){
        if(data.hasOwnProperty(i)){
            let li = ''
                + '<li class="treeview">'
                + '  <a href="#"><i class="fa fa-link"></i> <span>'+data[i].name+'</span>'
                + '    <span class="pull-right-container">'
                + '        <i class="fa fa-angle-left pull-right"></i>'
                + '      </span>'
                + ' </a>'
                + ' <ul class="treeview-menu" style="display: none;" id="menu-'+data[i].id+'">'
                + ' </ul>'
                + '</li>';
            if(data[i].pid == 0){
                $menuRoot.prepend(li);
            }else{
                $('#menu-'+data[i].pid).prepend('<li><a href="'+data[i].menuUrl+'" target="menuFrame"><i class="fa fa-circle-o"></i>'+data[i].name+'</a></li>');
            }
        }
        }
    $menuRoot.prepend('<li class="header">菜单栏</li>');
}

//获取菜单数据
function getMenus(){
    $.ajax({
        type: 'GET',
        url: basePath + '/api/menus',
        success: function(res){
            if(res.success){
                buildMenu(res.data);
            }else{
                console.log(res.msg);
            }
        },
        error: function(e){
            console.log(e);
        }
    });
}