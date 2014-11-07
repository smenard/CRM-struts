<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="Ajout|Modification Echange" name="titrePage" />
</jsp:include>
<!-- / nav -->
<section id="content">
	<section class="main">
		<div class="padder clearfix">
			<h4>
				<i class="icon-edit"></i>
				<s:property value="getText('echange.add.titre')" />
			</h4>
		</div>
		<div>
			<div>
				<section class="panel">

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
					<s:actionerror />

					<s:form action="addAction">
						<s:hidden name="contact.id"></s:hidden>
						<s:label value="Type" />

						<select name="echange.type">
							<s:iterator
								value="@fr.treeptik.entity.Echange$TypeEchange@values()"
								var="type">
								<option value="${type}"><s:property /></option>
							</s:iterator>
						</select>
						<br>
						<s:property value="getText('echange.add.date')" />
						<br>
						<%-- 		<s:date name="echange.date" label="Date" format="dd/MM/yyyy"/> --%>
						<%-- <s:date name="echange.date" var="formattedVal" format="yyyy-MM-dd"/> --%>
						<%--     <s:textfield name="echange.date" value="%{#formattedVal}" format="yyyy-MM-dd"/> --%>
<%-- 						<s:textfield name="echange.date" cssClass="input-small datepicker" /> --%>
						<%--   <s:param name="value"> --%>
						<%--     <s:date name="new java.util.Date()"  /> --%>
						<%--   </s:param> --%>
						<%-- </s:textfield> --%>
<!-- 						 <label class="col col-lg-3 control-label">date</label> -->
                                <div >
                                    <input type="text" class="combodate" data-format="DD-MM-YYYY HH:mm" 
                                    data-template="D  MMM  YYYY  -  HH : mm" name="dateEchange" 
                                    value='<s:date name="echange.date" format="dd-MM-YYYY HH:mm"/>' style="display: none;">
                                </div>
						<br>
						<s:property value="getText('echange.add.commentaire')" />
						<br>
						<s:textarea name="echange.commentaire" label="Commentaire"
							cols="40" rows="10" placeholder="Votre Commentaire ici ..." />
						<br>

						<s:label value="Contact" />

						<s:select name="echange.contact.id" list="contacts"
							listValue="nom + ' ' + prenom" listKey="id" />
						<%-- 			<sx:datetimepicker name="echange.date" label="Format (dd-MMM-yyyy)"  --%>
						<%-- displayFormat="dd-MMM-yyyy" value="todayDate" /> --%>
						<%-- 		<select name="entreprise.id"> --%>
						<%-- 			<s:iterator value="entreprises" var="e"> --%>
						<%-- 				<option value="${e.id}">${e.raisonSociale}</option> --%>
						<%-- 			</s:iterator> --%>
						<%-- 		</select> --%>
						<!-- 		<button type="submit" class="btn btn-white">Cancel</button> -->
						<!-- <button type="submit" class="btn btn-primary">Save changes</button> -->
						<s:submit cssClass="btn btn-primary" value="Enregistrer" />
					</s:form>
				</section>
			</div>
		</div>
	</section>
</section>

<jsp:include page="../template/footer.jsp" />
