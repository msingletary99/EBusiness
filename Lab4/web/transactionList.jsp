<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <title>Customer Main Page</title>
    </head>
    <body>
        <h1>Welcome ${customer.name}</h1>
        <h2>Transaction List</h2>
                <table>
            <tr>
                <th>Transaction Number</th>
                <th>Transaction Description</th>
                <th>Transaction Date</th>
                <th>Running Total</th>
            </tr>
            <c:forEach var="account" items="${customerAccounts}">
                <tr>
                    <td>${account.accountNumber}</td>
                    <td class = "right">${account.accountName}</td>
                    <td>
                        <form action="TransactionServlet" method="post">
                            <input type="hidden" name="option" value="list">
                            <input type="hidden" name="accountNumber" value="<c:out value='${account.accountNumber}'/>">
                            <input type="submit" value="select">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>