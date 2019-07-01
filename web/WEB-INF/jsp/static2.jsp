
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="../../../../../../../C:/Users/HP/AppData/Local/Temp/DEPOSIT.url"></a>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MAK ADMIN ACCESS AREA</title>
         <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css"> 
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
</head>

      <style>
      body, html {
 background: #50a3a2;
  background: linear-gradient(to bottom right, #50a3a2 0%, #53e3a6 100%);
  height: 100%;
}

h1 {
  height: auto;
  display: table;
  width: 80%;
  text-align: center;
  overflow: auto;
  margin: auto;
  position: absolute;
  left: 0;
  bottom: 82px;
  right: 0;
  color: white;
  font-family: 'Raleway', sans-serif;
  font-weight: 300;
  font-size: 3em;
}

h2 {
  position: fixed;
  text-align: center;
  top: 582px;
  right: 54px;
  color: white;
  font-size: 20px;
  font-family: Roboto;
  font-weight: normal;
  z-index: 999;
}
#asd {
  position: fixed;
  text-align: center;
  left: 0;
  bottom: 13px;
  right: 0;
  color: white;
  font-size: 20px;
  font-family: Roboto;
  font-weight: normal;
  z-index: 999;
}
h2 span {
  font-size: 15px;
  font-weight: lighter;
}
h2 a {
  color: white;
  font-size: 15px;
  padding: 0 30px;
}

    </style>

<body>

      <script  src="js/background.js"></script>
        <div class="background"></div>>
    
        <form action="other.htm">
        <div class="container">      
            <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
          <li class="active"><a href="#"  data-toggle="tooltip" data-placement="bottom" title="Hey, Admin !">
                  <b>MAK BANK ADMIN</b></a></li>
          <li><button class="btn btn-link navbar-btn"><input type="submit" name="page" value="DEPOSIT"/></button></li>
        
          <li><button class="btn btn-link navbar-btn"><input type="submit" name="page" value="WITHDRAW"/></button></li> 
        <form action="other_1.htm">
            <li><button class="btn btn-link navbar-btn"><input type="submit" name="page" value="MAKE ACCOUNT"/></button></li> 
            <li><button class="btn btn-link navbar-btn"><input type="submit" name="page" value="DELETE ACCOUNT"/></button></li> 
        </form>
        
        <ul class="nav navbar-nav navbar-right">
        <li><a href="welcome.htm"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
      </ul>
        
      </ul>
    
    </div>
  </div>
</nav>
        </div>
<h1>ADMIN ACCESS AREA </h1>
<center>
    <h2 id="asd">MAK BANK -  <font style="color: red">HUM SAB KA SAATHI</font></h2>
</center>

<h2><span>Current LoggedIn Account : </span><font style="color: black; text-transform: uppercase"> ${userForm.branch}</font></h2>
        </form>     
    
       <script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
        
</body>
</html>
