/*
* 字典管理列表页
* */

$(function () {
    //1.加载字典列表
    loadTreeTable('dictTable', 'dict', cols);
});

//表格列对应的json参数
const cols = [
    {'data': 'name'},
    {'data': 'id'},
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
        + '<button type="button" class="btn btn-default btn-xs"><a href="editDict.html?id='+id+'">修改</a></button>'
        + '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">'
        + '<span class="caret"></span>'
        + '<span class="sr-only">Toggle Dropdown</span>'
        + '</button>'
        + '<ul class="dropdown-menu" role="menu">';
    buttion = buttion + '<li><a href="addDict.html?pid='+id+'&pname='+encodeURI(pname)+'">添加子节点</a></li>';
    buttion = buttion + '<li><a href="#" onclick="deleteDict('+id+')">删除</a></li></ul></ul>';
    return buttion;
}

//通过ID删除对应的菜单
function deleteDict(id){
    ajaxDelete('dict/'+id, function () {
        location.href = 'dictList.html';
    });
}
