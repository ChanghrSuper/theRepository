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
            $("#dd").dialog({
                title:'My dialog',
                width:'600',
                height:'400',
                resizable:true,
                href:'${pageContext.request.contextPath}/prepareforlogin.jsp',
                method:'post',
                buttons:'#bb',
                toolbar:'#tb'
            });

            $("#submit").click(function () {
                $("#inputForm").submit();
            });
        })
    </script>
</head>
<body>

    <div id="dd">
        login...
    </div>

    <div id="bb">
        <a id="submit" href="#" class="easyui-linkbutton">保存</a>
        <a href="#" class="easyui-linkbutton">关闭</a>
    </div>

    <div id="tb">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"></a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true"></a>
    </div>






</body>
</html>
