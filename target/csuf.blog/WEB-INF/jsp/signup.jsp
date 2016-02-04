<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Blog</title>
</head>

    <body style="padding-left: 30%; background-image: url('http://calstate.fullerton.edu/multimedia/2011sp/images/Landsdorf-Hall-from-south-hr.jpg');  background-size: 100% 100%;  background-repeat: no-repeat;">
     <div>
            
    
    <h1> Go to 
  <a href="<c:url value="/blog">
            <c:param name="action" value="publichome" />
        </c:url>">home page</a> </h1>
        
     <div style="position: relative; background: buttonface none repeat scroll 0px 0px; align-self: flex-start; width: 30%; padding: 15%; height: 20%;"> 
           
    

        <h2> Sign up here </h2>
          <%-- <form method="POST" modelAttribute="userForm" action="<c:url value="/signup" />"> --%>
      
      <form:form modelAttribute="Users" method="POST" action="${signup}">
      
      <label for="fname">First Name: </label>
      <form:input path="firstName" id="fname" required="required" />
      <br/><br />
      <label for="lname">Last Name: </label>
      <form:input path="lastName" id="lname" required="required" />
      <br/><br />
      
      <label for="email">E-mail id: </label>
      <form:input path="emailid" id="email"  required="required"/>
      <br/>
      <br />
      <label for="userName">User Name: </label>
      <form:input path="userName" id="userName" required="required" />
      <br/><br />
      <label for="passowrd">Password</label>
      <form:input type="password" path="password" id="password"  required="required"/>
      <br/>   <br />
            
            <input type="submit" value="Submit" />
   
         </form:form>
           <!-- userName, firstName, lastName, emailid, password;
            First name<br />
            <input type="text" name="firstname" required="required" /><br /><br />
           Last name<br />
            <input type="text" name="lastname" required="required" /><br /><br />
            E-mail id<br />
            <input type="text" name="emailid" required="required" /><br /><br />
            Username<br />
            <input type="text" name="username" required="required" /><br /><br />
            
            Password<br />
            <input type="password" name="password" required="required"  /><br /><br />
           
            
             <input type="submit" name= "submit" value="Sign up" />
            
         
         -->
   
         <h2> Already registered Then click here to <a href="#" onclick="callServlet()" name="login">  Login </a></h2>
 
        </div>
  
        
       </div>
            
        <script type="text/javascript">
        function callServlet() {
            document.location.href="\login";
        }
    </script>
    
     </body>
</html>
