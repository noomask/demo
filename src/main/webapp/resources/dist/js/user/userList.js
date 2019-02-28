/*
* 用户管理列表页
* */

const columns = [
    { 'data': 'account' },
    { 'data': 'name' },
    { 'data': 'sex' },
    { 'data': 'phone' },
    { 'data': 'qq' },
    { 'data': 'wechat' },
    { 'data': 'id', 'render': operation}
];

$(function(){
    loadPageTable('userTable', columns, 'users', 10);
});

//拼接表格中的操作按钮
function operation(data, type, row, meta){
    let id = data;
    let buttion = ''
        + '<div class="btn-group">'
        + '<button type="button" class="btn btn-default btn-xs"><a href="editUser.html?id='+id+'">修改</a></button>'
        + '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">'
        + '<span class="caret"></span>'
        + '<span class="sr-only">Toggle Dropdown</span>'
        + '</button>'
        + '<ul class="dropdown-menu" role="menu">';
    buttion = buttion + '<li><a href="#" onclick="deleteUser('+id+')">删除</a></li></ul></div>';
    return buttion;
}

//通过ID删除用户
function deleteUser(id){
	ajaxDelete('users/'+id, function(){
		location.href = 'userList.html';
	});
}
