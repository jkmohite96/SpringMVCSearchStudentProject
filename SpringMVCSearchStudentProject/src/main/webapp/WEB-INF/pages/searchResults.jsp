<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>

<html><body>
<table border="1">
<c:forEach items="${searchResultsList}"
 var="searchResults">
<tr>
<td>${searchResults.studentId}</td>
<td>${searchResults.name}</td>
<td>${searchResults.mobile}</td>
<td>${searchResults.course}</td>
<td>${searchResults.city} ${searchResults.state}</td>
</tr>
</c:forEach>
</table>
</body></html>