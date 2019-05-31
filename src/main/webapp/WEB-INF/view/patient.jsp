<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Procedure scheduling </title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic" rel="stylesheet" type="text/css">

        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic" rel="stylesheet" type="text/css">


        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">


        <link href="<c:url value="/css/main.css" />" rel="stylesheet">
        <link href="<c:url value="/css/theme.css" />" rel="stylesheet">
        <link href="<c:url value="/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">

        <link href="<c:url value="/css/uniform.css" />" rel="stylesheet">

        <link href="<c:url value="/css/jAlert.css" />" rel="stylesheet">
        <link href="<c:url value="/css/jquery.css" />" rel="stylesheet">

        <script type="text/javascript">
            $('#startTimePicker').datetimepicker();
            $('#endTimePicker').datetimepicker();
        </script>

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
                            <li class="dropdown user user-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">  <img src="<c:url value="/img/def-profile-img.png" />" class="user-image" alt="User Image">
                                    Demo Admin</span>

                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header"><img src="<c:url value="/img/logo.png" />" class="img-circle" alt="User Image">
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
                           <img src="<c:url value="/img/def-profile-img.png" />" class="user-image" alt="User Image">
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
                    <h1>Patients</h1>
                    <ol class="breadcrumb">
                        <li><a href="/"><i class="fa fa-home"></i> Home</a></li>
                        <li class="active">Patient</li>
                    </ol>
                </section>

                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <div class="message-box"></div>
                                </div>
                                <div class="box-body">

                                    <div class="row">
                                        <div
                                            class="col-md-8 col-sm-12 btn-margin-bottom action-buttons">
                                            <div class="btn-group" id="divAddNew">
                                                <form method="get"
                                                      action="${pageContext.request.contextPath}/patient/add">

                                                    <button type="submit"
                                                            class="btn btn-block btn-danger btn-flat">
                                                        <span class="hide-on-mobile">Add New </span><i
                                                            class="fa fa-plus"></i>
                                                    </button>

                                                </form>
                                            </div>


                                            <div class="btn-group">
                                                <form method="get" action="${pageContext.request.contextPath}/prepareSchedule">
                                                    <input type="hidden" name="scheduleId" id="scheduleId" />
                                                    <button class="btn btn-block btn-primary btn-flat"
                                                            id="scheduleBtn">
                                                        <span class="hide-on-mobile">Schedule a
                                                            Procedure&nbsp;&nbsp;</span><i class="fa fa-th-list"></i>
                                                    </button>
                                                </form>
                                            </div>


                                            <div class="btn-group">
                                                <form method="get" action="${pageContext.request.contextPath}/updateStatus"class="btn-group">
                                                    <input type="hidden" name="statusId" id="statusId" />
                                                    <select
                                                        name="statusName" id="statusFilter"
                                                        class="statusFilter form-control input-md input-small input-inline">
                                                        <option value="Select">--Select Status--</option>
                                                        <option value="Planned">Planned</option>
                                                        <option value="InProgress">In Progress</option>
                                                        <option value="Finished">Finished</option>
                                                    </select>
                                                    <button type="submit" id="statusButton" class="btn btn-primary btn-flat">
                                                        <span class="hide-on-mobile">Change Status &nbsp;&nbsp;</span><i class="fa fa-exchange"></i> 
                                                    </button>
                                                </form>
                                            </div>



                                        </div>
                                        <div class="col-md-4 col-sm-12">
                                            <div class="pull-right">
                                                <form class="form-inline" action="${pageContext.request.contextPath}/patient/search" method="post">

                                                    <input type="text" name="search" class="ddlFilter form-control input-md input-small input-inline"
                                                           placeholder="Name or sex" />
                                                    <button type="submit" class="btn btn-primary btn-flat">
                                                        <i class="fa fa-search"></i>
                                                    </button>

                                                </form>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-6 col-sm-12">
                                            <div class="margin-top-10">Showing 1 - 7 record(s) of 7
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-sm-12" style="margin-left: 0px;">
                                            <div class="dataTables_paginate paging_bootstrap_full_number">
                                                <div class="pagination-container">
                                                    <ul class="pagination">
                                                        <li class="active"><a>1</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-12 col-sm-12 datagrid">
                                            <table cellspacing="1" cellpadding="2" style="width: 100%;"
                                                   id="patientTable"
                                                   class="table table-striped table-hover table-bordered table-hd">
                                                <thead>
                                                    <tr class="gridheader">
                                                        <td valign="middle" align="center" style="width: 2%;">
                                                            <div class="checker" id="uniform-chkAll">
                                                                <span><input type="checkbox" name="chkAll"></span>
                                                            </div>
                                                        </td>
                                                        <td class="search_field" search_field_value="Patient">Patient
                                                            Name</td>
                                                        <td style="width: 15%;" class="search_field"
                                                            search_field_value="Patient">sex</td>
                                                        <td style="width: 15%;" class="search_field"
                                                            search_field_value="Patient">Date of Birth</td>
                                                        <td style="width: 15%;" class="text-center search_field"
                                                            search_field_value="IsActive">Status</td>
                                                        <td style="width: 5%;" class="text-center">Edit</td>
                                                        <td style="width: 5%;" class="text-center">Delete</td>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <c:forEach var="list" items="${patientList}">

                                                        <tr id="${list.patientId}">
                                                            <td valign="middle" align="center" style="width: 2%;">
                                                                <input type="checkbox" id="selectedRow" />
                                                            </td>
                                                            <td>${list.name}</td>

                                                            <td>${list.sex}</td>


                                                            <td>${list.dateOfBirth}</td>

                                                            <td style="width: 5%;" class="text-center"><a
                                                                    class="SetStatusClick" style="text-decoration: none">
                                                                    ${list.studyList[0].status} </a></td>
                                                            <td class="text-center"><a
                                                                    href="${pageContext.request.contextPath}/patient/edit/${list.patientId}"><i
                                                                        class="fa fa-edit"></i></a></td>
                                                            <td class="text-center"><a
                                                                    href="${pageContext.request.contextPath}/patient/delete/${list.patientId}"
                                                                    onclick="return confirm(' You want to delete?');"><i
                                                                        class="fa fa-trash-o"></i></a></td>

                                                        </tr>
                                                    </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-3 col-sm-12">
                                            <div>Showing 1 - ${patientList.size()} record(s)</div>
                                        </div>
                                        <div class="col-md-6 col-sm-12">
                                            <div>
                                                <label> <select
                                                        class="form-control input-sm input-small input-inline"
                                                        id="ddlPageSize" name="ddlPageSize">
                                                        <option selected="selected" value="10">Default
                                                            (10)</option>
                                                        <option value="20">20</option>
                                                        <option value="30">30</option>
                                                        <option value="50">50</option>
                                                        <option value="100">100</option>
                                                        <option value="200">200</option>
                                                        <option value="500">500</option>
                                                    </select> <span style="vertical-align: middle;">Record(s) per
                                                        page</span>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-sm-12">
                                            <div class="dataTables_paginate paging_bootstrap_full_number">
                                                <div class="pagination-container">
                                                    <ul class="pagination">
                                                        <li class="active"><a>1</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


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
                <img src="&lt;c:url value=" /img/loader.png" alt="" />" alt="loader"
                     class="loading-anim">
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


                                                                        $(function () {
                                                                            $('#patientTable').on('click', 'tbody tr', function (event) {
                                                                                $(this).addClass('success').siblings().removeClass('success');
                                                                            });

                                                                            $('#scheduleBtn').click(function (e) {
                                                                                var rows = getHighlightRow();
                                                                                if (rows != undefined) {
                                                                                    //               
                                                                                    $('#scheduleId').val(rows.attr('id'));
                                                                                }

                                                                            });

                                                                            $('#statusButton').click(function (e) {
                                                                                var rows = getHighlightRow();
                                                                                if (rows != undefined) {
                                                                                    //               
                                                                                    $('#statusId').val(rows.attr('id'));
                                                                                }

                                                                            });



                                                                            var getHighlightRow = function () {
                                                                                return $('table > tbody > tr.success');
                                                                            }

                                                                        });
        </script>




    </body>
</html>