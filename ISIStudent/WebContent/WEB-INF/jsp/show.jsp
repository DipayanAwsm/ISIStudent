
<!--  must put this v taglib and put the jstl-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >

<head>
<%@ page isELIgnored="false" %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <title>Reading The Data</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
 
  
 <h3>DBMS Project 2017-2018 Taken By <a href="https://www.isical.ac.in/~pinak/"><i >Pinakpani Pal</i></a></h3>                              
  <h4>and Dipayan Das</h4>
  <h3>Table</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>#Tag</th>
        <th>Column2 </th>
        <th>Column3 </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>Please Dont ask </td>
		<th>Whos is this Hello World </th>
      </tr>
      <tr>
        <td>2</td>
        <td>Data </td>
        <td>Data 3</td>
      </tr>
      <tr>
        <td>3</td>
        <td>--</td>
        <td>For Hostel Dudes</td>
      </tr>
      <tr>
        <td>3</td>
        <td>Skd</td>
        <td>Its A ProtoType version
        </td>
      </tr>
    </tbody>
  </table>
</div>


${list}
${columns}

<c:forEach  items="${list}" var="listValue">
				<li>${listValue.list}</li>
			</c:forEach>
from j
#Hi from data

##

   
</body>
</html>
