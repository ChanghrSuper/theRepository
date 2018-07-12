<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Add</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function(){

        })
    </script>
</head>
<body>

    <div   style="margin-top:100px;margin-left: 150px">
        <form id="fff" method="post">
            <div>
                Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="easyui-textbox" type="text" name="name" data-options="" />
            </div>
            <br/>
            <div>
                Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="easyui-textbox" type="text" name="Price" data-options="" />
            </div>
            <br/>
            <div>
                Description:
                <input class="easyui-textbox" type="text" name="Description" data-options="" />
            </div>
            <br/>
            <div>
                ProAddr:&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="easyui-textbox" type="text" name="ProAddr" data-options="" />
            </div>
            <br/>
            <a id="savebtn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
            <a id="cancelbtn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
        </form>
    </div>

</body>
</html>
