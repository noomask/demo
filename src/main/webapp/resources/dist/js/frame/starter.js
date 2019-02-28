/*
* 后台页面iframe布局框架，包括头部标题，左侧菜单栏，底部声明信息
* */

//iframe框架
const menuFrame = document.getElementById('menuFrame');

$(function () {
    //异步加载菜单栏
    loadMenus();
});

//每200毫秒高度自适应刷新
window.setInterval(function () {
    setIframeHeight(menuFrame);
}, 200);

//设置iframe框架的高度自适应
function setIframeHeight(iframe) {
    if (!iframe) {
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

//构建菜单栏
function buildMenu(data) {
    let $menuRoot = $('#menuRoot');
    for (let i in data) {
        if (data.hasOwnProperty(i)) {
            let menuUrl = data[i].menuUrl ? data[i].menuUrl : 'javascript:void(0)';
            let li = '<li id="menu-' + data[i].id + '"><a href="' + menuUrl + '" target="menuFrame"><i class="' + data[i].icon + '"></i> <span>' + data[i].name + '</span></a></li>';
            if (data[i].pid == 0) {
                $menuRoot.append(li);
                continue;
            }
            let $li = $('#menu-' + data[i].pid);
            let $ul = $('#menu-' + data[i].pid + ' a:first');
            if ($li.prop('className').indexOf('treeview') < 0) {
                $li.addClass('treeview');
                $li.append('<ul class="treeview-menu"><li id="menu-' + data[i].id + '"><a href="' + menuUrl + '" target="menuFrame"><i class="' + data[i].icon + '"></i>' + data[i].name + '</a></li></ul>');
                $ul.attr('href', '#');
                $ul.removeAttr('target');
                $ul.append('<span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>');
            } else {
                $('#menu-' + data[i].pid + ' ul:first').append('<li id="menu-' + data[i].id + '"><a href="' + menuUrl + '" target="menuFrame"><i class="' + data[i].icon + '"></i>' + data[i].name + '</a></li>');
            }
        }
    }
    $menuRoot.prepend('<li class="header">菜单栏</li>');
}

//获取菜单数据
function loadMenus() {
    ajaxGet('menus/self', function (res) {
        buildMenu(res.data);
    });
}