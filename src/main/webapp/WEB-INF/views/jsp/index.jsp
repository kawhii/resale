<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="keywords" content="Resale Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design"/>
    <jsp:include page="/base"></jsp:include>
    <%--<script type="application/javascript">
        seajs.use("~/home/index.js");
    </script>--%>
    <script type="application/javascript" src="js/lib/jquery/jquery.flexisel.js"></script>
    <script type="application/javascript" src="js/lib/jquery/jquery.leanModal.min.js"></script>
    <script type="application/javascript" src="js/common/bootstrap.min.js"></script>
    <script type="application/javascript" src="js/common/bootstrap-select.js"></script>
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);
        function hideURLbar() {
            window.scrollTo(0, 1);
        } </script>
    <!-- //for-mobile-apps -->
    <!--fonts-->
</head>
<body>
<jsp:include page="/index/header"></jsp:include>
<jsp:include page="/index/main"></jsp:include>
<!-- content-starts-here -->
<div class="content">
    <div class="categories">
        <div class="container">
            <jsp:include page="/index/brand"></jsp:include>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="trending-ads">
        <div class="container">
            <!-- slider -->
            <div class="trend-ads">
                <h2>热门广告</h2>
                <jsp:include page="/index/hotAdv"></jsp:include>
            </div>
        </div>
        <!-- //slider -->
    </div>
    <div class="mobile-app">
        <div class="container">
            <div class="col-md-5 app-left">
                <a href="mobileapp.html"><img src="images/app.png" alt=""/></a>
            </div>
            <div class="col-md-7 app-right">
                <h3>Resale App is the <span>Easiest</span> way for Selling and buying second-hand goods</h3>

                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam auctor Sed bibendum varius euismod.
                    Integer eget turpis sit amet lorem rutrum ullamcorper sed sed dui. vestibulum odio at elementum.
                    Suspendisse et condimentum nibh.</p>

                <div class="app-buttons">
                    <div class="app-button">
                        <a href="#"><img src="images/1.png" alt=""/></a>
                    </div>
                    <div class="app-button">
                        <a href="#"><img src="images/2.png" alt=""/></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<script type="application/javascript" src="js/~/home/index.js"></script>
<jsp:include page="/index/footer"></jsp:include>
</body>
</html>