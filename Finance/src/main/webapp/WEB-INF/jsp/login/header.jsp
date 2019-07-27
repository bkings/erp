<%
String path = request.getContextPath();
/* String token=session.getAttribute("token").toString(); */
String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJNUyIsImlzcyI6Ik1hbm9qIiwic3ViIjoiQURNSU4iLCJhdWQiOiJBbGwiLCJyb2xlcyI6InVzZXIiLCJpYXQiOjE1NjQxMjI0NjUsImV4cCI6MTU2NDIwODg2NX0.38THJAOchvveCzEKkbEOQGD0GqefyWy0cQzxfTt22hw";
%>
 <!DOCTYPE html>
<html lang="en">
<head>
<title>Welcome User</title><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.css" /><script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.min.js"></script><style>
 .btn-success{height: 26px;}
 .form-control{height: 29px;}
  fieldset {
    border: 1px solid #f89800!important;
    display: table-cell !important;
    padding: 0 15px 25px !important;
    border-top: 1px solid  #f89800 !important;
}
legend {
    padding: 0 15px;
    border: none;
    width: auto;
    font-weight: bold;
    margin: 0;
    font-family: Arial;
    color: #000;
    font-size: 16px;
}
 </style>
 </head>
<body>
 <div class="container">