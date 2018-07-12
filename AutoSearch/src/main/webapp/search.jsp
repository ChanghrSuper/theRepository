<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function(){

        });
    </script>
</head>
<body>

    <div align="center" style="margin-top:100px">
        <input id="tb" class="easyui-textbox" style="width:300px"
               data-options="onClickButton:search,buttonText:'搜索',iconCls:'icon-search',iconAlign:'left',prompt:'Please Input Value ...'"/>
    </div>

</body>
</html>
