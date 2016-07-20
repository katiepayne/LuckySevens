<%-- 
    Document   : response
    Created on : Jul 10, 2016, 11:34:27 AM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
    </head>
    <body>
        <h1>Results:</h1>

        <!-- Results Table -->
        <table class="table">
                <!-- Starting Bet Row -->
                <tr>
                        <!-- Label -->
                        <td>Starting Bet</td>
                        <!-- Data -->
                        <td><c:out value="${startingBet}"/></td>
                </tr>
                <!-- Roll Count Row -->
                <tr>
                        <!-- Label -->
                        <td>Total Rolls before going broke.</td>
                        <!-- Data -->
                        <td><c:out value="${rollCount}"/></td>
                </tr>
                <!-- Highest Amount Won Row -->
                <tr>
                        <!-- Label -->
                        <td>Highest Amount Won</td>
                        <!-- Data -->
                        <td><c:out value="${maxMoney}"/></td>
                </tr>
                <!-- Roll Count At Highest Amount Won Row -->
                <tr>
                        <!-- Label -->
                        <td>Roll Count At Highest Amount Won</td>
                        <!-- Data -->
                        <td><c:out value="${maxCount}"/></td>
                </tr>
        </table>
                <br>
                <br>
                <a href="http://localhost:8080/LuckySevens/" class="button">Play Again</a>
    </body>
</html>