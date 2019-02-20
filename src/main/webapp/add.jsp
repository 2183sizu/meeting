<%--
  Created by IntelliJ IDEA.
  User: 钟家龙
  Date: 2019-01-15
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    <script type="text/javascript">
        $(function () {
            $("table tr:first").css("font-size","20px")
            $("table tr:first").css("background","blue")

            $("[type=submit]").click(function () {
                if($("#shen").val()==""||$("#riqi").val()=="") {
                    alert("不能为空");
                    return false;
                }
                var reg=/^\d{4}-(0?[1-9]|1[0-2])-\d{2}$/;
                var riqi= $("#riqi").val();
                if(!reg.test(riqi)){
                    alert("日期格式不正确");
                    return false;
                }
                return true;
            })
        })
    </script>
</head>
<body>
<form action="add" method="post">
    <table border="1">
        <tr>
            <td colspan="3">会议室预定</td>
        </tr>
        <tr>
            <td>会议室</td>
            <td colspan="2">
                <select name="xiala" id="xiala">
                    <option value="会议室一">会议室一</option>
                    <option value="会议室二">会议室二</option>
                    <option value="会议室三">会议室三</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>申请人</td>
            <td colspan="2">
                <input type="text" id="shen" name="shen" >
            </td>
        </tr>
        <tr>
            <td>预定日期</td>
            <td colspan="2">
                <input type="text" id="riqi" name="riqi" >
                日期格式是：yyyy-mm-dd</td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="申请">
                <input type="button" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>


</body>
</html>
