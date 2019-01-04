/*
* 通用工具
* */

//项目名称
const basePath = getContextPath();

/**
 * 获取项目名称
 * @returns {string}
 */
function getContextPath(){
    let pathName = document.location.pathname;
    let index = pathName.substr(1).indexOf("/");
    let result = pathName.substr(0,index+1);
    return result;
}

/**
 * 获取URL参数
 * @param name
 * @returns {*}
 */
function getUrlParam(name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    let reg_rewrite = new RegExp("(^|/)" + name + "/([^/]*)(/|$)", "i");
    let r = window.location.search.substr(1).match(reg);
    let q = window.location.pathname.substr(1).match(reg_rewrite);
    if(r != null){
        return r[2];
    }else if(q != null){
        return unescape(q[2]);
    }else{
        return null;
    }
}

/**
 * 取消操作
 * @param url
 */
function onCancel(url){
    location.href = url;
}

function ajaxGet(url, fn){
    $.ajax({
        type: 'GET',
        url: basePath + '/api/' + url,
        success: function(res){
            if(res.success){
            	fn(res.data);
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

function ajaxDelete(url, fn){
    $.ajax({
        type: 'DELETE',
        url: basePath + '/api/'+url,
        success: function(res){
            if(res.success){
                fn();
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

function ajaxPost(url, data, fn){
	$.ajax({
        type: 'POST',
        url: basePath + '/api/' + url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(res){
            if(res.success){
                fn();
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

function ajaxPut(url, data, fn){
	$.ajax({
        type: 'PUT',
        url: basePath + '/api/' + url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(res){
            if(res.success){
            	fn();
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