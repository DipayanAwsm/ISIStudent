<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Dipayan</title>
</head>
<body>
	Hi from success data
	${student}
	<c:forEach items="${student}" var="students">
	  Id:<c:out value="${students.roll}"/>
	  Name:<c:out value="${students.name}"/><br/>
	</c:forEach>
</body>
</html>