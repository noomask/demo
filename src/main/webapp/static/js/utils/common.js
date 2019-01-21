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
function getContextPath() {
    let pathName = document.location.pathname;
    let index = pathName.substr(1).indexOf("/");
    let result = pathName.substr(0, index + 1);
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
    if (r != null) {
        return r[2];
    } else if (q != null) {
        return unescape(q[2]);
    } else {
        return null;
    }
}

/**
 * 取消操作
 * @param url
 */
function onCancel(url) {
    location.href = url;
}

/**
 * 拼接GET请求参数
 * @param json
 * @returns
 */
function attachParam(json) {
    let str = '?';
    for (let k in json) {
        str = str + (json[k] ? k + '=' + json[k] + '&' : '');
    }
    return str.length > 1 ? str.substring(0, str.length - 1) : '';
}

/**
 * 弹出请求失败提示
 */
function popFailMsg(t, msg) {
    if (msg) {
        layer.open({
            title: t
            , content: msg
        });
    } else {
        layer.open({
            title: t
            , content: '未知错误，请重试或联系管理员'
        });
    }

}

/**
 * 弹出请求异常提示
 */
function popErrotMsg() {
    layer.open({
        title: '请求异常'
        , content: '提交失败，请重试或联系系统管理员'
    });
}

function ajaxGet(url, fn) {
    $.ajax({
        type: 'GET',
        url: basePath + '/api/' + url,
        success: function (res) {
            if (res.success) {
                fn(res);
            } else {
                popFailMsg('请求失败', res.msg);
            }
        },
        error: function (e) {
            popErrotMsg();
            console.log(e);
        }
    });
}

function ajaxDelete(url, fn) {
    $.ajax({
        type: 'DELETE',
        url: basePath + '/api/' + url,
        success: function (res) {
            if (res.success) {
                fn();
            } else {
                popFailMsg('请求失败', res.msg);
            }
        },
        error: function (e) {
            popErrotMsg();
            console.log(e);
        }
    });
}

function ajaxPost(url, data, fn) {
    $.ajax({
        type: 'POST',
        url: basePath + '/api/' + url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (res) {
            if (res.success) {
                fn();
            } else {
                popFailMsg('请求失败', res.msg);
            }
        },
        error: function (e) {
            popErrotMsg();
            console.log(e);
        }
    });
}

function ajaxPut(url, data, fn) {
    $.ajax({
        type: 'PUT',
        url: basePath + '/api/' + url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (res) {
            if (res.success) {
                fn();
            } else {
                popFailMsg('请求失败', res.msg);
            }
        },
        error: function (e) {
            popErrotMsg();
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
    $('#' + tableId).DataTable({
        'lengthChange': false,
        'searching': false,
        'ordering': false,
        'info': false,
        'paging': false,
        'language': language,
        'columns': columns,
        "ajax": function (data, callback, settings) {
            ajaxGet(url, function (res) {
                callback(res); //DataTable回调
                addTreegridClass(tableId, res.data); //树表参数
                $('#' + tableId).treegrid(); //生成树表
            })
        }
    });
}

/**
 * 为树表添加treegrid标识
 * @param tableId 表格ID
 * @param data
 */
function addTreegridClass(tableId, data) {
    let tr = $('#' + tableId + ' tbody').find('tr');
    for (let i = 0; i < data.length; i++) {
        $(tr[i]).addClass('treegrid-' + data[i].id);
        $(tr[i]).addClass(data[i].pid > 0 ? 'treegrid-parent-' + data[i].pid : null);
    }
}

/**
 * 加载分页表格
 * @param columns
 * @param url
 * @param size 每页显示条数
 */
function loadPageTable(columns, url, size) {
    $('#userTable').DataTable({
        'lengthChange': false,
        'searching': false,
        'ordering': false,
        'pagingType': 'numbers',
        'columns': columns,
        'language': language,
        'serverSide': true,
        'ajax': function (data, callback, settings) {
            ajaxGet(url + attachParam({
                'draw': data.draw,
                'limit': data.start,
                'offset': size
            }), function (res) {
                callback(res.data);
            });
        }
    });
}