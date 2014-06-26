<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean class="model.beans.Admission" scope="page"  id="admission"/>
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
    <table>
        <tr>
            <th><form action="/Hospital/start_page" method="post" >
                <input type="submit" class="button" value=<fmt:message key="main_page" /> >
            </form></th>
            <th><form action="/Hospital/show_doctors" method="post">
                <input type="submit" class="button" value=<fmt:message key="staff" /> >
            </form></th>
            <th><form action="/Hospital/logout" method="post">
                <input type="submit" class="button" value=<fmt:message key="exit" /> >
            </form></th>
        </tr>
    </table>
</div>
<div id="wrapper">
    <h1><fmt:message key="welcome" /> ${sessionScope.userName}!</h1>
    <c:choose>
        <c:when test="${empty admissions}">
            <h2><fmt:message key="no_admissions" /></h2>
        </c:when>
        <c:otherwise>
            <c:set var="user" value="${patient}"/>
            <h1><fmt:message key="patient_admissions" /> ${user.first_name} ${user.surname}:</h1>
            <br><br>
            <table width="40%" cellpadding="5" bordercolor="#000066"
            border="1"   cellspacing="0" align="center">
            <tr >
                <th><fmt:message key="date_of_admission" /></th>
                <th><fmt:message key="date_of_discharge" /></th>
                <th><fmt:message key="diagnosis" /></th>
                <th><fmt:message key="actions" /></th>
            </tr>
            <c:forEach var="admission" items="${admissions}">
                <tr style="background-color:#518EA1;"
                    onMouseOver="this.style.backgroundColor='blue';"
                    onMouseOut="this.style.backgroundColor='#518EA1'"
                    onclick="location.href='/Hospital/assignments?admissionId=${admission.id}'"
                    title=<fmt:message key="see_assignments" />>
                    <td><div align="center">  <c:out value="${admission.date_of_admission}"/> </div></td>
                    <td><div align="center">  <c:out value="${admission.date_of_discharge}"/> </div></td>
                    <td><div align="center">  <c:out value="${admission.diagnosis}"/> </div></td>
                    <td>
                        <c:if test='${admission.date_of_discharge == null}'>
                            <form action="/Hospital/get_form_discharge_patient" method="post">
                                <input type="hidden" name="admissionId" value="${admission.id}">
                                <input type="submit" value=<fmt:message key="discharge" />>
                            </form>
                            <form action="/Hospital/get_form_prescribe_treatment" method="post">
                                <input type="hidden" name="admissionId" value="${admission.id}">
                                <input type="submit" value=<fmt:message key="add_treatment" />>
                            </form>
                        </c:if>
                        <c:if test='${admission.date_of_discharge != null}'>
                            <fmt:message key="discharged" />
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>