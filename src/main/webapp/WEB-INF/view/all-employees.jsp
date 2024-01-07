<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h1 {
            color: #333;
            opacity: 0;
            animation: fadeIn 1s ease-in-out forwards;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            opacity: 0;
            animation: fadeIn 1s ease-in-out forwards;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        input[type="button"] {
            background-color: #008CBA;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            opacity: 0;
            animation: fadeIn 1s ease-in-out forwards, moveInBottom 1s ease-in-out forwards;
        }

        input[type="button"]:hover {
            background-color: #005b79;
        }

        input[type="button"][value="Add"] {
            margin-top: 20px;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        @keyframes moveInBottom {
            from {
                transform: translateY(20px);
            }
            to {
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>
<h1>All Employees</h1>
<br>
<table>
    <!-- Your existing table content here -->
</table>
<br>
<input type="button" value="Add" onclick="window.location.href = 'addNewEmployee'"/>
</body>
</html>

<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="emp" items="${employeeList}">
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}" />
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}" />
        </c:url>

        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
