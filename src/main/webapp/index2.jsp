<%--
  Created by IntelliJ IDEA.
  User: 刘洋
  Date: 2019/3/6
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/jquery-3.3.1.js">
</script>
<body>
<input type="text" name="" id="mobile">
<button>注册</button>
</body>
<script>
    $("button").click(function () {
       var mobile = $("#mobile").val()
        //返回值为json对象
        $.getJSON(
            "/testAjax.form",
            {"mobile":mobile,"name":"刘洋"},
            function (result) {
                alert(result.message)
                if(result.message=="true"){
                    alert("该号码已存在")
                }else{
                    alert("注册成功")
                }
            }
        )
    })
</script>
</html>
