<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<a href="PhotoFilter?is_labelphoto=true">
		Is popular
	</a><br />
	<a href="PhotoFilter">
		Is not popular
	</a><br />
<%-- 	<%
		List<Space_SpacePhotoVO> list = (List<Space_SpacePhotoVO>) request.getAttribute("titlePhoto");
		for (Space_SpacePhotoVO spaceSpacePhotoVO : list) {
		%>
			ID:<%= spaceSpacePhotoVO.getSpaceId() %>
			PhotoID:<%= spaceSpacePhotoVO.getSpacePhotoId() %>
			<br />
		<%
		}
	%> --%>
</body>
</html>