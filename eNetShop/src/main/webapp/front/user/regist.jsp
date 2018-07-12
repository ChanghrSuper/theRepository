<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<header>
    <title>Admin Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/material/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">


        function regist() {
            $("#registform").form({
                url:'${pageContext.request.contextPath}/user/save',
                onSubmit: function(){
                    return $("#registform").form('validate');
                },
                success:function(data){
                    console.log(data);
                    var result = eval('(' + data + ')');
                    console.log(result.status);
                    if(result.status==true){
                        location.href='${pageContext.request.contextPath}/front/user/login.jsp';
                    }else {
                        $.messager.show({
                            title: '登录错误',
                            msg: result.message,
                            timeout: 5000,
                            showType: 'slide'
                        });
                    }
                }
            });
            $('#registform').submit();

        }
    </script>
</header>

<body>

    <div align="center" style="margin-top: 200px">
        <h1>注册</h1>
    </div>

    <div align="center" style="margin-top: 100px">

        <form id="registform" method="post">
            <div>
                <label for="name">手机号:</label>
                <input class="easyui-textbox" type="text" name="phonenumber" data-options="required:true" />
            </div>
            <div>
                <label for="password">密码:&nbsp;&nbsp;</label>
                <input class="easyui-passwordbox" type="text" name="password" data-options="required:true" />
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/Captcha/Captcha">
                <label for="code">验证码:</label>
                <input class="easyui-textbox" type="text" name="code" data-options="required:true" />
            </div>
            <br/>

            <a id="regist" href="javascript:;" class="easyui-linkbutton" data-options="onClick:regist,iconCls:'icon-attach'">注册</a>

        </form>

    </div>
</body>
</html>