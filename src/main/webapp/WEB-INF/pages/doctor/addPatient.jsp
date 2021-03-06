<%--
  Created by IntelliJ IDEA.
  User: lushta
  Date: 24.06.14
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle basename='Messages'/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <title>Hospital</title>
    <link rel="stylesheet" type="text/css" href="css/formatting.css" />
</head>
<body>
<div align="left">
    <table>
        <tr>
            <th><form action="/Hospital/start_page" method="post" >
                <input type="submit" class="button" value=<fmt:message key="main_page"/>>
            </form></th>
            <th><form action="/Hospital/logout" method="post">
                <input type="submit" class="button" value=<fmt:message key="exit"/>>
            </form></th>
        </tr>
    </table>
</div>
<div id="wrapper">
    <h1><fmt:message key="add_patient"/></h1>
    <form action="/Hospital/insert_patient" method="post">
        <table style="margin: auto">
            <tr>
                <td style="text-align: left"><fmt:message key="surname"/></td>
                <td><input name="surname" type="text" size="20" required ></td>
            </tr>
            <tr>
                <td style="text-align: left"><fmt:message key="first_name"/></td>
                <td><input name="first_name" type="text" size="20" required ></td>
            </tr>
            <tr>
                <td style="text-align: left"><fmt:message key="patronymic"/></td>
                <td><input name="patronymic" type="text" size="20" required ></td>
            </tr>
            <tr>
                <td style="text-align: left"><fmt:message key="date_of_birth"/></td>
                <td><input name="date_of_birth" type="date" required ></td>
            </tr>
            <tr>
                <td style="text-align: left"><fmt:message key="address"/></td>
                <td><input name="address" type="text" size="20" required ></td>
            </tr>
            <tr>
                <td style="text-align: left"><fmt:message key="phone_number"/></td>
                <td><input name="phone_number" type="text" size="20" required ></td>
            </tr>
            <tr>
                <td style="text-align: left"><fmt:message key="login"/></td>
                <td><input name="login" type="text" size="20" required ></td>
            </tr>
            <tr>
                <td style="text-align: left"><fmt:message key="password"/></td>
                <td><input name="password" type="password" size="20" required ></td>
            </tr>
        </table>
        <table style="margin: auto">
            <tr>
                <td><input type="submit" class="button" value=<fmt:message key="add_patient" /> ></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
