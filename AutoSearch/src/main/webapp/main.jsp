<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>AutoSearch System</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function(){

        });
        function search() {
            alert();
        }
        function add() {
            $("#ff").form({
                url:"/autosearch/products/add",
                onSubmit: function(){
                    return true;
                },
                success:function(data){
                    alert(data);
                    $("#ff").form('clear');
                }
            });
            $("#ff").form('submit');
        }
    </script>
</head>
<body class="easyui-layout">

    <div data-options="href:'/autosearch/header.jsp',region:'north',split:false" style="height:150px;"></div>
    <div data-options="href:'/autosearch/alter.jsp',region:'east',title:'详细',split:false,collapsible:false" style="width:33%;"></div>
    <div data-options="href:'/autosearch/add.jsp',region:'west',title:'添加',split:false,collapsible:false" style="width:33%;"></div>
    <div data-options="href:'/autosearch/search.jsp',region:'center',title:'搜索'" style="padding:5px;"></div>


</body>
</html>
