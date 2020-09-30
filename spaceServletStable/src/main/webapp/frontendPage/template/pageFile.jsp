<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.sql.*" %>


<script language="javascript">
function newwin(url) {
var
newwin=window.open(url,"newwin","toolbar=no,location=no,directories=no,status=no, menubar=no,scrollbars=yes,resizable=yes,width=600,height=450");
newwin.focus();
return false;
}
</SCRIPT>
<script LANGUAGE="javascript">
function submit10()
{
self.location.replace("fenye1.jsp")
}
</SCRIPT>
<%//變量聲明
java.sql.Connection sqlCon; //數據庫連接對象
java.sql.Statement sqlStmt; //SQL語句對象
java.sql.ResultSet sqlRst; //結果集對象
java.lang.String strCon; //數據庫連接字符串
java.lang.String strSQL; //SQL語句
int intPageSize; //一頁顯示的記錄數
int intRowCount; //記錄總數
int intPageCount; //總頁數
int intPage; //待顯示頁碼
java.lang.String strPage;
int i;
//設置一頁顯示的記錄數
intPageSize = 4;
//取得待顯示頁碼
strPage = request.getParameter("page");
if(strPage==null){//表明在QueryString中沒有page這一個參數，此時顯示第一頁數據
intPage = 1;
}
else{//將字符串轉換成整型
intPage = java.lang.Integer.parseInt(strPage);
if(intPage<1) intPage = 1;
}
//裝載JDBC驅動程序
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//設置數據庫連接字符串
strCon = "jdbc:odbc:heyang";
//連接數據庫
sqlCon = java.sql.DriverManager.getConnection(strCon,"sa","");
//創建一個可以滾動的只讀的SQL語句對象
sqlStmt =
sqlCon.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);//准備SQL語句
strSQL = "select user_id,user_name from userinfo order by user_id desc";
//執行SQL語句並獲取結果集
sqlRst = sqlStmt.executeQuery(strSQL);
//獲取記錄總數
sqlRst.last();//??光標在最後一行
intRowCount = sqlRst.getRow();//獲得當前行號
//記算總頁數
intPageCount = (intRowCount+intPageSize-1) / intPageSize;
//調整待顯示的頁碼
if(intPage>intPageCount) intPage = intPageCount;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>會員管理</title>
</head>
<body>
<form method="POST" action="fenye1.jsp">
第<%=intPage%>頁 共<%=intPageCount%>頁
<%if(intPage<intPageCount){%><a
href="fenye1.jsp?page=<%=intPage+1%>">下一頁
</a><%}%> <%if(intPage>1){%><a href="fenye1.jsp?page=<%=intPage-1%>">
上一頁</a><%}%>
轉到第:<input type="text" name="page" size="8"> 頁
<span><input class=buttonface type='submit' value='GO' name='cndok'></span>
</form>
<table border="1" cellspacing="0" cellpadding="0">
<tr>
<th>用戶名</th>
<th width='8%'>刪除</th>
</tr>
<%
if(intPageCount>0){
//將記錄指針定位到待顯示頁的第一條記錄上
sqlRst.absolute((intPage-1) * intPageSize + 1);
//顯示數據
i = 0;
String user_id,user_name;
while(i<intPageSize && !sqlRst.isAfterLast()){
user_id=sqlRst.getString(1);
user_name=sqlRst.getString(2);
%>
<tr>
<td><%=user_id%></td>
<td><%=user_name%></td>
<td width='8%' align='center'><a href="delete.jsp?user_id=<%=user_id%>"
onClick="return newwin(this.href);">刪除</a></td>
</tr>
<%
sqlRst.next();
i++;
}
}
%>
</table>
</body>
</html>
<%
//關閉結果集
sqlRst.close();
//關閉SQL語句對象
sqlStmt.close();
//關閉數據庫
sqlCon.close();
%>