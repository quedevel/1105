<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="f1" action="" method="post">
		<input type="text" name="title" value="title...."> 
		<input type="text" name="content" value="content...."> 
		<input type="text" name="writer" value="writer....">
	</form>
	<button class="regbtn">Register</button>





	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous">
	</script>
	
	<script>
	$(document).ready(function(){
		var f1 = $("#f1");
		$(".regbtn").on("click", function(){
			f1.submit();
		});
	});
	</script>
</body>
</html>