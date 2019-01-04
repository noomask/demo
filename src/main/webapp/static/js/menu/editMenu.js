/*
* 修改菜单
* */

//获取URL传递的参数
const id = getUrlParam('id'); //common.js

//为提交按钮绑定单机事件
$(function(){
    $('#updateMenu').click(function(){
        updateMenu();
    });
});

//添加页面信息
getMenu();

/**
 * 添加菜单信息
 */
function getMenu(){
    $.ajax({
        type: 'GET',
        url: basePath + '/api/menus/'+id,
        success: function(res){
            if(res.success){
                $('#name').val(res.data.name);
                $('#icon').val(res.data.icon);
                if(res.data.menuUrl == '--'){
                    $('#menuUrl').attr('disabled',true);
                }
                $('#menuUrl').val(res.data.menuUrl);
                $('#viewOrder').val(res.data.viewOrder);
                $('#remark').val(res.data.remark);
                if(res.data.show == 1){
                    $('#show').prop('checked',true);
                }
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
                ,content: '查询失败，请重试或联系系统管理员'
            });
            console.log(e);
        }
    });
}

/**
 * 更改菜单信息
 */
function updateMenu(){
    //获取参数
    let name = $('#name').val();
    let icon = $('#icon').val();
    let menuUrl = $('#menuUrl').val();
    let viewOrder = $('#viewOrder').val();
    let remark = $('#remark').val();
    let show = $('#show').prop('checked') == true ? 1 : 0;
    //参数校验
    if(name == ''){
        layer.msg('菜单名称必填');
        return;
    }
    if(!/^[0-9]+$/.test(viewOrder) || viewOrder < 0 || viewOrder > 255){
        layer.msg('显示顺序：必须大于0小于256');
        return;
    }
    //转换为请求参数
    let data = {
        'id': id,
        'name': name,
        'icon': icon,
        'menuUrl': menuUrl,
        'viewOrder': viewOrder,
        'remark': remark,
        'show': show,
        'addUser': 9527
    };
    $.ajax({
        type: 'PUT',
        url: basePath + '/api/menus',
        contentType: 'application/json',
        data: JSON.stringify(data),
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