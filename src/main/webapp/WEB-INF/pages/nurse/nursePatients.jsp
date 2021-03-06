<%--
  Created by IntelliJ IDEA.
  User: lushta
  Date: 24.06.14
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
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
    <title><fmt:message key="title" /> </title>
    <link rel="stylesheet" type="text/css" href="css/formatting.css" />
</head>
<body>
<div align="left">
    <table>
        <tr>
            <th><form action="/Hospital/treat" method="post">
                <td><input type="submit" class="button" value=<fmt:message key="provideTreatment" /> ></td>
            </form></th>
            <th><form action="/Hospital/show_doctors" method="post">
                <td><input type="submit" class="button" value=<fmt:message key="staff"/> ></td>
            </form></th>
            <th><form action="/Hospital/logout" method="post">
                <td><input type="submit" class="button" value=<fmt:message key="exit"/> ></td>
            </form></th>
        </tr>
    </table>
</div>

<div id="wrapper">
    <h1><fmt:message key="welcome"/> ${sessionScope.userName}!</h1>
    <h1><fmt:message key="your_patients" /></h1>
    <br><br>
    <table width="40%" cellpadding="5" bordercolor="#000066"
           border="1"   cellspacing="0" align="center">
        <tr >
            <th><fmt:message key="first_name"/></th>
            <th><fmt:message key="surname"/></th>
            <th><fmt:message key="patronymic"/></th>
            <th><fmt:message key="date_of_birth"/></th>
            <th><fmt:message key="address"/></th>
            <th><fmt:message key="phone_number"/></th>
        </tr>
        <c:forEach var="user" items="${users}" >
            <tr style="background-color:#518EA1;"
                onMouseOver="this.style.backgroundColor='blue';"
                onMouseOut="this.style.backgroundColor='#518EA1'"
                onclick="location.href='/Hospital/admissions?patientId=${user.id}'"
                title=<fmt:message key="see_hospitalizations"/> >
                <td><div align="center">  <c:out value="${user.first_name}"/> </div></td>
                <td><div align="center">  <c:out value="${user.surname}"/> </div></td>
                <td><div align="center">  <c:out value="${user.patronymic}"/> </div></td>
                <td><div align="center">  <c:out value="${user.date_of_birth}"/> </div></td>
                <td><div align="center">  <c:out value="${user.address}"/> </div></td>
                <td><div align="center">  <c:out value="${user.phone_number}"/> </div></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

