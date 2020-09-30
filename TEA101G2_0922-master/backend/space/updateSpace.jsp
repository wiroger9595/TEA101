<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.space.model.*"  %>
<%@ page import="java.util.*"%>


<% 
SpaceVO spaceVO = (SpaceVO)request.getAttribute("selectOneUpdate");
LinkedList<String> errorMsgs = (LinkedList<String>) request.getAttribute("errorMsgs");
%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>updateSpace.jsp</title>
</head>

<body>

<h3>資料修改:</h3>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/SpaceServlet" name="form1" enctype="multipart/form-data">
<table>

			<tr>
				<td>場地編碼:</td>
				<td><%=spaceVO.getSpaceId()%></td>
			</tr>
			<tr>
				<td>會員編碼:</td>
				<td><input type="TEXT" name="memberId" size="45" value="<%=spaceVO.getMemberId()%>"/>
				<span style="color:red"><%= (!spaceVO.getMemberId().equals(""))? "" : "  " + errorMsgs.poll()%></span></td>
			</tr>
			<tr>
				<td>員工編碼:</td>
				<td><input type="TEXT" name="empId" size="45" value="<%=spaceVO.getEmpId()%>"/>
				<span style="color:red"><%= (!spaceVO.getEmpId().equals(""))? "" : "  " + errorMsgs.poll()%></span></td>
			</tr>
			<tr>
				<td>場地地址:</td>
				<td><input type="TEXT" name="spaceAddress" size="45" value="<%=spaceVO.getSpaceAddress()%>"/>
				<span style="color:red"><%= (!spaceVO.getSpaceAddress().equals(""))? "" : "  " + errorMsgs.poll()%></span></td>
			</tr>
			<tr>
				<td>場地名稱:</td>
				<td><input type="TEXT" name="spaceName" size="45" value="<%=spaceVO.getSpaceName()%>"/>
				<span style="color:red"><%= (!spaceVO.getSpaceName().equals(""))? "" : "  " + errorMsgs.poll()%></span></td>
			</tr>
			<tr>
				<td>場地類型:</td>
				<td><input type="TEXT" name="spaceType" size="45" value="<%=spaceVO.getSpaceType()%>"/>
				<span style="color:red"><%= (!spaceVO.getSpaceType().equals(""))? "" : "  " + errorMsgs.poll()%></span></td>
			</tr>
			<tr>
				<td>場地設備:</td>
				<td><input type="TEXT" name="spaceEqument" size="45" value="<%=spaceVO.getSpaceEqument()%>"/>
				<span style="color:red"><%= (!spaceVO.getSpaceEqument().equals(""))? "" : "  " + errorMsgs.poll()%></span></td>
			</tr>
			<tr>
				<td>場地容納人數:</td>
				<td><input type="TEXT" name="spaceContain" size="45" value="<%=spaceVO.getSpaceContain()%>"/>
				<span style="color:red"><%= (!spaceVO.getSpaceContain().equals(""))? "" : "  " + errorMsgs.poll()%></span></td>
			</tr>
			<tr>
				<td>場地規範:</td>
				<td><input type="TEXT" name="spaceRule" size="45" value="<%=spaceVO.getSpaceRule()%>"/>
				<span style="color:red"><%= (!spaceVO.getSpaceRule().equals(""))? "" : "  " + errorMsgs.poll()%></span></td>
			</tr>
			<tr>
				<td>退費機制:</td>
				<td><input type="TEXT" name="spaceRefund" size="45" value="<%=spaceVO.getSpaceRefund()%>"/>
				<span style="color:red"><%= (!spaceVO.getSpaceRefund().equals(""))? "" : "  " + errorMsgs.poll()%></span></td>
			</tr>
			<tr>
				<td>場地狀態:</td>
				<td><input type="TEXT" name="spaceStatus" size="45" value="<%=spaceVO.getSpaceStatus()%>"/>
				<span style="color:red"><%= (!spaceVO.getSpaceStatus().equals(""))? "" : "  " + errorMsgs.poll()%></span></td>
			</tr>
			<tr>
				<td>場地申請日期:</td>
				<td><input name="spaceSignupDate" id="spaceSignupDate" type="text" ></td>
			</tr>
			<tr>
				<td>場地上架日期:</td>
				<td><input name="spaceOnsaleDate" id="spaceOnsaleDate" type="text"></td>
			</tr>
			<tr>
				<td>場地下架日期:</td>
				<td><input name="spaceOffsaleDate" id="spaceOffsaleDate" type="text"></td>
			</tr>



		</table>

<br>
<input type="hidden" name="action" value="backend_UpdateSpace">
<input type="hidden" name="spaceId" value="<%=spaceVO.getSpaceId()%>">
<button name="update" value="修改" type="submit" class="update" onclick="javascript:return confirm('確認修改?');">送出修改</button>
<a href='<%=request.getContextPath()%>/backend/space/space.jsp'><input type="button" value="取消修改"></a>

</FORM>



</body>



  <% 
  java.sql.Date spaceSignupDate = new java.sql.Date(System.currentTimeMillis()); 
  java.sql.Date spaceOnsaleDate = new java.sql.Date(System.currentTimeMillis()); 
  java.sql.Date spaceOffsaleDate = new java.sql.Date(System.currentTimeMillis()); 
  %>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/backend/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/backend/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/backend/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
        $.datetimepicker.setLocale('zh');
        $('#spaceSignupDate').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=spaceVO.getSpaceSignupDate()%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        $.datetimepicker.setLocale('zh');
        $('#spaceOnsaleDate').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=spaceVO.getSpaceOnsaleDate()%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        $.datetimepicker.setLocale('zh');
        $('#spaceOffsaleDate').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=spaceVO.getSpaceOffsaleDate()%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
   
        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

        //      1.以下為某一天之前的日期無法選擇
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.以下為某一天之後的日期無法選擇
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
        
        
</script>
</html>