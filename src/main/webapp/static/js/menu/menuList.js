/*
* 菜单管理列表页
* */

$(function () {
    //1.加载菜单列表
    loadTreeTable('menuTable', 'menus', cols);
});

//表格列对应的json参数
const cols = [
    {'data': 'name'},
    {'data': 'menuUrl'},
    {'data': 'viewOrder'},
    {'data': 'icon'},
    {'data': 'remark'},
    {'data': 'name', 'render': operation}
]

//操作按钮
function operation(data, type, row, meta) {
    let id = row.id;
    let pid = row.pid;
    let pname = row.name;
    let buttion = ''
        + '<div class="btn-group">'
        + '<button type="button" class="btn btn-default btn-xs"><a href="editMenu.html?id=' + id + '">修改</a></button>'
        + '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">'
        + '<span class="caret"></span>'
        + '<span class="sr-only">Toggle Dropdown</span>'
        + '</button>'
        + '<ul class="dropdown-menu" role="menu">';
    if (pid == 0) {
        buttion = buttion + '<li><a href="addMenu.html?pid=' + id + '&pname=' + encodeURI(pname) + '">添加子菜单</a></li>';
    }
    buttion = buttion + '<li><a href="#" onclick="deleteMenu(' + id + ')">删除</a></li></ul></div>';
    return buttion;
}

//通过ID删除对应的菜单
function deleteMenu(id) {
    ajaxDelete('menus/'+id, function () {
        location.href = 'menuList.html';
    })
}
