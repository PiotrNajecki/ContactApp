<%--
  Created by IntelliJ IDEA.
  User: Piotrek
  Date: 2018-11-20
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Page</title>
    <s:url var="url_css" value="/static/css/style.css"></s:url>
    <link href="${url_css}" rel="stylesheet" type="text/css">
</head>
<body>

<h1>Hello World</h1>

<table border="1" width="80%" align="center">
    <tr>
        <td height="80px">
            <%-- Header --%>
            <jsp:include page="include/header.jsp" />
        </td>
    </tr>
    <tr>
        <td height="25px">
            <%-- Menu --%>
            <jsp:include page="include/menu.jsp" />
        </td>
    </tr>
    <tr>
        <td height="350px">
            <%-- Page Content Area --%>
            <h1>User Login</h1>
            <h3>User Login Form</h3>
            <c:if test="${err!=null}">
                <p class="error">${err}</p>
            </c:if>
            <c:if test="${param.act eq 'logout'}">
                <p class="success">Logout Successfully! Thanks for using contact application.</p>
            </c:if>
            <c:if test="${param.act eq 'reg'}">
                 <p class="success">User Registered Sucessfully. Please login.</p>
            </c:if>
            <s:url var="url_login" value="/login"/>
            <f:form action="" modelAttribute="command">
                <table border="1">
                    <tr>
                        <td>Username</td>
                        <td><f:input path="loginName"/></td>
                    </tr>

                    <tr>
                        <td>Password</td>
                        <td><f:password path="password"/></td>
                    </tr>

                    <tr>
                        <td colspan="2" align="right">
                            <button>Login</button></td>
                            <br><a href="#">New User Registration</a>
                    </tr>

                </table>
            </f:form>


        </td>
    </tr>

    <tr>
        <td height="25px">
            <%-- Footer --%>
            <jsp:include page="include/footer.jsp" />
        </td>
    </tr>

</table>
</body>
</html>
