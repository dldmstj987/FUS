<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <link rel="icon" type="image/png" href="favicon.ico">

  <!--Google Font link-->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,400i,700,700i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">


  <link rel="stylesheet" href="/assets/css/slick.css">
  <link rel="stylesheet" href="/assets/css/slick-theme.css">
  <link rel="stylesheet" href="/assets/css/iconfont.css">
  <link rel="stylesheet" href="/assets/css/animate.css">
  <link rel="stylesheet" href="/assets/css/font-awesome.min.css">
  <link rel="stylesheet" href="/assets/css/bootstrap.css">
  <link rel="stylesheet" href="/assets/css/magnific-popup.css">
  <link rel="stylesheet" href="/assets/css/bootsnav.css">



  <!--For Plugins external css-->
  <link rel="stylesheet" href="/assets/css/plugins.css?v" />

  <!--Theme custom css -->
  <link rel="stylesheet" href="/assets/css/style.css?a">

  <!--Theme Responsive css-->
  <link rel="stylesheet" href="/assets/css/responsive.css" />

  <script src="/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
<body>
<div id="loading">
  <div id="loading-center">
    <div id="loading-center-absolute">
      <div class="object" id="object_one"></div>
      <div class="object" id="object_two"></div>
      <div class="object" id="object_three"></div>
      <div class="object" id="object_four"></div>
    </div>
  </div>
</div><!--End off Preloader -->


<div class="culmn">
  <!--Home page style-->


  <nav class="navbar navbar-default bootsnav navbar-fixed no-background white">

    <!-- Start Top Search -->
    <div class="top-search">
      <div class="container">
        <div class="input-group">
          <span class="input-group-addon"><i class="fa fa-search"></i></span>
          <input type="text" class="form-control" placeholder="Search">
          <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
        </div>
      </div>
    </div>
    <!-- End Top Search -->


    <div class="container">
      <div class="attr-nav">
        <ul>
          <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
        </ul>
      </div>

      <!-- Start Header Navigation -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
          <i class="fa fa-bars"></i>
        </button>
        <a class="navbar-brand" href="#">
          <img src="/assets/images/logo.png" class="logo" alt="">
          <!--<img src="assets/images/footer-logo.png" class="logo logo-scrolled" alt="">-->
        </a>

      </div>
      <!-- End Header Navigation -->

      <!-- navbar menu -->
      <div class="collapse navbar-collapse" id="navbar-menu">
        <ul class="nav navbar-nav navbar-right">
          <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
          <c:choose>
            <c:when test="${empty loginInfo}">
              <li class="nav-item"><a class="nav-link" href="/user/login">login</a></li>
            </c:when>
            <c:otherwise>
              <li class="nav-item"><a class="nav-link" style="cursor: default; color: coral;">[${loginInfo.name}님]</a></li>
              <li class="nav-item"><a class="nav-link" href="/user/logout">Logout</a></li>
              <li class="nav-item"><a class="nav-link" href="/user/myPage">MyPage</a></li>
            </c:otherwise>
          </c:choose>
          <li class="nav-item"><a class="nav-link" href="/product/list">Shop</a></li>
          <li class="nav-item"><a class="nav-link" href="#">Review</a></li>
          <li class="nav-item"><a class="nav-link" href="/board/all">Board</a></li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div>
  </nav>
  <div class="margin-block"></div>
</div>
</body>
<script src="/assets/js/vendor/jquery-1.11.2.min.js"></script>
<script src="/assets/js/vendor/bootstrap.min.js"></script>

<script src="/assets/js/jquery.magnific-popup.js"></script>
<!--<script src="assets/js/jquery.easypiechart.min.js"></script>-->
<script src="/assets/js/jquery.easing.1.3.js"></script>
<!--<script src="assets/js/slick.js"></script>-->
<script src="/assets/js/slick.min.js"></script>
<script src="/assets/js/js.isotope.js"></script>
<script src="/assets/js/jquery.collapse.js"></script>
<script src="/assets/js/bootsnav.js"></script>

<script src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>

<script src="/assets/js/plugins.js?"></script>
<script src="/assets/js/main.js?"></script>
</html>
