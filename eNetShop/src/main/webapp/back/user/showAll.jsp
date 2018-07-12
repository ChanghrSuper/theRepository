<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>


    <script type="text/javascript">
        $(function(){
            $("#dg").datagrid({
                url:'${pageContext.request.contextPath}/user/queryAll',
                columns:[[
                    {title:'checkbox',field:'checkbox',checkbox:true},
                    {title:'ID',field:'id',width:230,sortable:true},
                    {title:'电话',field:'phonenumber',width:100,sortable:true},
                    {title:'头像',field:'photopath',width:150,sortable:true,
                        formatter: function(value,row,index){
                            return "<img src='${pageContext.request.contextPath}"+ row.photopath +"' style='width:100%;height:100px;'/>";
                        }
                    },
                    {title:'真实姓名',field:'realname',width:110,sortable:true},
                    {title:'昵称',field:'nickname',width:110,sortable:true},
                    {title:'性别',field:'sex',width:110,sortable:true},
                    {title:'生日',field:'birthday',width:110,sortable:true},
                    {title:'地址',field:'address',width:200,sortable:true},
                    {title:'身份证',field:'idcard',width:200,sortable:true},
                    {title:'状态',field:'status',width:100,sortable:true},
                    {title:'Options',field:'options',width:235,sortable:true,
                        formatter: function(value,row,index){
                            return "<a href='javascript:;' class='btn' onClick=\"delEmpInfo('"+ row.id +"');\"  data-options=\"iconCls:'icon-remove'\" >删除</a>&nbsp;&nbsp;" +
                                "<a data-options=\"iconCls:'icon-edit'\" href='javascript:;' class='btn' onClick=\"openUpdateDialog('"+ row.id +"');\"  >修改</a>&nbsp;&nbsp;" +
                                "<a href='javascript:;' class='btn' onClick=\"openAddrDialog('"+ row.id +"');\"  data-options=\"iconCls:'icon-edit'\" >管理收货地址</a>";
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
                href:'${pageContext.request.contextPath}/back/user/saveUser.jsp',//相当于两张页面的源码包含
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
            $("#saveUserForm").form({
                url:'${pageContext.request.contextPath}/user/save',
                onSubmit: function(){
                    return $("#saveUserForm").form('validate');
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
            $('#saveUserForm').submit();
        }

        //删除用户的信息
        function delEmpInfo(id){
            console.log(id);
            $.messager.confirm('提示', '确定要删除这条数据吗?', function(r){
                if (r){
                    //发送ajax请求删除数据
                    $.post("${pageContext.request.contextPath}/user/cancel",{"id":id},function(result){//原生ajaxjquery封装 获取的是js对象
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
                href:'${pageContext.request.contextPath}/back/user/upUser.jsp?id='+id,//相当于两张页面的源码包含
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
            $("#upUserForm").form({
                url:'${pageContext.request.contextPath}/user/alter',
                onSubmit: function(){
                    return $("#upUserForm").form('validate');
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
            $('#upUserForm').submit();
        }


        function openAddrDialog(id){
            $("#da").dialog({
                title: '添加',
                width: 600,
                height: 400,
                iconCls:'icon-man',
                href:'${pageContext.request.contextPath}/back/user/EditAddr.jsp?id='+id,//相当于两张页面的源码包含
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:addAddr,
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

        function openAddAddr(id){
            $("#da").dialog({
                title: '添加',
                width: 600,
                height: 400,
                iconCls:'icon-man',
                href:'${pageContext.request.contextPath}/back/user/saveAddr.jsp?id='+id,//相当于两张页面的源码包含
            });
        }

        function addAddr() {
            $("#saveAddrForm").form({
                url:'${pageContext.request.contextPath}/user/saveAddr',
                onSubmit: function(){
                    return $("#saveAddrForm").form('validate');
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
            $('#saveAddrForm').submit();
        }
    </script>


    <table id="dg"></table>

    <!-- datagrid工具栏 -->
    <div id="tb">
        <a href="javascript:;" class="easyui-linkbutton" data-options="onClick:openSaveDialog,iconCls:'icon-add',plain:true">添加</a>
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

