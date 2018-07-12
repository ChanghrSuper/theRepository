<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript">
    $(function(){
        $("#dg").datagrid({
            url:'${pageContext.request.contextPath}/product/queryAll',
            columns:[[
                {title:'checkbox',field:'checkbox',checkbox:true},
                {title:'ID',field:'id',width:230,sortable:true},
                {title:'商品名称',field:'name',width:150,sortable:true},
                {title:'价格',field:'price',width:80,sortable:true},
                {title:'折扣',field:'discount',width:80,sortable:true},
                {title:'销量',field:'salecount',width:80,sortable:true},
                {title:'库存',field:'stock',width:80,sortable:true},
                {title:'状态',field:'status',width:80,sortable:true},
                {title:'标签',field:'tags',width:250,sortable:true,
                    formatter: function(value,row,index){
						console.log(row.tags);
						var tags = "";
                        $.each( row.tags, function(index, row){
                            console.log(row.name);
                            tag = row.name+"  "
							tags += tag;
                        });
						return tags;
                    }
				},
                {title:'描述',field:'description',width:275,sortable:true},
                {title:'封面',field:'path',width:200,sortable:true,
                    formatter: function(value,row,index){
                        return "<img src='${pageContext.request.contextPath}"+ row.path +"' style='width:100%;height:100px;'/>";
                    }
				},
                {title:'Options',field:'options',width:150,sortable:true,
                    formatter: function(value,row,index){
                        return "<a href='javascript:;' class='btn' onClick=\"openAddShopingCar('"+ row.id +"');\"  data-options=\"iconCls:'icon-remove'\" >添加购物车</a>";
                    }
                },
            ]],
            fit:true,
            resizeHandle:'right',
            autoRowHeight:true,
            remoteSort:false,
            method:'GET',//设置请求方式
            //toolbar:'#tb',//工具栏
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

    function openAddShopingCar(id) {
        $("#da").dialog({
            title: '添加',
            width: 600,
            height: 400,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/front/product/addShopingCar.jsp?proid='+id,//相当于两张页面的源码包含
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
        $("#saveShoppingCar").form({
            url:'${pageContext.request.contextPath}/shoppingcar/save',
            onSubmit: function(){
                return $("#saveShoppingCar").form('validate');
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
        $('#saveShoppingCar').submit();
    }


</script>


<table id="dg"></table>

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