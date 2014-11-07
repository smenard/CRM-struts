<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="Page ${entreprise.raisonSociale }" name="titrePage" />
</jsp:include>
<!-- / nav -->
  <section id="content">
    <section class="main">
      <div class="padder clearfix">
        <h4><i class="icon-edit"></i>Entreprise : <s:property value="entreprise.raisonSociale" /></h4>
      </div>
      <div >
        <div >
        <section class="panel">
        <h2>Infos entreprise</h2>
        <table class="table table-hover">
        <tr><th>ID :</th><td><s:property value="entreprise.id" /></td></tr>
        <tr><th>Raison sociale :</th><td><s:property value="entreprise.raisonSociale" /></td></tr>
        <tr><th>Adresse :</th><td><s:property value="entreprise.adresse" /></td></tr>
        <tr><th>Secteur d'activité :</th><td><s:property value="entreprise.secteurActivite" /></td></tr>
        <tr><th>Actions : </th><td><s:url action="deleteAction" var="urlDelete">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<s:url action="initUpdateAction" var="urlEdit">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
			
				<a href='${urlEdit }'>Modifier</a>, <a href='${urlDelete }'>Supprimer</a> </td></tr>
        </table>
        </section>
          <section class="panel">
          <h2>Contacts associés : </h2>
          <span class="label label-success pull-right"><s:property value="entreprise.contacts.size()" /> Elements</span>
          <table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Mail</th>
			<th>Téléphone fixe</th>
			<th>Mobile</th>
			<th>Statut</th>
			<th>Entreprise</th>
			<th>Action</th>
		</tr>
		<s:iterator value="entreprise.contacts">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="nom" /></td>
				<td><s:property value="prenom" /></td>
				<td><s:property value="mail" /></td>
				<td><s:property value="telFixe" /></td>
				<td><s:property value="mobile" /></td>
				<td><s:property value="status" /></td>
				<td><s:property value="entreprise.raisonSociale" /></td>
				<td>
				<s:url value="/contact/deleteAction" var="urlDelete">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<s:url value="/contact/initUpdateAction" var="urlEdit">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<s:url value="/echange/listAction" var="urlEchanges">
				<s:param name="contact.id"><s:property value="id" /></s:param>
				</s:url>
				<a href='${urlEdit }'>Modifier</a> ,<a href='${urlEchanges }'>Echanges</a>, <a href='${urlDelete }'>Supprimer</a> </td>
				
			</tr>
		</s:iterator>
	</table>
          </section>
        </div>
      </div>
    </section>
  </section>

<jsp:include page="../template/footer.jsp" />
