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


        function login() {
            $("#loginform").form({
                url:'${pageContext.request.contextPath}/admin/login',
                onSubmit: function(){
                    return $("#loginform").form('validate');
                },
                success:function(data){
                    console.log(data);
                    var result = eval('(' + data + ')');
                    console.log(result);
                    if(result.status==true){
                        location.href='${pageContext.request.contextPath}/back/main/main.jsp';
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
            $('#loginform').submit();

        }
    </script>
</header>

<body>

    <div align="center" style="margin-top: 200px">
        <h1>易网购后台管理系统</h1>
    </div>

    <div align="center" style="margin-top: 100px">

        <form id="loginform" method="post">
            <div>
                <label for="name">用户名:</label>
                <input class="easyui-textbox" type="text" name="username" data-options="required:true" />
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

            <a id="login" href="javascript:;" class="easyui-linkbutton" data-options="onClick:login,iconCls:'icon-accept'">登录</a>
            &nbsp;&nbsp;&nbsp;
            <a id="regist" href="javascript:;" class="easyui-linkbutton" onclick="location='${pageContext.request.contextPath}/back/admin/regist.jsp'" data-options="iconCls:'icon-attach'">注册</a>

        </form>

    </div>
</body>
</html>