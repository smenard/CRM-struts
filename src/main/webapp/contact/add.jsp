<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="Ajout|Modification d'un contact" name="titrePage" />
</jsp:include>
<!-- / nav -->
<section id="content">
	<section class="main">
		<div class="padder clearfix">
			<h4>
				<i class="icon-edit"></i>
				<s:property value="getText('contact.add.titre')" />
			</h4>
		</div>
		<div>
			<div>
				<section class="panel">
					<s:actionerror />
					<s:if test="hasFieldErrors()">
						<div class="alert alert-danger alert-block">

							<button type="button" class="close" data-dismiss="alert">
								<i class="icon-remove"></i>
							</button>
							<h4>
								<i class="icon-ban-circle icon-large"></i>Attention Erreurs :
							</h4>
							<s:fielderror />
						</div>
					</s:if>
					<s:form action="addAction">
						<s:hidden name="contact.id"></s:hidden>
						<s:property value="getText('contact.add.nom')" />
						<br>
						<s:textfield name="contact.nom" label="Nom" placeholder="Nom"/>
						<br>
						<s:property value="getText('contact.add.prenom')" />
						<br>
						<s:textfield name="contact.prenom" label="Prénom" placeholder="Prénom" />
						<br>
						<s:property value="getText('contact.add.mail')" />
						<br>
						<s:textfield name="contact.mail" label="Email" placeholder="exemple@domaine.com"/>
						<br>
						<s:property value="getText('contact.add.telFixe')" />
						<br>
						<s:textfield name="contact.telFixe" label="Téléphone fixe" placeholder = "XX XX XX XX XX "/>
						<br>
						<s:property value="getText('contact.add.mobile')" />
						<br>
						<s:textfield name="contact.mobile" label="Téléphone Mobile" placeholder= "06 XX XX XX XX"/>
						<br>
<%-- 						<s:property value="getText('contact.add.status')" /> --%>
						<br>
						<%--              <s:select name="contact.status" list="#{0:'Prospect',1:'Contact', --%>
						<%--                  2:'Client'}" size="1" multiple="false"/> --%>
						<s:label value="Status" />
						<select name="contact.status">
							<s:iterator value="@fr.treeptik.entity.Contact$Status@values()"
								var="status">
								<option value="${status}"><s:property /></option>
							</s:iterator>
						</select>
						<s:label value="Entreprise" />

						<s:select name="contact.entreprise.id" list="entreprises"
							listValue="raisonSociale" listKey="id" />
						<%-- 		<select name="entreprise.id"> --%>
						<%-- 			<s:iterator value="entreprises" var="e"> --%>
						<%-- 				<option value="${e.id}">${e.raisonSociale}</option> --%>
						<%-- 			</s:iterator> --%>
						<%-- 		</select> --%>
						<s:submit cssClass="btn btn-primary" value="Enregistrer" />
					</s:form>
				</section>
			</div>
		</div>
	</section>
</section>

<jsp:include page="../template/footer.jsp" />
