<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<s:url var="url_logout" value="/logout" />
<s:url var="url_reg_form" value="/reg_form" />
<s:url var="url_uhome" value="/user/dashboard" />
<s:url var="url_cform" value="/user/contact_form" />
<s:url var="url_clist" value="/user/clist" />


<c:if test="${sessionScope.userId==null}">
    <%--User is not yet logged in: Guest Menu --%>
    <a href="${url_uhome}">Home</a> | <a href="#">Login</a> | <a href="${url_reg}">Register</a> | <a href="#">Help</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role ==1}" >
    <%-- Admin is logged in: Guest Menu --%>
    <a href="${url_uhome}">Home</a> | <a href="${url_clist}">User List</a> | <a href="${logout}">Logout</a> | <a href="#">Help</a>
    <p>Admin LoggedIn</p>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==2}">

    <%-- User is logged in: User Menu --%>
    <a href="${url_uhome}">Home</a> | <a href="#">Add Contact</a> | <a href="${url_clist}">ContactList</a> | <a href="${logout}">Logout</a> | <a href="#">Help</a>
    <p>User LoggedIN</p>
</c:if>
