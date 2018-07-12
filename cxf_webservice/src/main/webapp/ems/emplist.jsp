<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/ems/css/style.css"/>"/>
    <script type="text/javascript" src='<c:url value="/ems/js/jquery-3.3.1.js"/>'></script>
    <script type="text/javascript">
        $(function(){
            //每隔一秒刷新一次当前时间
            setInterval(function() {
                //转换为当地时间
                var now = (new Date()).toLocaleString();
                $('#time').text(now);
            }, 1000);

            $(".isDel").click(function(){
                var is = confirm("删？");
                if(is==false){
                    return false;
                }
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
                Welcome!${user.realname}!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>ID</td>
                    <td>Name</td>
                    <td>Salary</td>
                    <td>Age</td>
                    <td>Bir</td>
                    <td>Operation</td>
                </tr>

                <c:forEach items="${emps}" var="emp" varStatus="s">
                    <tr class="<c:if test="${s.count%2!=0}">row1</c:if><c:if test="${s.count%2==0}">row2</c:if>">
                        <td>${emp.id}</td>
                        <td>${emp.name}</td>
                        <td>${emp.salary}</td>
                        <td>${emp.age}</td>
                        <td>${emp.bir}</td>
                    <td><a class="isDel" href="<c:url value="/emp/delete"/>?id=${emp.id}">delete emp</a>&nbsp;<a href="<c:url value="/emp/queryOne"/>?id=${emp.id}">update emp</a></td>
                </tr>
                </c:forEach>

            </table>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='<c:url value="/ems/addEmp.jsp"/>'"/>
            </p>
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
