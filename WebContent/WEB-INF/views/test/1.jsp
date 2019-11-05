<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="test" value="aaa"/>

${test}<br>

<%
pageContext.setAttribute("msg", "난 페이지");
request.setAttribute("msg", "난 request,응답이 끝나면 사라짐");
session.setAttribute("msg","난 session,세션이 끊길 때까지 유지됨");
//session.invalidate();
application.setAttribute("msg","난 application,서버 꺼질때까지 유지됨");
//RequestDispatcher rd = request.getRequestDispatcher("/views/test/2");
//rd.forward(request,response);
%>
${msg}	