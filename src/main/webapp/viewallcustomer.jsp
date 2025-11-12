<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.model.AddCust" %>
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
        min-width:400px;
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
                <th>First Name</th>
                <th>Last Name</th>
                <th>E-Mail</th>
                <th>Mobile No</th>
            </tr>
        </thead>
        <%
        	List<AddCust> cust=(List<AddCust>)request.getAttribute("Customer");
        	for(AddCust ac:cust)
        	{
        %>
        <tbody>
            <tr>
                <td><%= ac.getFname() %></td>
                <td><%= ac.getLname() %></td>
                <td><%= ac.getEmail() %></td>
                <td><%= ac.getContactno() %></td>
            </tr>
            <%
        	}
            %>
        </tbody>
    </table>
 	<button onclick="window.location.href='adminhome.html';">HOME</button>
</body>
</html>