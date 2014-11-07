<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>CRM | ${param.titrePage }</title>
  <link rel="shortcut icon" href="http://www.it-news.fr/wp-content/uploads/2013/09/CRM-dusage.jpg">
  <meta name="description" content="mobile first, app, web app, responsive, admin dashboard, flat, flat ui">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> 
  <link rel="stylesheet" href='<c:url value="/css/bootstrap.css"></c:url>'>
  <link rel="stylesheet" href='<c:url value="/css/font-awesome.min.css"></c:url>'>
  <link rel="stylesheet" href='<c:url value="/css/plugin.css"></c:url>'>
  <link rel="stylesheet" href='<c:url value="/css/style.css"></c:url>'>  
  <!--[if lt IE 9]>
    <link rel="stylesheet" href="css/ie.css">
    <script src='<c:url value="/js/ie/respond.min.js"></c:url>'></script>
    <script src='<c:url value="/js/ie/html5.js"></c:url>'></script>
    <script src='<c:url value="/js/ie/excanvas.js"></c:url>'></script>
  <![endif]-->
  
  <s:head/>
  
</head>
<body>
  <!-- header -->
  <header id="header" class="navbar navbar-sm">
    <ul class="nav navbar-nav navbar-avatar pull-right">
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">            
          <span class="hidden-sm-only">Mika Sokeil</span>
          <span class="thumb-small avatar inline"><img src='<c:url value="/images/avatar.jpg"></c:url>' alt="Mika Sokeil" class="img-circle"></span>
          <b class="caret hidden-sm-only"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="#">Settings</a></li>
          <li><a href="#">Profile</a></li>
          <li><a href="#"><span class="badge bg-danger pull-right">3</span>Notifications</a></li>
          <li class="divider"></li>
          <li><a href="docs.html">Help</a></li>
          <li><a href="signin.html">Logout</a></li>
        </ul>
      </li>
    </ul>
    <a class="navbar-brand" href='<c:url value="/index.jsp"></c:url>'>CRM</a>
    <button type="button" class="btn btn-link pull-left nav-toggle hidden-lg" data-toggle="class:show" data-target="#nav">
      <i class="icon-reorder icon-xlarge text-default"></i>
    </button>
    <ul class="nav navbar-nav hidden-sm">
  </header>
  <!-- / header -->
  <!-- nav -->
  <nav id="nav" class="nav-primary visible-lg nav-vertical">
    <ul class="nav" data-spy="affix" data-offset-top="50">
      <li class="dropdown-submenu"><a href="#"><i class="icon-dashboard icon-xlarge"></i>Entreprise</a>
      <ul class="dropdown-menu">
      <s:url value="/entreprise/listAction" var="urlEntreprises">
				</s:url>
          <li><a href="${urlEntreprises }">Afficher les entreprises</a></li>
          <li><a href='<c:url value="/entreprise/add.jsp"></c:url>'>Nouvelle entreprise</a></li>
        </ul>
      </li>
      <li class="dropdown-submenu">
        <a href="#"><i class="icon-th icon-xlarge"></i>Contacts</a>
        <ul class="dropdown-menu">
         <s:url value="/contact/listAction" var="urlContacts">
				</s:url>
          <li><a href="${urlContacts }">Afficher les contacts</a></li>
          
          <s:url value="/contact/prepareAddAction.action"  var="urlAddContact">
	</s:url>
          <li><a href="${urlAddContact }">Nouveau contact</a></li>
        </ul>
      </li>
      <li class="dropdown-submenu">
        <a href="#"><i class="icon-list icon-xlarge"></i>Echanges</a>
        <ul class="dropdown-menu">
        <s:url value="/echange/listAction" var="urlEchanges" >
				</s:url>
          <li><a href="${urlEchanges }">Afficher les échanges</a></li>
           <s:url value="/echange/prepareAddAction.action" var="urlAddEchange">
	</s:url>
          <li><a href="${urlAddEchange }">Nouvel échange</a></li>
        </ul>
      </li>
      
    </ul>
  </nav>
 