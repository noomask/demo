/*
* 修改字典
* */

//获取URL传递的参数
const id = getUrlParam('id'); //common.js

$(function(){
    //初始化页面信息
    loadDict();
    //为提交按钮绑定单机事件
    $('#updateDict').click(function(){
        updateDict();
    });
});

/**
 * 初始化页面信息
 */
function loadDict(){
    ajaxGet('dict/'+id, function (res) {
        $('#name').val(res.data.name);
        $('#remark').val(res.data.remark);
        if(res.data.show == 1){
            $('#show').prop('checked',true);
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
    ajaxPut('dict', data, function () {
        location.href = 'dictList.html';
    })
}