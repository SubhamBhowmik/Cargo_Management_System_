<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="update" modelAttribute="driver">

 <form:hidden path="id"/>
FirstName : <form:input path="name"/><br><br>

LastName  : <form:input path="licNo"/><br><br>

Email     : <form:input path="email"/> <br><br>


<input type="submit" value="EditDriver">



</form:form>


<a href="viewAll">ViewAllDriver </a>

</body>
</html>