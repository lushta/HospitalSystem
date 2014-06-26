<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean class="model.beans.User" scope="page"  id="user"/>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle basename='Messages'/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <title>Hospital</title>
    <link rel="stylesheet" type="text/css" href="css/formatting.css" />
</head>
<body>
<div align="left">
    <table><tr>
        <th><form action="/Hospital/start_page" method="post">
            <td><input type="submit" class="button" value=<fmt:message key="main_page"/>></td>
        </form></th>
        <th><form action="/Hospital/logout" method="post">
            <td><input type="submit" class="button" value=<fmt:message key="exit"/>></td>
        </form></th>
    </tr></table>
</div>
<div id="wrapper">
    <h1><fmt:message key="welcome"/> ${sessionScope.userName}!</h1>
    <h1><fmt:message key="yours_doctors"/></h1>
    <br><br>
    <table width="40%" cellpadding="5" bordercolor="#000066"
           border="1"   cellspacing="0" align="center">
        <tr >
            <th><fmt:message key="first_name"/></th>
            <th><fmt:message key="surname"/></th>
            <th><fmt:message key="patronymic"/></th>
            <th><fmt:message key="date_of_birth"/></th>
            <th><fmt:message key="phone_number"/></th>
        </tr>
        <c:forEach var="user" items="${users}" >
            <tr >
                <td><div align="center"><b>  <c:out value="${user.first_name}"/> </b></div></td>
                <td><div align="center"><b>  <c:out value="${user.surname}"/> </b></div></td>
                <td><div align="center"><b>  <c:out value="${user.patronymic}"/> </b></div></td>
                <td><div align="center"><b>  <c:out value="${user.date_of_birth}"/> </b></div></td>
                <td><div align="center"><b>  <c:out value="${user.phone_number}"/> </b></div></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>