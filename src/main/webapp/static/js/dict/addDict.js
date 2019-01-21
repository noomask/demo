/*
* 添加字典
* */

//所属父节点ID，如果为0表示为根节点
const pid = getUrlParam('pid');

//所属父节点名称
const pname = decodeURI(getUrlParam('pname'));

//页面加载完成后执行
$(function(){
    //判断是添加根节点还是字节点，并初始化对应页面状态
    let $pid = $('#pid');
    if(pid && pid == 0){
        $pid.parent().parent().hide();
    }else{
        $pid.attr("disabled",true);
        $pid.val(pname);
    }
    //为提交按键绑定点击事件
    $('#addDict').click(function(){
        saveDict();
    });
});

/**
 * 提交保存
 */
function saveDict(){
    //获取参数
    let name = $('#name').val();
    let remark = $('#remark').val();
    let show = $('#show').prop('checked') == true ? 1 : 0;
    //参数校验
    if(name == ''){
        layer.msg('节点名称必填');
        return;
    }
    //转换为请求参数
    let data = {
        'pid': pid,
        'name': name,
        'remark': remark,
        'show': show,
        'addUser': 9527
    };
    //提交
    ajaxPost('dict', data, function () {
        location.href = 'dictList.html';
    })
}