<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = null;
		try{
			String jdbcDriver = "jdbc:apache:commons:dbcp:board";
			conn = DriverManager.getConnection(jdbcDriver);
			if(conn != null){
				out.print("커넥션 풀이 정상적으로 만들어졌고, 풀에 연결되었습니다.");
			}else{
				out.print("커넥션 풀에 연결되지 못했습니다.");
			}
		}finally{
			if(conn != null){
				conn.close();
			}
		}
	%>
</body>
</html>