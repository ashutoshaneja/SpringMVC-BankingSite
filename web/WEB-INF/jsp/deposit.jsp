
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEPOSIT</title>
         <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
     <body>
        <jsp:include page="static2.jsp"/>
        <div class="admin">
        <form action="other.htm">
            
            <div class ="container"style="background: rgb(0,0,0,0)">
			<br>
			<div class="row">
                <div class="col-lg-3 col-md-3 col-sm-3"></div>
                <div class="col-lg-4 col-md-4 col-sm-5">
                    <div class="row" >
                        <div class="col-sm-6">
                            
                        </div>
                         <div class="col-sm-6">
                            <b>DEPOSIT MONEY</b>
                        </div>
                    </div>
                </div>
            </div>
            <br><br>
			
			
			
            <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3"></div>
                <div class="col-lg-4 col-md-4 col-sm-5" >
                    <div class="row">
                        <div class="col-sm-6">
                            Account Number
                        </div>
                         <div class="col-sm-6">
                             <input type="text" name="accn"/>
                        </div>
                        </div>
                </div>
            </div>
            <br>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3"></div>
                <div class="col-lg-4 col-md-4 col-sm-5" >
                    <div class="row">
                        <div class="col-sm-6">
                            AMOUNT
                        </div>
                         <div class="col-sm-6">
                            <input type="text" name="amt"/>
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
                            <input type="submit" name ="page" value ="ADD MONEY">
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <h4 align="center" >${userForm.result}</h4>
            </form>
        </div>
    </body>
</html>
