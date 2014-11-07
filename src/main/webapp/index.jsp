<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="template/header.jsp">
	<jsp:param value="Accueil" name="titrePage" />
</jsp:include>
 <!-- / nav -->
  <section id="content">
    <section class="main">
      <div class="padder clearfix">
        <h4><i class="icon-edit"></i>Accueil</h4>
      </div>
      <div class="row">
        <div class="col col-lg-6">
          <section class="panel">
          <s:url value="/entreprise/listAction" var="urlEntreprise">
				<s:param name="entrepriseId"><s:property value="id" /></s:param>
				</s:url>
	<a href="${urlEntreprise}">Consulter la liste des entreprises</a>
          </section>
        </div>
      </div>
    </section>
  </section>
				
<jsp:include page="template/footer.jsp" />