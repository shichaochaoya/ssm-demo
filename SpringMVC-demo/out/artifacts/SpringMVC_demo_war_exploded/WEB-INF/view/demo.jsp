<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/7
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/user/upload" enctype="multipart/form-data">
    <input type="text" name="id"/>
    <input type="file" name="files"/><%--和处理的文件传递的参数一样--%>
    <%--<input type="file" name="files"/>--%>
    <input type="submit" value="提交"/>

</form>
<a href="/user/down"> sasasa</a>

</body>
</html>
