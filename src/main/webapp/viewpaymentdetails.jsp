<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.model.PaymentDetails" %>
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
            	<th>E-mail</th>
                <th>Payment ID</th>
                <th>Amount</th>
                <th>Card No</th>
                <th>Expiry Month</th>
                <th>Expiry Year</th>
                <th>Date-Time</th>
                <th>Details</th>
            </tr>
        </thead>
        <%
        	List<PaymentDetails> pdetails=(List<PaymentDetails>)request.getAttribute("PaymentDetail");
        	for(PaymentDetails pd:pdetails)
        	{
        %>
        <tbody>
            <tr>
            	<td><%= pd.getEmail() %></td>
                <td><%= pd.getPaymentid() %></td>
                <td><%= pd.getAmount() %></td>
                <td><%= pd.getCardno() %></td>
                <td><%= pd.getExpirymonth() %></td>
                <td><%= pd.getExpiryyear() %></td>
                <td><%= pd.getDatetime() %></td>
                <td><%= pd.getDetails() %></td>
            </tr>
            <%
        	}
            %>
        </tbody>
    </table>
 	<button onclick="window.location.href='homepage.html';">HOME</button>
</body>
</html>