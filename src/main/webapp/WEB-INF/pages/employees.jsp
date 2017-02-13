<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Employees Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>

<!--logout-->
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome ${pageContext.request.userPrincipal.name}
            <br/>
            <a href="" onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>




    <br/>
    <br/>

    <h3>Employees List</h3>

    <c:if test="${!empty listEmployees}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Position</th>
            <th width="120">Salary</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listEmployees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td><a href="/employeedata/${employee.id}">${employee.name}</a></td>
                <td>${employee.position}</td>
                <td>${employee.salary}</td>
                <td><a href="<c:url value='/edit/${employee.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/delete/${employee.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


    <h3>Add new employee</h3>

    <c:url var="addAction" value="/employees/add"/>

    <form:form action="${addAction}" commandName="employee">
    <table>
        <c:if test="${!empty employee.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="position">
                    <spring:message text="Position"/>
                </form:label>
            </td>
            <td>
                <form:input path="position"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="salary">
                    <spring:message text="Salary"/>
                </form:label>
            </td>
            <td>
                <form:input path="salary"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty employee.name}">
                    <input type="submit"
                           value="<spring:message text="Edit employee"/>"/>
                </c:if>
                <c:if test="${empty employee.name}">
                    <input type="submit"
                           value="<spring:message text="Add employee"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
    </c:if>
</div>

</body>
</html>
