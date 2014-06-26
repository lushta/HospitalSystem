<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean class="model.beans.Assignment" scope="page"  id="assignment"/>
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
    <table>
    <tr>
        <th><form action="/Hospital/start_page" method="post" >
            <input type="submit" class="button" value=<fmt:message key="main_page"/>>
        </form></th>
        <th><form action="/Hospital/show_doctors" method="post">
            <input type="submit" class="button" value=<fmt:message key="yours_doctors"/>>
        </form></th>
        <th><form action="/Hospital/logout" method="post">
            <input type="submit" class="button" value=<fmt:message key="exit"/>>
        </form></th>
    </tr>
    </table>
</div>
<div id="wrapper">
    <h1><fmt:message key="welcome"/> ${sessionScope.userName}!</h1>
    <c:choose>
    <c:when test="${empty assignments}">
        <h2><fmt:message key="no_assignments"/></h2>
    </c:when>
    <c:otherwise>
        <h1><fmt:message key="assignments"/></h1>
        <br><br>
        <table width="40%" cellpadding="5" bordercolor="#000066"
               border="1"   cellspacing="0" align="center">
            <tr >
                <th><fmt:message key="name"/></th>
                <th><fmt:message key="type"/></th>
                <th><fmt:message key="date_of_execution"/></th>
                <th><fmt:message key="performer"/></th>
            </tr>
            <c:forEach var="assignment" items="${assignments}" varStatus="loop">
                <c:set var="performer" value="${staff[loop.index]}" />
                <tr >
                    <td><div align="center"><b>  <c:out value="${assignment.name}"/> </b></div></td>
                    <td><div align="center"><b>  <c:out value="${assignment.type}"/> </b></div></td>
                    <td><div align="center"><b>  <c:out value="${assignment.date_of_execution}"/> </b></div></td>
                    <td><div align="center"><b>  <c:out value="${performer}"/> </b></div></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
    </c:choose>
</div>
</body>
</html>