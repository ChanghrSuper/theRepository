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
            $("#tt").tabs({
                width:800,
                height:600,
                plain:false,
                tools:'#tab-tools',

            });
        });

        function add() {
            var is = $("#tt").tabs('exists','新选项卡面板');
            console.log(is);
            $('#tt').tabs('add',{
                title: '新选项卡面板',
                selected: false,
                index: 2,
                closable:true
            });
        }
    </script>
</head>
<body>

    <div id="tt" class="easyui-tabs" >
        <div title="Tab1" style="padding:20px;display:none;">
            tab1
        </div>
    </div>

    <a class="easyui-linkbutton" data-options="onClick:add">ADD</a>

    <div id="tab-tools">
        <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add"></a>
        <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-save"></a>
    </div>


</body>
</html>
