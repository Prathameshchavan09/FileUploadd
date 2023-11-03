<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>



<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
    <script src="<c:url value="/resources/js/script.js" />"></script>
</head>
<body>
	<h1>File Uplaod</h1>

	<div class="container mt-5">
		<form action="uploadFile" method="POST" enctype="multipart/form-data">
			<div class="form-group">
				<label for="FileValidator">Choose file</label>
				 <input
					type="file" name="fileData" class="form-control-file" id="FileValidator">
			</div>
			
			<button type="submit" onclick="check()"  class="btn btn-outline-success" >Upload</button>
		</form>


	</div>

</body>
</html>