<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring4 MVC -HelloWorld</title>
</head>
<body>
<h1>Search successful!</h1>
<table>
    <c:forEach var="report" items="${lists}">
        <tr>
            <td>${report.country}</td>
            <td>${report.city}</td>
            <td>${report.streetAndHouse}</td>
            <td>${report.zipCode}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>