<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.model.AddBus" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<style>
	body{
		background-color: #e5ebea;
	}
    .contenttable{
        border-collapse: collapse;
        margin: 25px 0;
        font-size: 0.9em;
        min-width:600px;
        border-radius: 5px 5px 0 0;
        overflow: hidden;
        margin-left: auto;
        margin-right: auto;
        margin-top: 10%
    }
    .contenttable thead tr{
        background-color: #009879;
        color: #ffffff;
        text-align: left;
        font-weight: bold;
    }
    .contenttable th, .contenttable td{
        padding: 12px 15px;
        font-family: Consolas;
    }
    .contenttable tbody tr{
        border-bottom: 1px solid lightgray;
    }
    .contenttable tbody tr:nth-of-type(even){
        background-color: #f3f3f3;
    }
    .contenttable tbody tr:last-of-type{
        border-bottom: 2px solid #009879;
    }
    button{
        margin-left: 45%;
        margin-top: auto;
        width: 80px;
        height: 50px;
        background-color: rgb(99, 136, 136);
        color: white;
        font-family: Consolas;
        font-weight: bold;
        border-radius: 3px;
        border-style:solid;
        border-color: rgb(99, 136, 136);
    }
</style>
</head>
<body>
    <table class="contenttable">
        <thead>
            <tr>
                <th>Bus No</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Date</th>
                <th>Time</th>
                <th>Fare</th>
            </tr>
        </thead>
        <%
        	AddBus ab=(AddBus)request.getAttribute("AddBus");
        %>
        <tbody>
            <tr>
                <td><%= ab.getBusno() %></td>
                <td><%= ab.getSource() %></td>
                <td><%= ab.getDest() %></td>
                <td><%= ab.getDate() %></td>
                <td><%= ab.getTime() %></td>
                <td><%= ab.getFare() %></td>
            </tr>
        </tbody>
    </table>
    <button onclick="window.location.href='adminhome.html';">HOME</button>
</body>
</html>