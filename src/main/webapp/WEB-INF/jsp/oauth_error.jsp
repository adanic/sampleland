<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <c:url value="/" var="base"/>

    <link type="text/css" rel="stylesheet" href="../../css/boot.css"/>
    <link type="text/css" rel="stylesheet" href="../../css/style.css"/>
    <%@ page contentType="text/html; charset=utf-8" %>

    <%@ page import="java.util.ResourceBundle" %>
    <% ResourceBundle resource = ResourceBundle.getBundle("adanalas");

        String authorizarionUrl = resource.getString("adanalas.authorizationUri");

        String clientId = resource.getString("embassy.clientId");

        String userScope = resource.getString("embassy.scope.user");

        String transactionsScope = resource.getString("embassy.scope.transactions");

        String redirectUri = resource.getString("embassy.redirectUri");

        String userInfoAndTransactionsUrl = authorizarionUrl + "?client_id=" + clientId + "&response_type=code&redirect_uri=" + redirectUri + "&scope=" + userScope + "," + transactionsScope;

        String transactionsUrl = authorizarionUrl + "?client_id=" + clientId + "&response_type=code&redirect_uri=" + redirectUri + "&scope=" + transactionsScope;%>

    <title>
        سایت سفارت وانواتو در تهران
    </title>

</head>
<body class="container" dir="rtl" style="margin: 0 auto">
<div class="layout span12">
    <img src="../../image/flag2.png" class="logo"/>
    <nav class="navbar">
        <div class="navbar-inner">
            <a class="brand">سفارت وانواتو</a>
            <ul class="nav">
                <li><a href="${base}index.jsp" class="selected">
                    صفحه اصلی
                </a></li>
            </ul>
        </div>
    </nav>
</div>

<div class="span12 view">
    <div class="container span12">
        <section class="well">

            <p style="color: gold">

                <c:if test="${error=='access_denied'}">
                    خطا در اعطای دسترسی
                </c:if>
                دوباره تلاش کنید


            </p>

        </section>


    </div>
</div>
</body>
</html>