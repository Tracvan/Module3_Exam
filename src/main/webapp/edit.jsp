
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/homepage?action=edit&studentId=${student.id}" method="post">
<h1>Edit Student Info</h1>
<h3>Name</h3>
<input type="text" name="name" placeholder="${student.name}">
<h3>Date of birth</h3>
<input type="date" name="birth" placeholder="${student.birth}">
<h3>Address</h3>
<input type="text" name="address" placeholder="${student.address}">
<h3>Phone Number</h3>
<input type="text" name="phoneNumber" placeholder="${student.phoneNumber}">
<h3>Class</h3>
<select name ="className">
    <option value="C1123G1">C1123G1</option>
    <option value="C1223G1">C1223G1</option>
    <option value="C0124G1">C0124G1</option>
</select>
    <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
