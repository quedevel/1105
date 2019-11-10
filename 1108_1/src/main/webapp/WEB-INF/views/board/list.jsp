<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.pageDiv {
	display: flex;
	justify-content: center;
}

.pageDiv ul {
	list-style: none;
	display: flex;
	flex-direction: row;
}

.pageDiv ul li {
	padding-left: 0.3em;
}
</style>
<title>board List</title>
</head>
<body>
	<h1>List Page</h1>
	
	<select id="stype">
		<option value="T" ${pg.dto.type == "T" ? "selected" : ""}>제목</option>
		<option value="C" ${pg.dto.type == "C" ? "selected" : ""}>내용</option>
		<option value="W" ${pg.dto.type == "W" ? "selected" : ""}>작성자</option>
		<option value="TC" ${pg.dto.type == "TC" ? "selected" : ""}>제목+내용</option>
		<option value="CW" ${pg.dto.type == "CW" ? "selected" : ""}>내용+작성자</option>
		<option value="TCW" ${pg.dto.type == "TCW" ? "selected" : ""}>ALL</option>
	</select>
	
	<input type="text" id="skeyword" value="${pg.dto.keyword}">
	
	<button id="searchBt">검색</button>

	<form method="GET" id="f1">
		<input type="hidden" name="page" value="${pg.dto.page}"> 
		<input type="hidden" name="amount" value="${pg.dto.amount}"> 
		<input type="hidden" name="type" value="${pg.dto.type}"> 
		<input type="hidden" name="keyword" value="${pg.dto.keyword}">
	</form>

	<div class="listDiv">
	<ul>
		<c:forEach var="board"  items="${list}">
			<li>
				<div>
					<a href="${pg.dto.getLink(board.bno)}">MOVE</a> 
					<span><c:out value="${board.bno}"></c:out></span>
					<span><a class='bnoLink' href="<c:out value="${board.bno}"></c:out>"><c:out value="${board.title}"></c:out></a></span>
				</div>
			</li>
		</c:forEach>
	</ul>
	</div>

	<div class="pageDiv">
		<ul>
			<c:if test="${pg.prev}">
				<li><a href="${pg.start-1}">이전</a></li>
			</c:if>

			<c:forEach begin="${pg.start}" end="${pg.end}" var="num">
				<li><a href="${num}"> ${num}</a></li>
			</c:forEach>

			<c:if test="${pg.next}">
				<li><a href="${pg.end+1}">다음</a></li>
			</c:if>
		</ul>
	</div>



	<script>

		var msg = '<c:out value="${msg}"/>';
		
		if(msg==='SUCCESS')	alert("작업이 완료되었습니다!");
	
	</script>



	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>

	<script>
		$(document).ready(function() {

			var f1 = $("#f1");

			$(".bnoLink").on("click", function(e) {
				e.preventDefault();
				var bnoValue = $(this).attr("href");
					
				f1.append("<input type=''hidden name='bno' value='"+bnoValue+"'>");
				f1.attr("action", "/board/read");
				f1.attr("target", "_blank");
				f1.submit();
			});
			
			
			$("#searchBt").on("click", function() {
				$("input[name='page']").val(1);

				var inputkeyword = $("#skeyword").val();

				$("input[name='keyword']").val(inputkeyword);

				var inputtype = $("#stype option:selected").val();
				$("input[name='type']").val(inputtype);
				console.log("inputkeyword:" + inputkeyword)
				console.log("inputtype:" + inputtype)

				f1.submit();
			});

			$(".pageDiv ul").on("click", "a", function(e) {
				e.preventDefault();
				console.log("click");

				var pageNum = $(this).attr("href");

				console.log(pageNum);

				$("input[name='page']").val(pageNum);

				f1.submit();

			});
		});
	</script>


</body>
</html>