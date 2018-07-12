<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" href="<c:url value='/ems/css/toast.css'/>">
    <script type="text/javascript" src='<c:url value="/ems/js/jquery-3.3.1.js"/>'></script>
    <script type="text/javascript" src="<c:url value="/ems/js/toast.js"/>"></script>
    <script type="text/javascript">
        $(function(){
            //每隔一秒刷新一次当前时间
            setInterval(function() {
                //转换为当地时间
                var now = (new Date()).toLocaleString();
                $('#time').text(now);
            }, 1000);

            //
            $("#btn").click(function(){
                $.post("<c:url value="/user/login"/>",$("#inputform").serialize(),function (data) {
                    console.log(data);
                    if(data.stauts==true){
                        location.href = "<c:url value='/emp/queryAll'/>";
                    }else{
                        $('body').toast({
                            position:'fixed',
                            content:data.message,
                            duration:3000,
                            isCenter:false,
                            background:'#4EA44E',
                            animateIn:'bounceInUp-hastrans',
                            animateOut:'bounceOutDown-hastrans',
                        });
                    }
                },"json");
            });
        });
    </script>
</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <span id="time"></span><br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                login
            </h1>
            <form id="inputform" action="<c:url value="/user/login"/>" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            username:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            password:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password"/>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="button" class="button" id="btn" value="Submit &raquo;"/>
                    <input type="button" class="button" onclick="location.href='./regist.jsp'" value="Regist &raquo;"/>
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
