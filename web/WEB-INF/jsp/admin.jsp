
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN LOGIN</title>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
     <body>
        <jsp:include page="static.jsp"/>
        <div class="admin">
        <form:form action="${register}" commandName="userForm" method="post">
            
            <div class ="container" style="background: rgb(0,0,0,0)">
			<br>
			<div class="row">
                <div class="col-lg-3 col-md-3 col-sm-3"></div>
                <div class="col-lg-4 col-md-4 col-sm-5">
                    <div class="row" >
                        <center>
                             <h3><b>ADMIN LOGIN</b></h3>
                        </center>
                    </div>
                </div>
            </div>
            <br><br>
	
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-3"></div>
                <div class="col-lg-4 col-md-4 col-sm-5">
                    <div class="row" >
                        <div class="col-sm-6">
                           Select Branch
                        </div>
                         <div class="col-sm-6">
                            <form:input path="branch" required="true" />
                        </div>
                    </div>
                </div>
            </div>
            <br>	
          
        
            
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-3"></div>
                <div class="col-lg-4 col-md-4 col-sm-5">
                    <div class="row" >
                        <div class="col-sm-6">
                           Password
                        </div>
                         <div class="col-sm-6">
                            <form:password path="pass" required="true" />
                        </div>
                    </div>
                </div>
            </div>
            <br>
            
           <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-3"></div>
                <div class="col-lg-4 col-md-4 col-sm-5">
                    <div class="row" >
                        <div class="col-sm-6">
                           
                        </div>
                         <div class="col-sm-6">
                             <center>
                                 <input type="submit"  value ="LOGIN"></center>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <h3 align="center" >${userForm.result}</h3>
            </form:form>
            </div>
    </body>
</html>
