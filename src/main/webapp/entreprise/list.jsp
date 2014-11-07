<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="Liste des entreprises" name="titrePage" />
</jsp:include>
<!-- / nav -->
  <section id="content">
    <section class="main">
      <div class="padder clearfix">
        <h4><i class="icon-edit"></i>Entreprises : </h4>
      </div>
      <div >
        <div >
          <section class="panel">
          <span class="label label-success pull-right"><s:property value="entreprises.size()" /> Elements</span>
          <table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Raison Sociale</th>
			<th>adresse</th>
			<th>secteur d'activité</th>
			<th>Action</th>
		</tr>
		<s:iterator value="entreprises">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="raisonSociale" /></td>
				<td><s:property value="adresse" /></td>
				<td><s:property value="secteurActivite" /></td>
				<td>
				<s:url action="deleteAction" var="urlDelete">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<s:url action="initUpdateAction" var="urlEdit">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<s:url action="viewAction" var="urlView">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<s:url value="/contact/listAction" var="urlContacts">
				<s:param name="entrepriseId"><s:property value="id" /></s:param>
				</s:url>
				<a href='${urlEdit }'>Modifier</a> ,
				<a href='${urlView }'>Voir</a>,
<%-- 				<a href='${urlContacts }'>Contacts</a>,  --%>
				<a href='${urlDelete }'>Supprimer</a> </td>
				
			</tr>
		</s:iterator>
	</table>
          </section>
        </div>
      </div>
    </section>
  </section>

<jsp:include page="../template/footer.jsp" />
