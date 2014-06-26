<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean class="model.beans.Admission" scope="page"  id="admission"/>
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
    <h1><fmt:message key="admissions"/></h1>
    <br><br>
        <table width="40%" cellpadding="5" bordercolor="#000066"
               border="1"   cellspacing="0" align="center">
            <tr >
                <th><fmt:message key="doctor"/></th>
                <th><fmt:message key="date_of_admission"/></th>
                <th><fmt:message key="date_of_discharge"/></th>
                <th><fmt:message key="diagnosis"/></th>
            </tr>
            <c:forEach var="admission" items="${admissions}" varStatus="loop">
                <c:set var="doctor" value="${doctors[loop.index]}" />
                <tr style="background-color:#518EA1;"
                    onMouseOver="this.style.backgroundColor='blue';"
                    onMouseOut="this.style.backgroundColor='#518EA1'"
                    onclick="location.href='/Hospital/assignments?admissionId=${admission.doctor_id}'"
                    title=<fmt:message key="see_assignments"/>>
                    <td><div align="center">  <c:out value="${doctor}"/> </div></td>
                    <td><div align="center">  <c:out value="${admission.date_of_admission}"/> </div></td>
                    <td><div align="center">  <c:out value="${admission.date_of_discharge}"/> </div></td>
                    <td><div align="center">  <c:out value="${admission.diagnosis}"/> </div></td>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>
