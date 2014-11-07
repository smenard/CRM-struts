<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="Ajout|Modification Entreprise" name="titrePage" />
</jsp:include>
<!-- / nav -->
  <section id="content">
    <section class="main">
      <div class="padder clearfix">
        <h4><i class="icon-edit"></i><s:property value="getText('entreprise.add.titre')"/> </h4>
      </div>
      <div >
        <div >
          <section class="panel">

					<s:if test="hasFieldErrors()">
						<div class="alert alert-danger alert-block">

							<button type="button" class="close" data-dismiss="alert">
								<i class="icon-remove"></i>
							</button>
							<h4><i class="icon-ban-circle icon-large"></i>Attention Erreurs : </h4>
							<s:fielderror />
						</div>
					</s:if>
					<s:actionmessage/>
        
        <s:form action="addAction" >
        <s:hidden name="entreprise.id"></s:hidden>
            <s:property value="getText('entreprise.add.label.raisonSociale')"/><br><s:textfield name="entreprise.raisonSociale" label="Raison Sociale"  placeholder="Raison sociale"/><br>
            <s:property value="getText('entreprise.add.label.adresse')"/><br><s:textfield name="entreprise.adresse" label="Adresse" placeholder="Adresse" /><br>
            <s:property value="getText('entreprise.add.label.secteurActivite')"/><br><s:textfield name="entreprise.secteurActivite" label="Secteur d'activité" placeholder="Secteur d'activité" /><br>
            <s:submit cssClass="btn btn-primary" value="Enregistrer"/>
        </s:form>
          </section>
        </div>
      </div>
    </section>
  </section>

<jsp:include page="../template/footer.jsp" />
