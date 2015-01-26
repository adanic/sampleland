<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <c:url value="/" var="base"/>

    <link type="text/css" rel="stylesheet" href="css/boot.css"/>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
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
    <img src="image/flag2.png" class="logo"/>
    <nav class="navbar">
        <div class="navbar-inner">
            <a class="brand">سفارت وانواتو</a>
            <ul class="nav">
                <li><a href="${base}index.jsp" class="selected">
                    صفحه اصلی
                </a></li>
                <li><a href="<%=userInfoAndTransactionsUrl%>">

                    ورود با حساب آدانالس و دریافت صورتحساب

                </a></li>

            </ul>
        </div>
    </nav>
</div>

<div class="span12 view">
    <div class="container span12">
        <section class="well">

            <h1>
                به وانواتو خوش آمدید
            </h1>

            نام رسمی کشور : جمهوري وانواتو
            <br/>
            پایتخت : پورت ويلا
            <br/>
            نوع حکومت : جمهوري
            <br/>
            واحد پول : واتو(Vatu)
            <p style="color: gold">
                توجه: تعیین وقت مصاحبه جهت ویزا فقط به صورت آن-لاین امکان پذیر است. برای این منظور به قوانین روادید
                مراجعه
                نمایید.
            </p>

            <p>
                گام اول : با تکمیل فرم زیر ثبت نام کنید و یا برای تکمیل مراحل احراز هویت از <a href='<%=userInfoAndTransactionsUrl%>'> حساب آدانالس </a> خود استفاده
                کنید.

            </p>
        </section>

        <section class="well" style="display: block;">
            <form role="form" class="form-horizontal">
                <div class="popover-title">
                    ثبت نام وقت مصاحبه
                </div>
                <div class="popover-content">

                    <div class="row-fluid span12">
                        <label for="firstname" class="span3">نام</label>
                        <input type="text" id="firstname" class="span8">
                    </div>

                    <div class="row-fluid span12">
                        <label for="family" class="span3">نام خانوادگی</label>
                        <input type="text" id="family" class="span8"/>
                    </div>

                    <div class="row-fluid span12">
                        <label for="date" class="span3">تاریخ تولد</label>
                        <input type="text" id="date" class="span8">
                    </div>

                    <div class="row-fluid span12">
                        <label for="username" class="span3">نام کاربری</label>
                        <input type="text" id="username" class="span8"/>
                    </div>

                    <div class="row-fluid span12">
                        <label for="education" class="span3">آدرس</label>
                        <input type="text" id="education" class="span8"/>
                    </div>

                    <div class="row-fluid span12">
                        <label for="password" class="span3">کلمه عبور</label>
                        <input type="password" id="password" class="span8"/>
                    </div>

                    <div class="row-fluid span12">
                        <label for="passwordagain" class="span3">تکرار کلمه عبور</label>
                        <input type="password" id="passwordagain" class="span8"/>
                    </div>

                    <div class="row-fluid span12 ">
                        <label for="fileupload" class="span3">فایل صورتحساب بانکی</label>
                        <input type="file" id="fileupload" class="span8"/>
                    </div>

                </div>
                <div class="row btn-toolbar">
                    <button type="button" class="btn btn-primary save">
                        ذخیره و ادامه
                    </button>
                    <button onclick="location.href='<%=userInfoAndTransactionsUrl%>'" type="button" class="btn btn-success save">
                        ورود با حساب آدانالس

                    </button>
                </div>
            </form>
        </section>


        <p></p>

    </div>
</div>
</body>
</html>