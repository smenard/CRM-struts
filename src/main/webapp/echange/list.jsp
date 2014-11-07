<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="Liste d'échanges" name="titrePage" />
</jsp:include>
<!-- / nav -->
  <section id="content">
    <section class="main">
      <div class="padder clearfix">
        <h4><i class="icon-edit"></i>Echanges : </h4>
      </div>
      <div >
        <div >
          <section class="panel">
          <span class="label label-success pull-right"><s:property value="echanges.size()" /> Elements</span>
          <table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Type</th>
			<th>Date</th>
			<th>Commentaire</th>
			<th>Contact</th>
			<th>Action</th>
		</tr>
		<s:iterator value="echanges">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="type" /></td>
				<td><s:date name="date" /></td>
				<td><s:property value="commentaire" /></td>
				<td><s:property value="contact.nom" /> <s:property value="contact.prenom" /></td>
				<td>
				<s:url action="deleteAction" var="urlDelete">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<s:url action="initUpdateAction" var="urlEdit">
				<s:param name="id"><s:property value="id" /></s:param>
				</s:url>
				<a href='${urlEdit }'>Modifier</a> , <a href='${urlDelete }'>Supprimer</a> </td>
				
			</tr>
		</s:iterator>
	</table>
          </section>
        </div>
      </div>
    </section>
  </section>

<jsp:include page="../template/footer.jsp" />
