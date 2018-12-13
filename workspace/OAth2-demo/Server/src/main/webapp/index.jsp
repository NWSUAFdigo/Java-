<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <title>Server</title>
</head>
<body>
<h2>QQ授权</h2>
<h4>来源: ${param.source}</h4>
<form action="authLogin" method="post">
    账号: <input type="text" placeholder="请输入QQ账号" name="account"><p/>
    密码: <input type="password" placeholder="请输入QQ密码" name="pwd"><p/>
    <input type="hidden" value="${param.callBackUrl}" name="callBackUrl">
    <input type="hidden" value="${param.source}" name="source">
    <input type="submit" value="登录并授权"> ${requestScope.errorMsg}
</form>
</body>
</html>
