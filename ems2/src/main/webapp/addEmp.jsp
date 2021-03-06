<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>add Emp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="application/javascript">
        $(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/DepartmentController/queryAllDepartmentsForAddEmp",
                type: "get",
                dataType: "JSON",
                success: function (departments) {
                    for (var i = 0; i < departments.length; i++) {
                        $("#DeptSelect").append("<option value='" + departments[i].id + "'>" + departments[i].name + "</option>");
                    }
                }
            });
        });
    </script>

</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2020-01-01
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">Main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                add Emp info:
            </h1>
            <form action="${pageContext.request.contextPath}/EmployeeController/modifySaveEmployee" enctype="multipart/form-data"
                  method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            ??????:
                        </td>
                        <td valign="middle" align="left">
                            <input type="file" name="upload"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            ??????:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            ??????:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="salary"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            ??????:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="age"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            ??????:
                        </td>
                        <td valign="middle" align="left">
                            <select name="department_id" id="DeptSelect">


                            </select>
                        </td>
                    </tr>


                </table>
                <p>
                    <input type="submit" class="button" value="??????"/>
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
