<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.spacevent.member.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    MemberService memberSvc = new MemberService();
    List<MemberVO> list = memberSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有會員資料 - listAllEmp.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
  
  img {
	max-width: 100px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有會員資料 - listAllEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<table>
	<tr>
		
		<th>會員ID</th>
		<th>會員Account</th>
		<th>會員Password</th>
		<th>會員姓名</th>
		<th>會員Nickname</th>
		<th>會員Email</th>
		<th>會員Photo</th>
		<th>會員Phone</th>
		<th>會員Address</th>
		<th>會員Birth</th>
		<th>會員Sex</th>
		<th>會員Country</th>
		<th>會員Sign up date</th>
		<th>會員Auth</th>
		<th>會員Status</th>

		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 

	<c:forEach var="memberVO" items="${list}" begin="0" end="<%=list.size()%>">
		
		<tr>
			
			<td>${memberVO.member_id}</td>
			<td>${memberVO.member_account}</td>
			<td>${memberVO.member_password}</td>
			<td>${memberVO.member_name}</td>
			<td>${memberVO.member_nickname}</td>
			<td>${memberVO.member_email}</td>
			<td><img src='data:image/png;base64, ${memberVO.member_photo_string}'></img></td>
			<td>${memberVO.member_phone}</td>
			<td>${memberVO.member_address}</td>
			<td>${memberVO.member_birth}</td>
			<td>${memberVO.member_sex}</td>
			<td>${memberVO.member_country}</td> 
			<td>${memberVO.member_signup_date}</td>
			<td>${memberVO.member_auth}</td>
			<td>${memberVO.member_status}</td>
			<td>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/MemberServlet" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="member_id"  value="${memberVO.member_id}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/MemberServlet" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="member_id"  value="${memberVO.member_id}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="member_id"  value="${memberVO.member_id}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="member_id"  value="${memberVO.member_id}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td> --%>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>