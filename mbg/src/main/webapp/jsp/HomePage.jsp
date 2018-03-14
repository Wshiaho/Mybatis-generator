<%--
  Created by IntelliJ IDEA.
  User: 51188
  Date: 2018/3/13
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/getMain" method="get">
        <div>
            生成model的包名：<input type="text" name="modelTargetPackage"><br>
            生成映射文件的包名：<input type="text" name="mapTargetPackage"><br>
            生成DAO的包名：<input type="text" name="daoTargetPackage"><br>
            生成的表名：<input type="text" name="table"><br>
            <input type="submit" value="确定">
        </div>
    </form>
</body>
</html>
