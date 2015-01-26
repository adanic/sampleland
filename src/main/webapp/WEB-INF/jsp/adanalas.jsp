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

        String userInfoUrl = authorizarionUrl + "?client_id=" + clientId + "&response_type=code&redirect_uri=" + redirectUri + "&scope=" + userScope;

        String transactionsUrl = authorizarionUrl + "?client_id=" + clientId + "&response_type=code&redirect_uri=" + redirectUri + "&scope=" + transactionsScope;%>

    <title>oauth2 sample client for adanalas</title>

</head>
<body class="container" dir="rtl" style="margin: 0 auto">
<div class="layout span12">
    <img src="../../image/flag2.png" class="logo"/>
    <nav class="navbar">
        <div class="navbar-inner">
            <a class="brand">
                سفارت وانواتو

            </a>

            <ul class="nav">
                <li><a href="${base}index.jsp" class="selected">
                    خانه
                </a></li>

            </ul>
            <ul class="nav" style="float: left;top: 10px">
                <a>
                    ${userInfo.email}
                </a>
                <a href="${base}">
                    خروج
                </a>
            </ul>

        </div>
    </nav>
</div>

<div class="span12 view">
    <div class="container span12">

        <section class="well" style="display: block;">
            <%--<form role="form" class="form-horizontal">--%>
                <div class="popover-title">
                    اطلاعات شما
                </div>
                <div class="popover-content">

                    <div class="row-fluid span12">
                        <label class="span3">نام</label>
                        <label class="span3"> ${userInfo.firstName}
                        </label>
                    </div>
                    <div class="row-fluid span12">
                        <label class="span3">نام خانوادگی</label>
                        <label class="span3"> ${userInfo.lastName}
                        </label>
                    </div>

                    <div class="row-fluid span12">
                        <label class="span3">ایمیل</label>
                        <label class="span3"> ${userInfo.email}
                        </label>
                    </div>

                    <div class="row-fluid span12">
                        <label class="span3">تاریخ</label>
                        <label class="span3 ltr-right"> ${userInfo.created}
                        </label>
                    </div>

                    <div class="row-fluid span12">
                        <label class="span3">آدرس</label>
                        <label class="span3"> ${userInfo.address}
                        </label>
                    </div>

                </div>

                <div class="row btn-toolbar"/>
            <%--</form>--%>
        </section>

        <section class="well" style="display: block;">
            <div class="popover-title">

                لیست تراکنش ها
            </div>
            <div class="transaction-list">
                <!-- HADAF INFORMATION -->
                <table class="table table-hover" dir="rtl">
                    <thead>
                    <tr class="warning">
                        <th style="text-align:right">سپرده</th>
                        <th style="text-align:right">تاریخ</th>
                        <th style="text-align:right">مبلغ</th>
                        <th style="text-align:right">نوع </th>
                        <th style="text-align:right">جزییات</th>
                        <th style="text-align:right">دسته بندی</th>
                        <th style="text-align:right">برچسب ها</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="transaction" items="${userInfo.transactions}">
                        <tr>
                            <td>${transaction.deposit}</td>
                            <td>${transaction.date}</td>
                            <td>${transaction.amount}</td>
                            <td>${transaction.type=='d'? 'برداشت': 'واریز' }</td>
                            <td>${transaction.detail}</td>
                            <td>${transaction.category}</td>
                            <td>${transaction.tags}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

            </div>


        </section>
    </div>
</div>
</body>
</html>