/*
* 修改菜单
* */

//获取URL传递的参数
const id = getUrlParam('id'); //common.js

$(function(){
    //初始化页面信息
    loadMenu();
    //为提交按钮绑定单机事件
    $('#updateMenu').click(function(){
        updateMenu();
    });
});

/**
 * 初始化页面信息
 */
function loadMenu(){
    ajaxGet('menus/'+id, function (res) {
        $('#name').val(res.data.name);
        $('#icon').val(res.data.icon);
        $('#menuUrl').val(res.data.menuUrl);
        $('#viewOrder').val(res.data.viewOrder);
        $('#remark').val(res.data.remark);
        if(res.data.show == 1){
            $('#show').prop('checked',true);
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
    ajaxPut('menus', data, function () {
        location.href = 'menuList.html';
    });
}