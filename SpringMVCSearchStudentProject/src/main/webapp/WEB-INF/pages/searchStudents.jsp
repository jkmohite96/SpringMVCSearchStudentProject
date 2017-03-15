<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<c:url value="/resources/css/jquery-ui.css"/>" 
rel="stylesheet"/>
<script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
 <script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
</head>

<%@include file="home.jsp" %>
<hr/>
<body>
<div >

<input type="text" id="studentId" placeholder="studentId"/>
<input type="text" id="name" placeholder="name"/>
<input type="text" id="course" placeholder="course"/>
<input type="text" id="mobile" placeholder="mobile"/>
<input type="submit" value="search" onclick="searchStudentsFun()"/>

</div><br/><br/>
<div id="searchStudentsResultsDiv" align="center">

</div>

</body>
</html>
<script>
function searchStudentsFun(){
 var studentId=document.getElementById("studentId").value;
var name=document.getElementById("name").value;
var course=document.getElementById("course").value;
var mobile=document.getElementById("mobile").value;

$.ajax({
type:"post",
url:"searchStudents",
data :"studentId="+studentId+"&name="+name+"&course="+course+"&mobile="+mobile,
success:function(result){
$("#searchStudentsResultsDiv").html(result);
}
});

}
</script>

