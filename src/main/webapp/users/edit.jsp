<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title> Edytuj Użytkownika </title>

  <!-- Custom fonts for this template-->
  <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet">

  <%--    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">--%>

  <!-- Custom styles for this template-->
  <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">


</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

  <!-- Sidebar -->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
      <div class="sidebar-brand-icon rotate-n-15">
        <i class="fas fa-laugh-wink"></i>
      </div>
      <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - White Dashboard on the left in blue -->
    <li class="nav-item active">
      <a class="nav-link" href="index.html">
        <i class="fas fa-fw fa-tachometer-alt"></i>
        <span>Dashboard</span></a>
    </li>
  </ul>

  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar -->
      <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
          <i class="fa fa-bars"></i>
        </button>

        <!-- End of Topbar -->
      </nav>


      <%--  HEADER . JSP --%>
      <!-- Begin Page Content -->

      <%@ include file="/header-add.jsp" %>

      <!-- End of Main Content -->


      <%--     EDIT readUser     --%>

      <%--     Formularz         --%>
      <form action="/user/edit" method="post" style="margin: 40px auto; width: 300px;">

        <label> Edytuj użytkownika numer ${id} </label>

        <input type="hidden" name="id" value="${id}" />

        <br><br>

        <label>
          Nazwa
          <input name="username" type="text" placeholder="Nazwa użytkownika">
        </label>

        <br><br>

        <label>
          Email
          <input name="email" type="text" placeholder="Email użytkownika">
        </label>

        <br><br>

        <label>
          Hasło
          <input name="password" type="text" placeholder="Hasło użytkownika">
        </label>

        <br><br>
        <input type="submit" value="Edytuj">

      </form>




      <%--  FOOTER . JSP --%>
      <!-- Footer -->

      <%@ include file="/footer.jsp" %>

      <!-- End of Footer -->

    </div>
    <!--    &lt;!&ndash; End of Content Wrapper &ndash;&gt;-->
  </div>


  <!-- End of Page Wrapper -->


  <!-- Bootstrap core JavaScript-->
  <script src="../src/main/webapp/theme/vendor/jquery/jquery.min.js"></script>
  <script src="../src/main/webapp/theme/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../src/main/webapp/theme/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../src/main/webapp/theme/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="../src/main/webapp/theme/vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="../src/main/webapp/theme/js/demo/chart-area-demo.js"></script>
  <script src="../src/main/webapp/theme/js/demo/chart-pie-demo.js"></script>

</body>

</html>
