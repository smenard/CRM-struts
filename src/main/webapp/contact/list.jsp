<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="Liste de contacts" name="titrePage" />
</jsp:include>
<!-- / nav -->
  <section id="content">
    <section class="main">
      <div class="padder clearfix">
        <h4><i class="icon-edit"></i>Contacts : </h4>
      </div>
      <div >
        <div >
          <section class="panel">
          <span class="label label-success pull-right"><s:property value="contacts.size()" /> Elements</span>
          <table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Mail</th>
			<th>Téléphone fixe</th>
			<th>Mobile</th>
			<th>Status</th>
			<th>Entreprise</th>
			<th>Action</th>
		</tr>
		<s:iterator value="contacts">
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
				<s:url action="deleteAction" var="urlDelete">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<s:url action="initUpdateAction" var="urlEdit">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<s:url value="/echange/listAction" var="urlEchanges">
				<s:param name="contact.id"><s:property value="id" /></s:param>
				</s:url>
				<s:url action="viewAction" var="urlView">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<a href='${urlEdit }'>Modifier</a> ,
				<a href='${urlView }'>Voir</a>,
<%-- 				<a href='${urlEchanges }'>Echanges</a>, --%>
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
