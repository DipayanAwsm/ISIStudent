

<!--  must put this v taglib and put the jstl-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >

<head>
  <title>Upload Page The Data</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body, html {
    height: 100%;
    margin: 0;
}

.bg {
    /* The image used */
    background-image: url("img_girl.jpg");

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
</style>


</head>
<body>

	
  <h3>DBMS Project 2017-2018 Taken By <a href="https://www.isical.ac.in/~pinak/"><i >Pinakpani Pal</i></a></h3>                              
	
		<form class="form-horizontal">
	    <div class="form-group">
	    Its the Upload Page
	        <div class="col-sm-offset-2 col-sm-10">
	            <label class="file-upload btn btn-primary">
	                Browse for file ... <input type="file" />
	            </label>
	        </div>
	    </div>
		</form>
		<!--Here is  place where is file uploaded   -->
		<form action="upload/saveFile" method="post" enctype="multipart/form-data">  
		Select File: <input type="file" name="file"/>  
		<input type="submit" value="Upload File"/>  
		</form>
		
		
		

</body>

