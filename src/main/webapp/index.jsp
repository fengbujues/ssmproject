<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
<script src="js/jquery-1.11.0.js"></script>
<script>
    function change() {
        $mobile = $("#phone").val()

        // alert($mobile)
        $.ajax({
            url:"/testAjax.form",
            type:"post",
            data:"mobile="+$mobile,
            datatype:"text",
            success:function (result,testStatus) {
                alert(result)

            }
        })
    }

    function bu() {
        $.post(
            "/jsonajax.form",
            function (result) {
                for (var i = 0; i < result.length; i++) {
                    alert(result[i].id+","+result[i].name+","+result[i].age)
                }
            }
        )
    }
    $("#bu2").click(function () {
        $mobile = $("#mobile").val()
        console.log($mobile)
        $("#tip").load(
            "/testAjax.form",
            "mobile="+$mobile
        )
    })
    function bu2() {
        $mobile = $("#mobile").val()
        console.log($mobile)
        //默认是get方式提交，返回数据直接在调用它的dom对象中间，目前中文会乱码
        $("#tip").load(
            "/testAjax.form",
            "mobile="+$mobile
        )
    }
</script>
<body>
<input type="text" id="mobile"><button id="bu2" onclick="bu2()">注册</button>
<span id="tip"></span>
<button id="bu" onclick="bu()">点击查询</button>
<h2>Hello World!</h2>
请输入要查询的学生的id:
<form action="/QueryLinkmanById.form">
<input type="text" name="id">
<input type="submit" value="查询">
</form>

<form action="/AddLinkman.form">
    id:<input type="text" name="id">
    姓名:<input type="text" name="name">
    年龄:<input type="text" name="age">
    电话号码:<input type="text" name="tel">
    地址:<input type="text" name="address">
    <input type="submit" value="添加">
</form>

<button><a href="/queryAllLinkman.form" style="text-decoration: none;font-size: 16px;color: red">查询所有</a></button>

<form action="/deleteLinkmanByid.form">
    请输入要删除的联系人的id:
    <input type="text" name="id">
    <input type="submit" value="删除">
</form>

<input type="text" id="phone">
<button type="submit" onclick="change()">注册</button>

<%--<form action="/testAjax.form" method="post">--%>
    <%--<input type="text" name="mobile">--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>

</body>
</html>
