<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
    body{
        background-color: rgb(140, 204, 197);
    }
    .paypage{
        position: absolute;
        top: 3%;
        left: 35%;
        width: 300px;
        height:510px;
        background-color: white;
        border-radius: 3px;
        border-style:solid;
    }
    h1{
        text-align: center;
        padding-top: 10px;
        font-family:monospace;
        font-size: 30px;
    }
    form{
        width: 300px;
        margin-left: 15px;
    }
    form label{
        display: flex;
        margin-top: 13px;
        font-size: 18px;
        font-family: Consolas;
        font-size: 15px;
        font-weight: bold;
    }
    form input{
        width: 90%;
        height: 25px;
        padding: 3px;
        border: 1.5px solid grey;
        border-radius: 5px;
    }
    input::-webkit-inner-spin-button,input::-webkit-outer-spin-button{
        display: none;
    }
    input[type="submit"]{
        width: 92%;
        height: 30px;
        margin-top: 17px;
        background-color: rgb(99, 136, 136);
        color: white;
        font-family: Consolas;
        font-weight: bold;
    }
    </style>
</head>
<script>
function checkCardNo(ipcardno)
{
	const cardno_regexp="^[0-9]{8}$";
	if(!ipcardno.value.match(cardno_regexp))
	{
		alert("Enter card number in valid format!");
		ipcardno.value=" ";
	}
}
function checkExpiryMonth(ipexpmonth)
{
	const expmonth_regexp="^(0[1-9]|1[0-2])$";
	if(!ipexpmonth.value.match(expmonth_regexp))
	{
		alert("Enter expiry month in valid format!");
		ipexpmonth.value=" ";
	}
}
function checkExpiryYear(ipexpyear)
{
	const expyear_regexp="^[0-9]{4}$";
	const d=new Date().getFullYear();
	if(!ipexpyear.value.match(expyear_regexp))
	{
		alert("Enter expiry year in valid format!");
		ipexpyear.value=" ";
	}
	if(ipexpyear.value<d)
	{
		alert("Entered year should be greater than or equal to current year!");
		ipexpyear.value=" ";
	}
}
function checkCVV(ipcvv)
{
	const cvv_regexp="^[0-9]{3}$";
	if(!ipcvv.value.match(cvv_regexp))
	{
		alert("Enter CVV in valid format!");
		ipcvv.value=" ";
	}
}
function checkPay(ipmonth,ipyear)
{
	const d=new Date().getFullYear();
	const m=new Date().getMonth();
	if(ipmonth.value<m && ipyear.value<=d)
	{
		alert("Enter valid month & year!");
		ipmonth.value=" ";
		ipyear.value=" ";
	}
}
</script>
<body>
	<%
/* 		int bookingid=(int)session.getAttribute("bookingid"); */
		int amount=(int)session.getAttribute("amount");
	%>
    <div class="paypage">
        <h1>PAYMENT PAGE</h1>
        <form action="/makePayment" method="post" name="paymentform">
            <%-- <label>Booking ID:</label>
            <input type="number" name="bookingid" value="<%= bookingid %>" readonly required> --%>
            <label>Amount:</label>
            <input type="number" name="amount" value="<%= amount %>" readonly required>
            <label>Enter Card Number:</label>
            <input type="number" name="cardno" required>
            <label>Enter Expiry Month:</label>
            <input type="number" name="expirymonth" required onclick="checkCardNo(document.paymentform.cardno)">
            <label>Enter Expiry Year:</label>
            <input type="number" name="expiryyear" required onclick="checkExpiryMonth(document.paymentform.expirymonth)">
            <label>Enter CVV:</label>
            <input type="number" name="cvv" required onclick="checkExpiryYear(document.paymentform.expiryyear)">
            <label>Enter Details:</label>
            <input type="text" name="details" required onclick="checkCVV(document.paymentform.cvv)" onmouseout="checkPay(document.paymentform.expirymonth,document.paymentform.expiryyear)">
            <input type="submit" value="PAY">
        </form>
    </div>
</body>    
</html>