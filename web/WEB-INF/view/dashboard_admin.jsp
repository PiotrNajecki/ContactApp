
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Dashboard Page</title>
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
            <h1>AdminDashboard</h1>
            TODO: Admin Options in this page

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
