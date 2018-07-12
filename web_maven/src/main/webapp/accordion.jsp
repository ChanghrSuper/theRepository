<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#aa").accordion({
                multiple:false,
                width:300,
                height:900,
            });
        })
        function add() {
            $('#aa').accordion('add', {
                title: '新标题',
                content: '新内容',
                selected: false
            });
        }
        //发送ajax的请求获取菜单数据
        $.post("/web_maven/menu.json",function(result){
            console.log(result);
            //遍历
            $.each(result,function(i,menu){

                var content = "<div style='text-align:center;'>";
                //遍历孩子
                $.each(menu.children,function(index,child){
                    content += "<div style='margin-top:10px;'><a class='easyui-linkbutton' data-options=\"iconCls:'"+ child.iconCls +"',plain:true\" style='width:90%;border:1px #64ACE5 solid;'>"+ child.title + "</a></div>";
                });
                content +="</div>";

                $("#aa").accordion('add',{
                    title:menu.title,
                    iconCls:menu.iconCls,
                    content:content,
                });
            });

        });
    </script>
</head>
<body>

    <div id="aa" class="easyui-accordion" style="width:300px;height:200px;">

    </div>


    <a class="easyui-linkbutton" data-options="onClick:add">ADD</a>


</body>
</html>
