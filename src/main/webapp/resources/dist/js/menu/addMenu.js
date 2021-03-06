/*
* 添加菜单栏
* */

//所属父节点ID，如果为0表示为根节点
const pid = getUrlParam('pid');

//所属父节点名称
const pname = decodeURI(getUrlParam('pname'));

//页面加载完成后执行
$(function(){
    //判断是添加一级菜单还是二级菜单，并初始化对应页面状态
    let $pid = $('#pid');
    if(pid && pid == 0){
        $pid.parent().parent().hide();
    }else{
        $pid.attr("disabled",true);
        $pid.val(pname);
    }
    //为提交按键绑定点击事件
    $('#addMenu').click(function(){
        saveMenu();
    });
});

/**
 * 提交保存
 */
function saveMenu(){
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
    if(viewOrder < 0 || viewOrder > 256){
        layer.msg('显示顺序必须大于0小于256');
    }
    //转换为请求参数
    let data = {
        'pid': pid,
        'name': name,
        'icon': icon,
        'menuUrl': menuUrl,
        'viewOrder': viewOrder,
        'remark': remark,
        'show': show,
        'addUser': 9527
    };
    ajaxPost('menus', data, function () {
        location.href = 'menuList.html';
    })
}