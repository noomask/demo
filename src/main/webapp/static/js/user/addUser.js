/*
* 添加菜单栏
* */

$(function () {
    //为提交按键绑定点击事件
    $('#addUser').click(function(){
        saveUser();
    });
});

/**
 * 提交保存
 */
function saveUser(){
    //获取参数
	let account = $('#account').val();
    let name = $('#name').val();
    let sex = $('#sex').val();
    let phone = $('#phone').val();
    let qq = $('#qq').val();
    let wechat = $('#wechat').val();
    let email = $('#email').val();
    let remark = $('#remark').val();
    //参数校验
    if(name == ''){
        layer.msg('账号必填');
        return;
    }
    //转换为请求参数
    let data = {
        'account': account,
        'name': name,
        'sex': sex,
        'phone': phone,
        'qq': qq,
        'wechat': wechat,
        'email': email,
        'remark': remark,
        'addUser': 9527
    };
    ajaxPost('user', data, function(){
    	location.href = 'userList.html';
    });
}