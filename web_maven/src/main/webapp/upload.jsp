<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<body>
<h2>Upload</h2>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
    选择文件:
    <input type="file" name="file" /><br>
    <input type="submit" value="上传">

    <h1>用来测试文件的下载</h1>
    <a href="${pageContext.request.contextPath}/file/download?filename=c.txt">c.txt</a>
</form>
</body>
</html>
