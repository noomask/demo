/*
* 菜单权限设置
* */
const roleId = getUrlParam('id');

$(function () {
    //1.加载菜单列表
    loadTreeTable('menuTable', 'menus', cols, function () {
        //加载权限勾选状态
        ajaxGet('roles/'+roleId+'/privileges/menus', function (res) {
            if(!res.data){
                return;
            }
            let ids = res.data.split(',');
            for(let i in ids){
                $('#priv-'+ids[i]).prop('checked', true);
            }
        });
    });
    //2.设置标题为当前角色名
    let name = decodeURI(getUrlParam('name'));
    if(name){
        $('#roleName').html(name + '<small>菜单权限设置</small>');
    }
});

//表格列对应的json参数
const cols = [
    {'data': 'name'},
    {'data': 'remark'},
    {'data': 'id', 'render': operation}
];

//操作按钮
function operation(data, type, row, meta) {
    let buttion = '<input type="checkbox" class="minimal" id="priv-'+data+'" onchange="setPrivilege(this)" value="'+data+'">';
    return buttion;
}

//通过ID删除对应的菜单
function deleteMenu(id) {
    ajaxDelete('menus/'+id, function () {
        location.href = 'menuList.html';
    })
}

function setPrivilege(obj) {
    let id =$(obj).val();
    if($(obj).prop('checked')){
        ajaxPost('roles/'+roleId+'/privileges/menus', {
            'menuId': id
        }, function (res) {
            if(!res.data){
                return;
            }
            let ids = res.data.split(',');
            for(let i in ids){
                $('#priv-'+ids[i]).prop('checked', true);
            }
        })
    }else{
        ajaxDelete('roles/'+roleId+'/privileges/menus/'+id, function (res) {
            $('#menuTable :checked').prop('checked', false);
            if(!res.data){
                return;
            }
            let ids = res.data.split(',');
            for(let i in ids){
                $('#priv-'+ids[i]).prop('checked', true);
            }
        });
    }
}
