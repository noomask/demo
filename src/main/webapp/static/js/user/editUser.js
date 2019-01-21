/*
* 修改用户信息
* */

//获取URL传递的参数
const id = getUrlParam('id'); //common.js

$(function(){
    //为提交按钮绑定单机事件
    $('#updateUser').click(function(){
        updateUser();
    });
});

//初始化页面信息
initUserInfo();

/**
 * 初始化页面信息
 */
function initUserInfo(){
	ajaxGet('user/'+id, function(res){
		let data = res.data;
		$('#account').val(data.account);
	    $('#name').val(data.name);
	    $('#sex').val(data.sex);
	    $('#phone').val(data.phone);
	    $('#qq').val(data.qq);
	    $('#wechat').val(data.wechat);
	    $('#email').val(data.email);
	    $('#remark').val(data.remark);
	});
}

/**
 * 更改用户信息
 */
function updateUser(){
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
    	'id': id,
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
    ajaxPut('user', data, function(){
    	location.href = 'userList.html';
    });
}