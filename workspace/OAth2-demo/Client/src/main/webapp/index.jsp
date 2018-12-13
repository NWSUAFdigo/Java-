<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>Client</title>
    <script src="static/jquery-3.1.1.min.js"></script>
    <script>
        var params = {};
        params["callBackUrl"] = "http://localhost:8080/client/callBack";

        function QQLaunch() {
            // ajax发送请求
            $.ajax({
                type: "POST",
                url: "/server",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(params),
                success: function (data) {
                    console.log(data);
                }
            });
        }
    </script>
</head>
<body>
<h2>豆瓣</h2>
<form action="qqLogin" method="post">
    <input type="submit" value="QQ登录">
</form>
</body>
</html>
