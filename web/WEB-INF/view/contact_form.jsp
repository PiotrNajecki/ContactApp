<%--
  Created by IntelliJ IDEA.
  User: Piotrek
  Date: 2018-11-28
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
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
            <h3>Contact Form</h3>
            <c:if test="${err!=null}">
                <p class="error">${err}</p>
            </c:if>

            <c:if test="${param.act eq 'logout'}">
                <p class="success">Logout Successfully! Thanks for using contact application.</p>
            </c:if>
            <s:url var="${url_csave}" value="/user/save_contact"/>
            <f:form action="${url_reg}" modelAttribute="command">
                <table border="1">

                    <tr>
                        <td>Name</td>
                        <td><f:input path="user.name"/></td>
                    </tr>

                    <%--<tr>--%>
                        <%--<td>Username</td>--%>
                        <%--<td><f:input path="user.loginName"/></td>--%>
                    <%--</tr>--%>

                    <%--<tr>--%>
                        <%--<td>Password</td>--%>
                        <%--<td><f:password path="user.password"/></td>--%>
                    <%--</tr>--%>

                    <tr>
                        <td>Phone</td>
                        <td><f:input path="user.phone"/></td>
                    </tr>

                    <tr>
                        <td>Email</td>
                        <td><f:input path="user.email"/></td>
                    </tr>

                    <tr>
                        <td>Address</td>
                        <td><f:textarea path="user.address"/></td>
                    </tr>

                    <tr>
                        <td>Remark</td>
                        <td><f:input path="user.remark"/></td>
                    </tr>


                    <tr>
                        <td colspan="2" align="right">
                            <button>Save</button></td>

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
