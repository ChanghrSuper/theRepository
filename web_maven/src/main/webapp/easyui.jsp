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
            $('#btn1').linkbutton({
                iconCls: 'icon-save'
            });

            $("#aa").click(function () {
                
            });
        })
    </script>
</head>
<body>

    <a id="btn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search',size:'large',toggle:true">easyui</a>

    <a id="btn1" href="javascript:;" onclick="javascript:alert('.....')">保存</a>

    <button id="aa">change</button>

    <br/><br/><br/>

    <div class="easyui-panel" data-options="tools:'#tt',closable:true,maximizable:true,minimizable:true,collapsible:true,height:'400',width:'600',iconCls:'icon-man',title:'panel'">
        WTF!!!
    </div>

    <div id="tt">
        <a href="#" class="icon-add" onclick="javascript:alert('add')"></a>
        <a href="#" class="icon-edit" onclick="javascript:alert('edit')"></a>
    </div>


</body>
</html>
