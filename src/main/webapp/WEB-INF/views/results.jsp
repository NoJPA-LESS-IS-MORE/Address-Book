<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring4 MVC -HelloWorld</title>
</head>
<body>
<h1>Success</h1>
<p>Results:</p>
<table>
    <c:forEach var="report" items="${reports}">
        <tr>
            <td>${report.country}</td>
            <td>${report.city}</td>
            <td>${report.streetAndHouse}</td>
            <td>${report.zipCode}</td>
        </tr>
    </c:forEach>
</table>
<form action="/search" method="post">
    <label path="city">Search for city: </label><input type="text" name="city"/></br></br>
    <input type="submit" value="Search" name="SUBMIT">
</form>
</body>
</html>