
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Address</th>
        <th>Phone Number</th>
        <th>Class Room</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.birth}</td>
        <td>${student.address}</td>
        <td>${student.phoneNumber}</td>
        <td>${student.className}</td>
        <td>
            <form action="/homepage" method="GET">
                <input type="hidden" name="action" value="edit" />
                <input type="hidden" name="studentId" value="${student.id}" />
                <button type="submit">Edit</button>
            </form>
        </td>
        <td>
            <form action="/homepage" method="GET">
                <input type="hidden" name="action" value="delete" />
                <input type="hidden" name="studentId" value="${student.id}" />
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
