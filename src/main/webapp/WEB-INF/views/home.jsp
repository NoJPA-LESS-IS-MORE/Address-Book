<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HelloWorld</title>
</head>
<body>
<h1>Hello : ${name}</h1>

<form action="/greeting" method="post">
    <label path="name">name </label><input type="text" name="name"/></br></br>
    <label path="lastName">Last Name</label><input type="text" name="lastName"/></br></br>
    <input type="submit" value="Add" name="SUBMIT">
</form>
</body>
</html>