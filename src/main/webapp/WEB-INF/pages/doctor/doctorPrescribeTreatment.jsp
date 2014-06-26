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
    <h1><fmt:message key="prescribe_treatment"/></h1>
    <form action="/Hospital/prescribe_treatment" method="post">
        <table style="margin: auto">
            <tr>
                <td style="text-align: left"><fmt:message key="name"/></td>
                <td><input name="name" type="text" size="20" required ></td>
            </tr>
            <tr>
                <td style="text-align: left"><fmt:message key="type"/></td>
                <td>
                    <input type="radio" name="type" value="surgery"><fmt:message key="surgery"/><Br>
                    <input type="radio" name="type" value="medicament"><fmt:message key="medicament"/><Br>
                    <input type="radio" name="type" value="procedure"><fmt:message key="procedure"/><Br>
                </td>
            </tr>
            <tr>
                <td style="text-align: left"><fmt:message key="date"/></td>
                <td><input name="date" type="date" required ></td>
            </tr>
            <tr>
                <td></td>
                <td><input name="time" type="time" required ></td>
            </tr>
        </table>
        <table style="margin: auto">
            <tr>
                <td><input type="submit" class="button" value=<fmt:message key="prescribe" /> ></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>