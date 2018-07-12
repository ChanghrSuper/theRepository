<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/material/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $.get("${pageContext.request.contextPath}/back/main/menu.json",function (menus) {
                //遍历一级菜单
                $.each(menus,function(idx,menu){

                    var content = "<div style='text-align:center;'>";
                    //遍历二级菜单
                    $.each(menu.children,function(i,child){

                        //注意:js中不能直接传递对象类型的参数   传递之前需要将对象转为json字符串传递
                        //js 对象    ----->json格式字符串     这里要特别注意：方法格式必须为 onclick='addDj("+zxdxx+")   （单双引号保持一致）
                        content += "<a class='easyui-linkbutton' onclick='addTabs("+ JSON.stringify(child) +")' style='width:90%;margin-top:10px;border:1px red solid;' data-options=\"iconCls:'"+ child.iconCls +"',plain:true\" >"+ child.title +"</a>";
                    });
                    content +="</div>"


                    //遍历一次向accordion追加一次
                    $("#menu").accordion('add',{
                        title:menu.title,
                        iconCls:menu.iconCls,
                        content:content,
                        selected:false
                    });
                });
            },"JSON");
        });

        //用来向中心布局的选项卡加入当前选项
        function addTabs(child){
            console.log(child);
            if(!$("#tt").tabs('exists',child.title)){//不存在添加
                $("#tt").tabs('add',{
                    title:child.title,
                    iconCls:child.iconCls,
                    closable:true,
                    href:'${pageContext.request.contextPath}/'+child.href,//引入当前点击的二级页面到选项卡中

                });
            }else{//存在切换到当前点击的选项卡中
                $("#tt").tabs('select',child.title)
            }
        };
    </script>
</head>
<body class="easyui-layout">


<!-- 页面的头部分 -->
<div data-options="region:'north',split:false,href:'${pageContext.request.contextPath }/back/main/header.jsp'" style="height:100px;"></div>

<!-- 页面的尾部 -->
<div data-options="region:'south',split:false,href:'${pageContext.request.contextPath }/back/main/footer.jsp'" style="height:80px;"></div>

<!-- 页面的左侧边栏 -->
<div data-options="region:'west',title:'系统菜单',split:false" style="width:200px;">

    <!-- 渲染菜单 -->
    <div id="menu" class="easyui-accordion" data-options="fit:true"></div>

</div>

<!-- 中心面板 -->
<div data-options="region:'center'">

    <!-- 中心选项卡 -->
    <div id="tt" class="easyui-tabs" data-options="fit:true">



    </div>

</div>


</body>
</html>
