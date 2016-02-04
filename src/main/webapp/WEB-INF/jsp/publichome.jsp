<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
      <%@ page import="com.csuf.Model.Blog" %>
   <%@ page import="java.util.List" %>
<%-- <%
    @SuppressWarnings("unchecked")
   List<Blog> blogdatabase=(List<Blog>)request.getAttribute("blogDatabase");
%> --%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <body style=" background-image: url('http://calstate.fullerton.edu/multimedia/2011sp/images/Landsdorf-Hall-from-south-hr.jpg');  background-size: 100% 100%; background-attachment:fixed;  background-repeat: no-repeat;">
    <div style="padding-left: 80%;">
<script type="text/javascript">
        function callServlet() {
            document.location.href="\login";
        }
    </script>
    <h1 style="font-size:20pt; color:black ">
 <a href="#" onclick="callServlet()" name="login"> LOGIN </a>
 &nbsp; &nbsp; &nbsp; &nbsp; 
  <a href="<c:url value="/signup">
            <c:param name="action" value="signup" />
        </c:url>">SIGNUP</a>  </h1>
        </div>
        <div style="padding-left: 20%;">
             
     <div style="position: relative; background: buttonface none repeat scroll 0px 0px; align-self: flex-start; width: 60%	; padding: 5%; height: 20%;"> 
       
  <h1> Welcome Guest </h1><br>

<div >
 <br>
  
         <%
    int total = 10;
    
%>
         <%
            if(total == 0)
            {
                %><i>there are no posts available</i><%
            }
            else
            {
            %>	 
            
            <c:forEach items="${blogdatabase}" var="blogdatabase">     
   <hr><hr>
   
   <h1> <c:out value="${blogdatabase.userName}"/> </h1> <c:out value="${blogdatabase.date}"/> <br>
   <h2> <i><u> <c:out value="${blogdatabase.title}"/></u></i></h2>
   <c:out value="${blogdatabase.description}"/>  
</c:forEach>
              <%--  for(Blog obj : blogdatabase){
               
                    
                   --%>
                 <%--    <h1> <%=obj.getUserName() %></h1>   <%=obj.getDate() %><br>
                   <h2><i><u>
                    <%=obj.getTitle() %></u>
                   </i></h2>
                   <%=obj.getDescription() %>
                   <hr><hr>
                    
                    
      <%
                } %> --%>
                <%
                
            }
        %>
        </div>
      </div>  
        
</body>
</html>