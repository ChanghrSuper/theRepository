<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<body>

    <s:iterator value="list">
        <s:property value="id"/>---
        <s:property value="name"/>---
        <s:property value="salary"/>---
        <s:property value="age"/>---
        <s:property value="bir"/><br/>
    </s:iterator>
</body>
</html>
