
<%@page import="controllers.Bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
       
    
      window.onload= function() {
          document.getElementById("myForm").submit();
      };
     

        
  </script>    
       
       </head>
    <body>
    
   
    <form:form action="${other}" commandName="userForm" method="post" id="myForm" name="myForm">
    <form:hidden path="other" value="${param.page}"/>
        <form:hidden path="name" value="${param.name}"/>
        <form:hidden path="acc_no" value="${param.accn}"/>
        <form:hidden path="uname" value="${param.user_name}"/>
        <form:hidden path="pass" value="${param.pass}"/>
        <form:hidden path="email" value="${param.email}"/>
        <form:hidden path="amount" value="${param.ob}"/>
       
        
       </form:form>        
     </body>
</html>
