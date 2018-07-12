<%@page pageEncoding="utf-8" contentType="text/html; utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<link href="../css/common.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src='<c:url value="/js/jquery-1.8.3.js"/>'></script>
		<script type="text/javascript">
            $(function(){

                $(".del").click(function(){
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
				<h1>
					Welcome (请显示当前登陆用户)${user.realname}!
				</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>Name</td>
						<td>Salary</td>
						<td>Age</td>
						<td>Bir</td>
						<td>Dept</td>
						<td>Operation(处理删除的友情提醒)</td>
					</tr>

					<c:forEach items="${emps}" var="emp" varStatus="s">
						<tr class="<c:if test="${s.count%2!=0}">row1</c:if><c:if test="${s.count%2==0}">row2</c:if>">
							<td>${emp.id}</td>
							<td>${emp.name}</td>
							<td>${emp.salary}</td>
							<td>${emp.age}</td>
							<td><fmt:formatDate value="${emp.bir}" pattern="yyyy年MM月dd日"/></td>
							<td>${emp.dept.name}</td>
							<td>
								<a class="del" href="<c:url value="/emp/delete"/>?id=${emp.id}&did=${param.did}">delete emp</a>&nbsp;<a href="<c:url value="/emp/queryOne"/>?id=${emp.id}&did=${param.did}">update emp</a>
							</td>
						</tr>
					</c:forEach>

				</table>
				<div class="pagination">
					<c:if test="${param.page==1}">
						<span class="firstPage">&nbsp;</span>
						<span class="previousPage">&nbsp;</span>
					</c:if>
					<c:if test="${param.page!=1}">
						<a class="firstPage" href="<c:url value="/emp/queryAll"/>?did=${param.did}&page=1">&nbsp;</a>
						<a class="previousPage" href="<c:url value="/emp/queryAll"/>?did=${param.did}&page=${param.page-1}">&nbsp;</a>
					</c:if>


					<c:forEach begin="1" end="${maxPage}" var="i">
						<c:if test="${param.page==i}">
							<span class="currentPage">${i}</span>
						</c:if>
						<c:if test="${param.page!=i}">
							<a href="<c:url value="/emp/queryAll"/>?did=${param.did}&page=${i}">${i}</a>
						</c:if>
					</c:forEach>


					<span class="pageBreak">...</span>


					<c:if test="${param.page==maxPage}">
						<span class="nextPage">&nbsp;</span>
						<span class="lastPage">&nbsp;</span>
					</c:if>
					<c:if test="${param.page!=maxPage}">
						<a class="nextPage" href="<c:url value="/emp/queryAll"/>?did=${param.did}&page=<c:if test="${param.page==null}">2</c:if><c:if test="${param.page!=null}">${param.page+1}</c:if>">&nbsp;</a>
						<a class="lastPage" href="<c:url value="/emp/queryAll"/>?did=${param.did}&page=${maxPage}">&nbsp;</a>
					</c:if>


					<span class="pageSkip"> 共${maxPage}页 到第
						<input id="pageNumber" name="pageNumber" value="<c:if test="${param.page==null}">1</c:if><c:if test="${param.page!=null}">${param.page}</c:if>" maxlength="9" onpaste="return false;">页
						<button type="submit">&nbsp;</button>
					</span>(请在全部功能完成后在处理分页)
				</div>
				<p>
					<input type="button" class="button" value="Add Employee" onclick="location='<c:url value="addEmp.jsp"/>?did=${param.did}'"/>
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
