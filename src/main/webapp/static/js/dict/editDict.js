/*
* 修改字典
* */

//获取URL传递的参数
const id = getUrlParam('id'); //common.js

//为提交按钮绑定单机事件
$(function(){
    $('#updateDict').click(function(){
        updateDict();
    });
});

//添加页面信息
getDict();

/**
 * 添加菜单信息
 */
function getDict(){
    $.ajax({
        type: 'GET',
        url: basePath + '/api/dict/'+id,
        success: function(res){
            if(res.success){
                $('#name').val(res.data.name);
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
function updateDict(){
    //获取参数
    let name = $('#name').val();
    let remark = $('#remark').val();
    let show = $('#show').prop('checked') == true ? 1 : 0;
    //参数校验
    if(name == ''){
        layer.msg('菜单名称必填');
        return;
    }
    //转换为请求参数
    let data = {
        'id': id,
        'name': name,
        'remark': remark,
        'show': show,
        'addUser': 9527
    };
    $.ajax({
        type: 'PUT',
        url: basePath + '/api/dict',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(res){
            if(res.success){
                location.href = 'dictList.html';
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