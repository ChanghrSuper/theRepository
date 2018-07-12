<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript">
    $(function(){
        $('#tt').treegrid({
            url:'',
            idField:'id',
            treeField:'name',
            columns:[[
                {title:'Task Name',field:'name',width:180},
                {field:'persons',title:'Persons',width:60,align:'right'},
                {field:'begin',title:'Begin Date',width:80},
                {field:'end',title:'End Date',width:80}
            ]],
            fit:true,
            resizeHandle:'right',
            autoRowHeight:true,
            remoteSort:false,
            method:'GET',//设置请求方式
            toolbar:'#tb',//工具栏
            striped:true,//斑马线
            rownumbers:true,//显示行号
            singleSelect:false,//单行选中
            ctrlSelect:true,//ctrl 选中
            loadMsg:'数据正在获取,请稍后.....',
            pagination:true,//使用分页效果   //当前页page    每页显示的条数 rows   后台定义 Integer page Integer rows   page=1&rows=10
            rownumbers:true,//显示行号
            pageNumber:1,//初始时的页码  默认  第1页
            pageSize:3,//每页显示的条数  要求书写的值必须是pageList中的一个元素
            pageList:[3,6,9,12,15],//定义下拉列表中的页码
            checkOnSelect:false,
            selectOnCheck:false,
            rowStyler: function(index,row){//调整行的样式
                if(index%2==0)
                    return 'background-color:#CCC';
            },
            onLoadSuccess:function(){
                //数据表格加载完成
                $(".btn").linkbutton({
                    plain:true,
                });
            }
        });
    });

    //用来处理搜索的函数
    function search(value,name){
        console.log(value);
        console.log(name);
        //数据从新渲染
        $("#dg").datagrid('load',{
            "columName":name,
            "columValue":value
        });
    }

    function openSaveDialog() {
        $("#da").dialog({
            title: '添加',
            width: 600,
            height: 400,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/product/addShopingCar.jsp',//相当于两张页面的源码包含
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:add,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    //关闭对话框
                    $("#da").dialog('close');
                }
            }],

        });

    }

    function add() {
        $("#saveProductForm").form({
            url:'${pageContext.request.contextPath}/product/save',
            onSubmit: function(){
                return $("#saveProductForm").form('validate');
            },
            success:function(data){
                $.messager.show({
                    title:'保存提示',
                    msg:'保存用户信息成功.....',
                    timeout:5000,
                    showType:'slide'
                });
                //关闭对话框
                $("#da").dialog('close');
                $("#dg").datagrid('reload');
            }
        });
        $('#saveProductForm').submit();
    }

    //删除用户的信息
    function delEmpInfo(id){
        console.log(id);
        $.messager.confirm('提示', '确定要删除这条数据吗?', function(r){
            if (r){
                //发送ajax请求删除数据
                $.post("${pageContext.request.contextPath}/product/cancel",{"id":id},function(result){//原生ajaxjquery封装 获取的是js对象
                    //状态提示
                    //响应回来刷新刷新datagrid
                    $("#dg").datagrid('reload');
                });
            }
        });
    }

    //
    function openUpdateDialog(id){
        $("#da").dialog({
            title: '添加',
            width: 600,
            height: 400,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/product/upProductTag.jsp?id='+id,//相当于两张页面的源码包含
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:update,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    //关闭对话框
                    $("#da").dialog('close');
                }
            }],

        });
    }

    function update() {
        $("#upProductForm").form({
            url:'${pageContext.request.contextPath}/product/alter',
            onSubmit: function(){
                return $("#upProductForm").form('validate');
            },
            success:function(data){
                $.messager.show({
                    title:'更新提示',
                    msg:'更新用户信息成功.....',
                    timeout:5000,
                    showType:'slide'
                });
                //关闭对话框
                $("#da").dialog('close');
                $("#dg").datagrid('reload');
            }
        });
        $('#upProductForm').submit();
    }

    //处理选中删除选中的函数
    function delselectrows() {
        //返回所有行数
        var rows = $("#dg").datagrid('getChecked');
        if(rows.length>0){

            //参数格式: ?id=21&id=22&id=23
            var ids = [];
            $.each(rows,function(idx,row){
                console.log(row.id);
                ids.push(row.id);
            });
            console.log(ids);
            //使用ajax方式发送请求删除一组数据
            $.ajax({  //传递数组类型的参数 一定要设置
                url:"${pageContext.request.contextPath}/product/cancelAll",
                method:"POST",
                data:{ids:ids},
                //dataType:"JSON",
                traditional:true,//用来传递数据类型的参数
                success:function(result){
                    //刷新datagrid数据表格.
                    $("#dg").datagrid('reload');
                }
            });

        }else{
            $.messager.alert('提示','失少勾选一个要删除的数据!!!','info');
        }
    }

    function openAddTag(id) {
        $("#da").dialog({
            title: '添加',
            width: 600,
            height: 400,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/product/addTag.jsp?id='+id,//相当于两张页面的源码包含
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:addTag,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    //关闭对话框
                    $("#da").dialog('close');
                }
            }],

        });

    }

    function addTag() {
        $("#addTagForm").form({
            url:'${pageContext.request.contextPath}/product/addTag',
            onSubmit: function(){
                return $("#addTagForm").form('validate');
            },
            success:function(data){
                $.messager.show({
                    title:'保存提示',
                    msg:'保存用户信息成功.....',
                    timeout:5000,
                    showType:'slide'
                });
                //关闭对话框
                $("#da").dialog('close');
                $("#dg").datagrid('reload');
            }
        });
        $('#addTagForm').submit();
    }

    function openDelTag(id) {
        $("#da").dialog({
            title: '删除',
            width: 600,
            height: 400,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/product/delTag.jsp?id='+id,//相当于两张页面的源码包含
            buttons:[{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
                    //关闭对话框
                    $("#da").dialog('close');
                }
            }],

        });

    }
</script>


<table id="tt" style="width:600px;height:400px"></table>

<!-- datagrid工具栏 -->
<div id="tb">
	<a href="javascript:;" class="easyui-linkbutton" data-options="onClick:openSaveDialog,iconCls:'icon-add',plain:true">添加</a>
	<a href="javascript:;" class="easyui-linkbutton" data-options="onClick:delselectrows,iconCls:'icon-remove',plain:true">删除选中</a>
	<input class="easyui-searchbox" data-options="searcher:search,prompt:'请输入要搜索的结果',width:220,menu:'#mm'"/>
</div>

<!-- 搜索菜单 -->
<div id="mm">
	<div data-options="iconCls:'icon-ok',name:'name'">姓名</div>
	<div data-options="iconCls:'icon-ok',name:'bir'">生日</div>
	<div data-options="iconCls:'icon-ok',name:'age'">年龄</div>
</div>

<!-- 用来处理保存的对话框 -->
<div id="da"></div>