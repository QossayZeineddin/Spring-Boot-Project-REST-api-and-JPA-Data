<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>َLogin to database</title>
  <link rel="stylesheet" href="/CSS/css1.css">
    <%--    <link href="<c:url value="/CSS/CSS1.css" />" rel="stylesheet" />--%>

<style>

    body{
        margin: 0;
        padding: 0;
        font-family: sans-serif;
        background: #34495e;
    }
    .box{
        width: 600px;
        length:500 px;
        padding: 40px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        background: #191919;
        text-align: center;
        border-radius: 27px;

    }

    .box h1{
        color: white;
        text-transform: uppercase;
        font-weight: 520;
        padding: 8px;
    }

    .box input[type = "text"],.box input[type = "password"]{
        border:0;
        background: none;
        display: block;
        margin: 20px auto;
        text-align: center;
        border: 2px solid #3498db;
        padding: 14px 10px;
        width: 370px;
        height: 31px;
        outline: none;
        color: white;
        border-radius: 24px;
        transition: 0.25s;
    }

    .box input[type = "text"]:hover,.box input[type = "password"]:hover{
        width: 450px;
        border-color: #2ecc71;
    }
    .errorm-mssage{
        color: white;

    }

    .box input[type = "submit"]{
        border:0;
        background: none;
        display: block;
        margin: 20px auto;
        text-align: center;
        border: 2px solid #2ecc71;
        padding: 22px 47px;
        outline: none;
        color: white;
        border-radius: 24px;
        transition: 0.25s;
        cursor: pointer;
    }

    .box input[type = "submit"]:hover{
        background: #2ecc71;
    }
    .error{
        color: rgba(240, 29, 29, 0.623);
    }



</style>
</head>
<body>



<form class="box" action="/loginCheck" method="post">
    <h1>Login</h1>
    <p class="error">${errorMassage}</p>

    <input type="text" name="username" placeholder="username" required = "required">
    <input type="password" name="password" placeholder="password" required = "required">
    <input type="submit" name="submit" value="Login">
</form>


</body>
</html>