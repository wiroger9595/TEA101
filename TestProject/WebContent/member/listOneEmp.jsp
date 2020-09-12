<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.spacevent.member.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  MemberVO memberVO = (MemberVO) request.getAttribute("memberVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>會員資料 - listOneEmp.jsp</title>

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
</style>

<style>
  table {
	width: 600px;
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
  
  img {
	max-width: 100px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>會員資料 - ListOneEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

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
	</tr>
	
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
	</tr>
	
	<tr>
		
		<td><%=memberVO.getMember_id()%></td>
		<td><%=memberVO.getMember_account()%></td>
		<td><%=memberVO.getMember_password()%></td>
		<td><%=memberVO.getMember_name()%></td>
		<td><%=memberVO.getMember_nickname()%></td>
		<td><%=memberVO.getMember_email()%></td>
		<td><img src='data:image/png;base64,<%=memberVO.getMember_photo_string()%>'></img></td>
		<td><%=memberVO.getMember_phone()%></td>
		<td><%=memberVO.getMember_address()%></td>
		<td><%=memberVO.getMember_birth()%></td>
		<td><%=memberVO.getMember_sex()%></td>
		<td><%=memberVO.getMember_country()%></td>
		<td><%=memberVO.getMember_signup_date()%></td>
		<td><%=memberVO.getMember_auth()%></td>
		<td><%=memberVO.getMember_status()%></td>
	</tr>
</table>

</body>
</html>