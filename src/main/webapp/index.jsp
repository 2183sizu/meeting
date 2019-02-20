<%--
  Created by IntelliJ IDEA.
  User: 钟家龙
  Date: 2019-01-15
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
<script src="js/jquery-1.12.4.js" type="text/javascript"></script>
    <script type="text/javascript">
       $(function () {
            $("#one").css("background","darkgrey")
           $("table tr:first").css("font-size","20px")
           $("table tr:odd").css("background","aqua")
           $("#mess").css({"width":"400px","text-align":"center"})
       })
        </script>

</head>
<body>
    <table border="1" id="mess">
        <tr id="one">
            <td width="100px">预定编号</td>
            <td width="100px">会议室</td>
            <td width="100px">预订人</td>
            <td width="100px">日期</td>
        </tr>
        <c:forEach items="${list}" var="mett">
            <tr>
                <td>${mett.id}</td>
                <td>${mett.meeting_name}</td>
                <td>${mett.meeting_order}</td>
                <td>${mett.advance_name}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="add.jsp">预定会议室</a>

</body>
</html>
。