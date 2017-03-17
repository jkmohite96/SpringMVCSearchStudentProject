<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}

div.jk {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
</style>
<body>
	<h1>Registration Form</h1>
	<div class="ex">
		<form action="saveStudent" method="post" modelAttribute="studentbean">
			<table style="with: 50%">
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="fullname" path="fullname" /></td>

				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" path="address" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" path="age" /></td>
				</tr>
				<tr>
					<td>Qualification</td>
					<td><input type="text" name="qual" path="qualification" /></td>
				</tr>
				<tr>
					<td>Year of Passing
						 <select name="yop">
							<option>2011</option>
							<option>2014</option>
							<option>2016</option>
							<option>2015</option>
							<option>2017</option>
					</select> <name ="submit"  path="yop" />
					</td>
				</tr>

				<tr>
					<td>Gender<INPUT TYPE="radio" NAME="radios" VALUE="male" CHECKED path = "gender">
						Male   
						<INPUT TYPE="radio" NAME="radios" VALUE="female" path = "gender">
						Female
						<value = "submit" path = "gender">
						</td>
				</tr>
				
				<tr>
				<td>Language
				<input type="checkbox" name="lang" value="Marathi" path = lang1>Marathi
				<input type="checkbox" name="lang" value="Hindi" path = lang2>Hindi
				<input type="checkbox" name="lang" value="English" path = lang3>English
				</td>
				</tr>

			</table>
			<input type="submit" value="Register" />
		</form>
	</div>

	<div class="jk">

		<br>

		<h1>Students List</h1>

		<c:if test="${!empty listStudents}">
			<table border="1">
				<tr>
					<th width="120">FullName</th>
					<th width="120">Address</th>
					<th width="120">Age</th>
					<th width="120">Qualification</th>
					<th width="120">YearofPassing</th>
					<th width="120">Gender</th>
				</tr>
				<c:forEach items="${listStudents}" var="stud">
					<tr>
						<td>${stud.fullname}</td>
						<td>${stud.address}</td>
						<td>${stud.age}</td>
						<td>${stud.qualification}</td>
						<td>${stud.yop}</td>
						<td>${stud.gender}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

</body>
</html>