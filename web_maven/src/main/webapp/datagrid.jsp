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
            $('#dg').datagrid({
                data:[ //定义本地数据
                    {"id":"21","name":"张三","age":23,"bir":"2012-12-12"},
                    {"id":"22","name":"李四","age":24,"bir":"2011-12-12"},
                    {"id":"22","name":"王五","age":24,"bir":"2010-09-12"},
                    {"id":"22","name":"赵六","age":24,"bir":"2018-03-12"},
                    {"id":"22","name":"win7","age":24,"bir":"2012-12-11"},
                ],
                columns:[[
                    {field:'id',title:'ID',width:100},
                    {field:'name',title:'Name',width:100},
                    {field:'age',title:'Age',width:100},
                    {field:'bir',title:'Bir',width:100},
                ]]
            });

        })
    </script>
</head>
<body>

    <table id="dg"></table>

</body>
</html>
