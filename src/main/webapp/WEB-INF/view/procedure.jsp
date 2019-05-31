<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %> <%@ taglib prefix="form"
         uri="http://www.springframework.org/tags/form"%> <%@taglib prefix="c"
         uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Procedure scheduling</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
              name="viewport">

        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"
              rel="stylesheet" type="text/css">

        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"
              rel="stylesheet" type="text/css">


        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">


        <link href="<c:url value="/css/main.css" />" rel="stylesheet">
        <link href="<c:url value="/css/theme.css" />" rel="stylesheet">
        <link href="<c:url value="/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">

        <link href="<c:url value="/css/uniform.css" />" rel="stylesheet">

        <link href="<c:url value="/css/jAlert.css" />" rel="stylesheet">
        <link href="<c:url value="/css/jquery.css" />" rel="stylesheet">

    </head>
    <body class="skin-blue sidebar-mini">
        <div class="wrapper">
            <header class="main-header">
                <!-- Logo -->
                <a href="/" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->


                    <span class="logo-mini">HMS</span> <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>CareSyntax</b> HMS</span>

                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas"
                       role="button"> <span class="sr-only">Toggle navigation</span>
                    </a>
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">

                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu"><a href="#"
                                                                   class="dropdown-toggle" data-toggle="dropdown"> <img
                                        src="img/def-profile-img.png" class="user-image"
                                        alt="User Image"> <span class="hidden-xs">Demo
                                        Admin</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header"><img src="img/logo.png"
                                                                 class="img-circle" alt="User Image">
                                        <p>Demo Admin - Administrator</p></li>

                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                        <div class="pull-left">
                                            <a href="/EditProfile" class="btn btn-default btn-flat">Profile</a>

                                        </div>
                                        <div class="pull-right">
                                            <a class="btn btn-default btn-flat" href="/Account/Logout">Sign
                                                out</a>
                                        </div>
                                    </li>
                                </ul></li>
                            <!-- Control Sidebar Toggle Button -->

                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->

            <aside class="main-sidebar">
                <section class="sidebar active" style="height: auto;">
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/def-profile-img.png" class="img-circle"
                                 alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>Demo Admin</p>
                            <a>Administrator</a>
                        </div>
                    </div>
                    <ul class="sidebar-menu menu-open">
                        <li id="dashboard" class="active" style=""><a
                                href="/dashboard"><i class="fa fa-dashboard"></i><span>Dashboard</span></a>
                        </li>
                        <li id="Patient"><a href="admin_Patient.html"><i
                                    class="fa fa-user-md"></i><span>Patients</span></a></li>

                        <li id="study"><a href="admin_patient.html"><i
                                    class="fa fa-book"></i><span>Study</span></a></li>


                    </ul>
                </section>
            </aside>


            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper" id="divPageBody"
                 style="min-height: 595px;">

                <section class="content-header">
                    <h1>CareSyntax Patient Scheduling</h1>
                    <ol class="breadcrumb">
                        <li><a href="/"><i class="fa fa-home"></i> Home</a></li>
                        <li class="active">Patient Scheduling</li>
                    </ol>
                </section>

                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box ">
                                <div class="box-header">
                                    <div class="message-box"></div>
                                </div>
                                <div class="box-body">

                                    <div class="row">
                                        <div
                                            class="col-md-8 col-sm-12 btn-margin-bottom action-buttons">
                                            <div class="btn-group" id="divAddNew">
                                                <form method="get" action="${pageContext.request.contextPath}/patient/view">
                                                    <button type="submit" class="btn btn-block btn-primary btn-flat"
                                                            href="admin_bedsaddnew.html">
                                                        <span class="hide-on-mobile">Return</span><i
                                                            class="fa fa-arrow-circle-left"></i>

                                                    </button>
                                                </form>
                                            </div>

                                        </div>

                                    </div>

                                    <c:if test="${status != '' || status !=null}">
                                        <div class="alert ${alertType}" id="alert" role="alert">${status}</div>
                                    </c:if>


                                    <form:form method="post" action="${pageContext.request.contextPath}/saveSchedule" modelAttribute="study" class="form-horizontal">

                                        <input name="" type="hidden">

                                        <section>
                                            <h4 class="page-header">Schedule a Procedure</h4>
                                            <div class="form-body" id="mainform">

                                                <div class="form-group medicine-header"
                                                     style="display: block;">

                                                    <label class="col-md-2 control-label"></label> 
                                                    <label class="col-md-2">Patient</label> 
                                                    <label class="col-md-2">
                                                        Start time  <span class="required">*</span></label> 
                                                    <label class="col-md-2">Estimated End time</label> 
                                                    <label class="col-md-2">Delete</label>
                                                </div>


                                                <div id="medicineRows">

                                                    <div class="form-group medicineRow">
                                                        <label class="col-md-2 control-label"> <label>Schedule</label>
                                                            <span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-2">
                                                            <div>
                                                                <form:input path="" name="patientName" type="text" value="${patient.name}" id="patientName" class="form-control"></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <div class='input-group date' id='startTimePicker'>
                                                                <form:input path="plannedStartTime" class="form-control" /> <span
                                                                    class="input-group-addon"> <span
                                                                        class="glyphicon glyphicon-calendar"></span>
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class='input-group date' id='endTimePicker'>
                                                                <form:input path="estimatedEndTime" class="form-control" /> <span
                                                                    class="input-group-addon"> <span
                                                                        class="glyphicon glyphicon-calendar"></span>
                                                                </span>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-2">
                                                            <a href="#" class="deleteRow"><i
                                                                    class="fa fa-trash-o fa-2x"></i></a>
                                                        </div>
                                                    </div>


                                                </div>


                                                <div class="form-group">
                                                    <label class="col-md-2 control-label"><label>Description</label><span class="required">*</span></label>
                                                    <div class="col-md-4">
                                                        <div>
                                                            <form:textarea path="description" class="form-control" rows="2" cols="20" maxlength="2000"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6"></div>
                                                </div>
                                                <!-- END FORM-->
                                            </div>
                                        </section>

                                        <div class="form-actions margin-top-20 margin-bottom-15">
                                            <div class="row">
                                                <div class="col-md-offset-2 col-md-9">
                                                    <button type="submit" class="btn btn-success btn-flat">
                                                        <i class="fa fa-save"></i>&nbsp;&nbsp;Save
                                                    </button>
                                                    <button type="reset" class="btn  btn-primary btn-flat">
                                                        <i class="fa fa-undo"></i>&nbsp;&nbsp;Reset
                                                    </button>
                                                    <a class="btn btn-primary btn-flat"><i class="fa fa-ban"></i>&nbsp;&nbsp;Cancel</a>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>


            </div>
            <!-- /.content-wrapper -->

            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b><i class="fa fa-power-off" style="color: red;"></i> <a
                            href="https://caresyntax.com">CareSyntax</a></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <b>Version</b> 1.0.0
                </div>
                2019 © CareSyntax
            </footer>

            <div class="loader" style="display: none;">
                <img src="img/loader.png" alt="loader" class="loading-anim">
            </div>

        </div>

        <script src="<c:url value="/js/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="/js/moment.js" />"></script>
        <script src="<c:url value="/js/bootstrap-datetimepicker.min.js" />"></script>

        <script src="<c:url value="/js/bootstrap-datetimepicker.min.js" />"></script>


        <script src="<c:url value="/js/jqueryPlugins.js" />"></script>
        <script src="<c:url value="/js/datepicker.js" />"></script>
        <script src="<c:url value="/js/jalert.js" />"></script>
        <script src="<c:url value="/js/utilityPlugin.js" />"></script>
        <script src="<c:url value="/js/app.js" />"></script>


        <script type="text/javascript">
            $('#startTimePicker').datetimepicker();
            $('#endTimePicker').datetimepicker();
        </script>



    </body>
</html>