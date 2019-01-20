/*
* 菜单管理列表页
* */

$(function(){
	//1.加载菜单列表
	loadMenu();
});

function loadMenu(){
	$('#userTable').DataTable({
		  'lengthChange': false,
		  'searching'   : false,
			'ordering'    : false,
			'pagingType': 'numbers',
		  'columns': columns,
		  'language': language,
    'serverSide': true,
  	'ajax': function(data, callback, settings){
  		ajaxGet('user' + attachParam({
  			'draw': data.draw,
  			'limit': data.start,
  			'offset': data.length
  		}), function(res){
  			callback(res.data);
  		});
  	}
  });
}

//加载菜单表格
//getMenus();

//刷新表格
function refreshTable(){
    var table = $('#menuTable').DataTable({
        'paging'      : false,
        'lengthChange': false,
        'searching'   : false,
        'ordering'    : false,
        'info'        : false,
        'autoWidth'   : false,
        'language': {
            'sEmptyTable': '未查询到数据'
        }
    });
    $('#menuTable').treegrid();
}

//拼接表格中的操作按钮
function getButton(id, pid, pname){
    var buttion = ''
        + '<div class="btn-group">'
        + '<button type="button" class="btn btn-default btn-xs"><a href="editMenu.html?id='+id+'">修改</a></button>'
        + '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">'
        + '<span class="caret"></span>'
        + '<span class="sr-only">Toggle Dropdown</span>'
        + '</button>'
        + '<ul class="dropdown-menu" role="menu">';
    if(pid == 0){
        buttion = buttion + '<li><a href="addMenu.html?pid='+id+'&pname='+encodeURI(pname)+'">添加子菜单</a></li>';
    }
    buttion = buttion
        +  '<li><a href="#" onclick="deleteMenu('+id+')">删除</a></li>'
        + '</ul>'
        + '</div>';
    return buttion;
}

//将null值转为空串
function convertNull2String(param){
    return param ? param : '';
}

//填充表格内容
function buildTable(table, data){
    for(var i in data){
        var $tr = $(document.createElement('tr'));
        $tr.addClass('treegrid-'+data[i].id);
        $tr.addClass(data[i].pid > 0 ? 'treegrid-parent-'+data[i].pid : null);
        $tr.append('<td>'+convertNull2String(data[i].name)+'</td>');
        $tr.append('<td>'+convertNull2String(data[i].menuUrl)+'</td>');
        $tr.append('<td>'+convertNull2String(data[i].viewOrder)+'</td>');
        $tr.append('<td>'+convertNull2String(data[i].icon)+'</td>');
        $tr.append('<td>'+convertNull2String(data[i].remark)+'</td>');
        $tr.append('<td style="padding:8px 8px 6px 8px;">'+getButton(data[i].id, data[i].pid, data[i].name)+'</td>');
        if(data[i].pid == 0){
            $('table').find('tbody').prepend($tr);
        }else{
            $('.treegrid-'+data[i].pid).after($tr);
        }
    }
}

//获取表格数据
function getMenus(){
    $.ajax({
        type: 'GET',
        url: basePath + '/api/menus',
        success: function(res){
            if(res.success){
                buildTable('#menuTable', res.data);
                refreshTable();
            }else{
                layer.open({
                    title: '失败'
                    ,content: res.msg
                });
            }
        },
        error: function(e){
            layer.open({
                title: '异常'
                ,content: '提交失败，请重试或联系系统管理员'
            });
            console.log(e);
        }
    });
}

//通过ID删除对应的菜单
function deleteMenu(id){
    $.ajax({
        type: 'DELETE',
        url: basePath + '/api/menus/'+id,
        success: function(res){
            if(res.success){
                location.href = 'menuList.html';
            }else{
                layer.open({
                    title: '失败'
                    ,content: res.msg
                });
            }
        },
        error: function(e){
            layer.open({
                title: '异常'
                ,content: '提交失败，请重试或联系系统管理员'
            });
            console.log(e);
        }
    });
}
