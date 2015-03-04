<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HelloWorld</title>
</head>
<body>
<h1>Form</h1>
<form action="/greeting" method="post">
    <label path="city">City: </label><input type="text" name="city"/></br></br>
    <label path="country">Country: </label><input type="text" name="country"/></br></br>
    <label path="zipCode">Zip Code: </label><input type="text" name="zipCode"/></br></br>
    <label path="streetAndHouse">Street And House: </label><input type="text" name="streetAndHouse"/></br></br>
    <input type="submit" value="Submit" name="SUBMIT">
</form>
</body>
</html>
