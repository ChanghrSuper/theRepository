<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>


<script type="text/javascript">
    $(function(){
        $("#dg").datagrid({
            url:'${pageContext.request.contextPath}/banner/showAll',
            columns:[[
                {title:'checkbox',field:'checkbox',checkbox:true},
                {title:'ID',field:'id',width:270,sortable:true},
                {title:'Path',field:'path',width:270,sortable:true},
                {title:'Img',field:'img',width:270,sortable:true,
                    formatter: function(value,row,index){
                    	return "<img src='${pageContext.request.contextPath}"+ row.path +"' style='width:100%;height:100px;'/>";
                    }},
                {title:'CreateDate',field:'createdate',width:270,sortable:true},
                {title:'Status',field:'status',width:270,sortable:true},
                {title:'Options',field:'options',width:270,sortable:true,
                    formatter: function(value,row,index){
                        return "<a data-options=\"iconCls:'icon-edit'\" href='javascript:;' class='btn' onClick=\"changeStatus('"+ row.id +"');\"  >修改</a>" +
							"&nbsp;&nbsp;<a href='javascript:;' class='btn' onClick=\"delEmpInfo('"+ row.id +"');\"  data-options=\"iconCls:'icon-remove'\" >删除</a>";
                    }
                },
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

    //删除用户的信息
    function delEmpInfo(id){
        console.log(id);
        $.messager.confirm('提示', '确定要删除这条数据吗?', function(r){
            if (r){
                //发送ajax请求删除数据
                $.post("${pageContext.request.contextPath}/banner/cancel",{"id":id},function(result){//原生ajaxjquery封装 获取的是js对象
                    //状态提示
                    //响应回来刷新刷新datagrid
                    $("#dg").datagrid('reload');
                });
            }
        });
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
                url:"${pageContext.request.contextPath}/banner/cancelAll",
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

    function uploadbanner() {
        $("#bannerform").form({
            url:'${pageContext.request.contextPath}/banner/upload',
            onSubmit: function(){
                return $("#bannerform").form('validate');
            },
            success:function(data){
                //响应回来刷新刷新datagrid
                $("#dg").datagrid('reload');
            }
        });
        $("#bannerform").form('submit');
    }

    function changeStatus(id){
		$.post("${pageContext.request.contextPath}/banner/changeStatus",{id:id},
			function(data){
            //响应回来刷新刷新datagrid
            $("#dg").datagrid('reload');
        });
	}
</script>

<table id="dg"></table>

<!-- datagrid工具栏 -->
<div id="tb">
	<a href="javascript:;" class="easyui-linkbutton" data-options="onClick:delselectrows,iconCls:'icon-remove',plain:true">删除选中</a>
	<form id="bannerform" action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
		选择文件:
		<input class="easyui-filebox" name="file" style="width:300px" data-options="multiple:true,required:true,buttonText:'选择文件'">
		<a id="btn" href="javascript:;" class="easyui-linkbutton" data-options="onClick:uploadbanner,iconCls:'icon-attach'">上传</a>

	</form>


</div>



