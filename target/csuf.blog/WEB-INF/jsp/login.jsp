<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        
             <div style="position: relative; background: buttonface none repeat scroll 0px 0px; align-self: flex-start; width: 222px; padding: 15%; height: 20%;"> 
           <%--   <%
            if(((Boolean)request.getAttribute("loginFailed")))
            {
                %>
        <b>The username or password you entered are not correct. Please try again.</b><br /><br />
                <%
            }
        
            else    if(((Boolean)request.getAttribute("new")))
        {
            %>
    <b>You have successfully registered in Titan Blog. Please Enter the login Credentials   </b><br /><br />
            <%
        }
            else
            { %>
            <b>Enter the login credentials  </b><br /><br />
           <% 	
            }
        %> --%>
        <c:if test="${not empty msg}">
		   
			<strong>${msg}</strong>
		   
		</c:if>
		<br/>
		<br/>
		
		
        <form method="POST" action="/csuf.blog/login">
            Username <br>
            <input type="text" required="required" name="username"><br><br>
            Password <br>
            <input type="password" required="required" name="password"><br><br>
            <input type="submit" name="submit" value="Log In">
        </form>
         <h2> Not registered Then <a href="<c:url value="/signup">
            <c:param name="action" value="signup" />
        </c:url>">click here to Register</a> </h2>
   
        
</div>
  
        
       </div>
            
        
        <script type="text/javascript">
        function callServlet() {
            document.location.href="\login";
        }
    </script>
   
        
       
    </body>
</html>
