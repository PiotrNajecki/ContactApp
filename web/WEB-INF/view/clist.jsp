<%--
  Created by IntelliJ IDEA.
  User: Piotrek
  Date: 2018-11-28
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contact - Contact Application</title>
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
            <h1>Contact List</h1>
            <c:if test="${param.act eq 'sv'}">
                <p class="success">Contact Saved Successfully</p>

            </c:if>

            <c:if test="${param.act eq 'del'}">
                 <p class="success">Contact Deleted Successfully</p>
            </c:if>

            <table border = "1" cellpadding="3">
                <tr>
                    <th>SR</th>
                    <th>CID</th>
                    <th>NAME</th>
                    <th>PHONE</th>
                    <th>ADDRESS</th>
                    <th>REMARK</th>
                    <th>ACTION</th>
                </tr>
                <c:if test="${empty contactList}">
                    <tr>
                        <td colspan="8" class="error">No Records Present</td>
                    </tr>
                </c:if>

                <c:forEach items="${contactList}" varStatus="st">
                    <td>${st.count}</td>
                    <td>${c.contactId}</td>
                    <td>${c.name}</td>
                    <td>${c.phone}</td>
                    <td>${c.address}</td>
                    <td>${c.remark}</td>
                <s:url var="url_delete" value="/user/del_contact" >
                       <s:param name="cid" value="${c.contactId}" />
                </s:url>

                <s:url var="url_edit" value="/user/edit_contact" >
                       <s:param name="cid" value="${c.contactId}" />
                </s:url>
                    <td><a href="${url_edit}">Edit</a> | <a href="${url_delete}">Delete</a></td>
                </c:forEach>


            </table>





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
