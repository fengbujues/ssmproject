<%@ page import="org.study.entity.Linkman" %><%--
  Created by IntelliJ IDEA.
  User: 刘洋
  Date: 2019/3/2
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page isELIgnored="false" %>--%>

<html>
<head>
    <title>结果</title>
</head>
<body>
<%
    Linkman linkman =(Linkman)request.getAttribute("linkman");

%>
<br>
${requestScope.get("linkman")}<br>
${requestScope.linkman.id}<br>
${requestScope.linkman.name}<br>
${requestScope.linkman.age}<br>
${requestScope.linkman.tel}<br>
${requestScope.linkman.address}<br>

${requestScope.message}<br>

${requestScope.linkmans[1].id}<br>
${requestScope.linkmans[1].name}<br>
${requestScope.linkmans[1].age}<br>
${requestScope.linkmans[1].tel}<br>
<script>
    var list = '${requestScope.linkmans}';
    console.log(list[1])
    console.log(list[1].id)
    for(var i;i<list.length;i++)
    {
        document.write(list[i].id)
        document.write(list[i].name)
        document.write("<br>")
    }
</script>
</body>
</html>
