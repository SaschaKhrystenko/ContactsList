<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title></title>
<head>



	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/tablesorter/2.17.4/js/jquery.tablesorter.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.25.8/css/theme.default.min.css">


	<%--Problem with local libraries *Failed to load resource: Server respomonded with status 404 (Not Found) --%>

	<%--<c:url value="/js/jquery-1.12.3.js" var="myUrl" />
	<script type="text/javascript" src="${myUrl}"/>
	<script type="text/javascript" src="/plugin/Mottie-tablesorter-08bf513/js/jquery.tablesorter.js"> </script>
	<link rel="stylesheet" href="/plugin/Mottie-tablesorter-08bf513/css/theme.default.css">--%>

	<script>


		$(document).ready(function() {
			$("#myTable").tablesorter({
				// pass the headers argument and assing a object
				headers: {
					// assign the secound column (we start counting zero)
					2: {
						// disable it by setting the property sorter to false
						sorter: false
					},
					4: {
						sorter: false
					},
					5: {
						sorter: false
					},
					6: {
						sorter: false
					}
				}
			});
		});


	</script>

	<style>
		.error {
			color: #ff0000;
		}

	</style>
</head>

<body>

<%--Success Message--%>
<c:if test="${success}">
	<div class="row" style="width: 700px">
		<div class="container">
			<h3 class="text-center" style="color: green;">Congratulations!</h3>
			<div class="alert alert-success text-center">${userName} You have passed registration successfully! </div>
		</div>
	</div>
</c:if>

<%--Input contact data form--%>
<form:form method="POST" commandName="contact" action="/crud/add">
	<table>
		<tr>
			<td>Customer Name :</td>
			<td><form:input path="firstName" /></td>
			<td><form:errors path="firstName" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Customer SecondName :</td>
			<td><form:input path="secondName" /></td>
			<td><form:errors path="secondName" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Customer Patronymic :</td>
			<td><form:input path="patronymic" /></td>
			<td><form:errors path="patronymic" cssClass="error" /></td>
		</tr>
		<tr>
		<tr>
			<td>Customer PhoneNumber :</td>
			<td><form:input path="phoneNumber" /></td>
			<td><form:errors path="phoneNumber" cssClass="error" /></td>
		</tr>
		<tr>
		<tr>
			<td>Customer Address :</td>
			<td><form:input path="address" /></td>
			<td><form:errors path="address" cssClass="error" /></td>
		</tr>
		<tr>
		<tr>
			<td>Customer MobileNumber :</td>
			<td><form:input path="mobileNumber" /></td>
			<td><form:errors path="mobileNumber" cssClass="error" /></td>
		</tr>
		<tr>
		<tr>
			<td>Customer email :</td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email" cssClass="error" /></td>
		</tr>
		</tr>
				<td><input id="account_id" type=hidden name="account_id" value="${account_id}"  /></td>
				<td colspan="3"><input type="submit"
				value="<spring:message code="label.addcontact"/>" /></td>
		</tr>
	</table>
</form:form>


<%--Contact data table--%>
<c:if test="${!empty usersContactList}">
	<table id="myTable" class="tablesorter">
		<thead>
		<tr>
			<th><spring:message code="label.firstname" /></th>
			<th><spring:message code="label.secondName" /></th>
			<th><spring:message code="label.patronymic" /></th>
			<th><spring:message code="label.mobileNumber" /></th>
			<th><spring:message code="label.phoneNumber" /></th>
			<th><spring:message code="label.address" /></th>
			<th><spring:message code="label.email" /></th>
			<th>&nbsp;</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${usersContactList}" var="contact">
			<tr>
				<td>${contact.firstName}</td>
				<td>${contact.secondName}</td>
				<td>${contact.patronymic}</td>
				<td>${contact.mobileNumber}</td>
				<td>${contact.phoneNumber}</td>
				<td>${contact.address}</td>
				<td>${contact.email}</td>

				<td><a href="/crud/delete/${contact.id}/${account_id}"><spring:message code="label.delete" /></a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>



</body>
</html>