/*
* 用户管理列表页
* */

//刷新表格
function refreshTable(){
    var table = $('#userTable').DataTable({
        'paging'      : false,
        'lengthChange': false,
        'searching'   : false,
        'ordering'    : false,
        'info'        : false,
        'autoWidth'   : false,
        'language': {
            'sEmptyTable': ' '
        }
    });
}

//拼接表格中的操作按钮
function getButton(id){
    var buttion = ''
        + '<div class="btn-group">'
        + '<button type="button" class="btn btn-default btn-xs"><a href="editUser.html?id='+id+'">修改</a></button>'
        + '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">'
        + '<span class="caret"></span>'
        + '<span class="sr-only">Toggle Dropdown</span>'
        + '</button>'
        + '<ul class="dropdown-menu" role="menu">';
    buttion = buttion
        +  '<li><a href="#" onclick="deleteUser('+id+')">删除</a></li>'
        + '</ul>'
        + '</div>';
    return buttion;
}

//将null值转为空串
function convertNull2String(param){
    return param ? param : '';
}

//填充表格内容
function buildTable(data){
    for(var i in data){
        var $tr = $(document.createElement('tr'));
        $tr.append('<td>'+convertNull2String(data[i].account)+'</td>');
        $tr.append('<td>'+convertNull2String(data[i].name)+'</td>');
        $tr.append('<td>'+convertNull2String(data[i].sex)+'</td>');
        $tr.append('<td>'+convertNull2String(data[i].phone)+'</td>');
        $tr.append('<td>'+convertNull2String(data[i].qq)+'</td>');
        $tr.append('<td>'+convertNull2String(data[i].wechat)+'</td>');
        $tr.append('<td style="padding:8px 8px 6px 8px;">'+getButton(data[i].id)+'</td>');
        $('#userTable').find('tbody').append($tr);
    }
}

//获取表格数据并加载
ajaxGet('user', function(data){
	buildTable(data);
	refreshTable();
});

//通过ID删除用户
function deleteUser(id){
	ajaxDelete('user/'+id, function(){
		location.href = 'userList.html';
	});
}
