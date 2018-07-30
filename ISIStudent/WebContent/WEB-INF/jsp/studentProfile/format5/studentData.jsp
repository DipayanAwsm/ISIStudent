<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>StdentCV</title>
</head>
<body>
	<!--Here is the basic info starts  -->
	<pre>1.Basic info:
	   Name-${studentBasicInfo.name}
	   Roll-${studentBasicInfo.roll}
	   about-${studentBasicInfo.about}
	   address-${studentBasicInfo.address}
	   phone-${studentBasicInfo.phoneNumber}
	   email-${studentBasicInfo.emailAddress}
	   DOB-${studentBasicInfo.DOB}
	 </pre> 
	 <pre>1.Work info:
	   -name company
	   -year of ep
	   -address
	   	 </pre>   
	   	 <!--Basic info Ends Here  -->
	   
	   
	   	<!--For Education  -->
	   	 	
	  ${institute}
	  ${studentCV}
	  	 <pre> Hi ${NoSuchStudentInstitute}
	  <c:forEach items="${studentInstitute}" var="studentsInstituteTempData">
	   College Id:<c:out value="${studentsInstituteTempData.institute_id}"/>
	   department:marks:<c:out value="${studentsInstituteTempData.department}"/><br/>
	   Passing year:<c:out value="${studentsInstituteTempData.year_of_passing}"/><br/>
		marks:<c:out value="${studentsInstituteTempData.marks}"/><br/>
		awards:<c:out value="${studentsInstituteTempData.awards}"/><br/>
	
	   </c:forEach>
	 </pre>  
	 
	 
	 
	 
	 <pre>1.Skill info:
	   -name
	 </pre> 
	 <pre>1.Awards info:
	   -name
	   -about	   
	 </pre>  
	 <pre>1.Publication info:
	   -name
	   -about
	   -Year
	 </pre> 
	 <pre>1.Hobby and extra info:
	   -name
	   
	 </pre>    
</body>
</html>