<%-- 
    Document   : accountList
    Created on : Sep 30, 2021, 9:48:57 AM
    Author     : 0781317
--%>

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
        <h2>List of Accounts</h2>
                <table>
            <tr>
                <th>Account Number</th>
                <th>Account Name</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="account" items="${customerAccounts}">
                <tr>
                    <td>${account.accountNumber}</td>
                    <td class = "right">${account.accountName}</td>
                    <td>
                        <form action="transaction" method="post">
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
