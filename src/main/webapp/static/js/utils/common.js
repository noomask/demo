/*
* 通用工具
* */

/**
 * 项目名称
 */
const basePath = getContextPath();

/**
 * DataTable汉化参数
 */
const language = {
	    'sEmptyTable': '无数据',
	    'sInfo': '显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项',
	    'sInfoEmpty': '显示第 0 至 0 项结果，共 0 项',
        'loadingRecords': '加载中...',
	    'oPaginate': {
	        'sFirst': '首页',
	        'sPrevious': '上页',
	        'sNext': '下页',
	        'sLast': '末页'
	    }
	} 

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

/**
 * 拼接GET请求参数
 * @param json
 * @returns
 */
function attachParam(json){
	let str = '?';
	for(let k in json){
		str = str + (json[k] ? k + '=' + json[k] + '&' : '') ;
	}
	return str.length > 1 ? str.substring(0, str.length-1) : '';
}

function ajaxGet(url, fn){
    $.ajax({
        type: 'GET',
        url: basePath + '/api/' + url,
        success: function(res){
            if(res.success){
            	fn(res);
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

/**
 * 加载树表
 * @param tableId
 * @param columns
 */
function loadTreeTable(tableId, url, columns) {
    $('#'+tableId).DataTable( {
        'lengthChange': false,
        'searching': false,
        'ordering': false,
        'info': false,
        'paging': false,
        'language': language,
        'columns': columns,
        "ajax": function(data, callback, settings){
            ajaxGet(url, function (res) {
                callback(res);
                addTreegridClass(tableId, res.data);
                $('#'+tableId).treegrid();
            })
        }
    } );
}

/**
 * 为树表添加treegrid标识
 * @param tableId
 * @param data
 */
function addTreegridClass(tableId,data){
    let tr = $('#'+tableId+' tbody').find('tr');
    for (let i=0;i<data.length;i++) {
        $(tr[i]).addClass('treegrid-' + data[i].id);
        $(tr[i]).addClass(data[i].pid > 0 ? 'treegrid-parent-' + data[i].pid : null);
    }
}