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
            $("#tb").textbox({
                onClickButton:function () {
                    console.log("==========");
                    console.log($(this).textbox('button'));
                    $(this).textbox('destroy');
                }
            });


        });
    </script>
</head>
<body>

<form id="inputForm" align="center" action="http://www.baidu.com">

    username:<input id="tb" class="easyui-textbox" name="username" data-options="buttonIcon:'icon-reload',buttonText:'刷新',iconAlign:'left',iconCls:'icon-man',type:'text',prompt:'please input username ...'"/><br/><br/>
    password:<input id="tp" class="easyui-passwordbox" name="password" data-options="prompt:'please input password ...'"/><br/>

</form>

</body>
</html>
