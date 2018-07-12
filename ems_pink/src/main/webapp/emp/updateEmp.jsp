<%@page pageEncoding="utf-8" contentType="text/html; utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="../css/style.css" />
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
						<a href="#">Main</a>
					</h1>
				</div>
				<div id="navigation">
				</div>
			</div>
			<div id="content">
				<p id="whereami">
				</p>
				<h1>
					update Emp info:
				</h1>
				<form action="<c:url value="/emp/update"/>?did=${param.did}" method="post">
					<table cellpadding="0" cellspacing="0" border="0"
						   class="form_table">
						<tr>
							<td valign="middle" align="right">
								id:
							</td>
							<td valign="middle" align="left">
								${emp.id}
								<input type="hidden" class="inputgri" name="id" value="${emp.id}"/>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">
								name:
							</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="name" value="${emp.name}"/>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">
								salary:
							</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="salary" value="${emp.salary}"/>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">
								age:
							</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="age" value="${emp.age}"/>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">
								bir:
							</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="bir" value="<fmt:formatDate value="${emp.bir}" pattern="yyyy/MM/dd"/>"/>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">
								请选择部门:(处理默认值选中)${dept.id}
							</td>
							<td valign="middle" align="left">
								<select style="width:178px;" name="dept.id">
									<c:forEach items="${depts}" var="dept">
										<option value="${dept.id}" <c:if test="${dept.id==emp.dept.id}">selected</c:if>>${dept.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="Confirm"/>
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