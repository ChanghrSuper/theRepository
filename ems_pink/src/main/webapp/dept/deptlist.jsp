<%@page pageEncoding="utf-8" contentType="text/html; utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						2009/11/20
						<br/>
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
				<h1>Welcome!${user.realname}</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>Name</td>
						<td>Operation(删除部门员工一并删除)</td>
					</tr>

					<c:forEach items="${depts}" var="dept" varStatus="s">
						<tr class="<c:if test="${s.count%2!=0}">row1</c:if><c:if test="${s.count%2==0}">row2</c:if>">
							<td>${dept.id}</td>
							<td>${dept.name}</td>
							<td>
								<a href="<c:url value="/dept/delete"/>?id=${dept.id}">delete emp</a>&nbsp;<a href="<c:url value="/dept/queryOne"/>?id=${dept.id}">update emp</a>&nbsp;<a
									href="<c:url value="/emp/queryAll"/>?did=${dept.id}">show emps</a>
							</td>
						</tr>
					</c:forEach>

				</table>
				<p>
					<input type="button" class="button" value="Add Dept" onclick="location='addDept.jsp'"/>
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
