<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/">
  <title>InterComm</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-route.js"></script>
  
  
  <!-- <script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.8/angular-ui-router.min.js"></script> -->
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.3/angular-ui-router.min.js"></script>
  
  
  

  
  
  <script type="text/javascript" src="resources/js/app.js"></script>
  <script type="text/javascript" src="resources/js/directives/interCommHeader.js"></script>
  <script type="text/javascript" src="resources/js/directives/interCommFooter.js"></script> 
 <script type="text/javascript" src="resources/js/routes.js">  </script>
 <script type="text/javascript" src="resources/js/studentloginctrl.js">  </script>
 
 <script type="text/javascript" src="resources/js/controller/facultyctrl.js">  </script>
 <!--  smart table -->
      <script src="resources/js/lib/smart-table/script.js"></script>
      <script src="resources/js/lib/smart-table/lrDragNDrop.js"></script>
     <script src="resources/js/lib/smart-table/smart-table.debug.js"></script>
     <link rel="stylesheet" href="resources/js/lib/smart-table/style.css">
  
</head>
<body>
<h1>Welcome 2 intercomm JSP !!!!</h1>
<body ng-app="intercomm">

<intercomm-header></intercomm-header>
					
<div ui-view autoscroll="true"></div>
					
					Footer
<intercomm-footer></intercomm-footer>

</body>
</body>
</html>