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

	<%--<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.12.3.js"/>"></script>
		<script type="application/javascript" src="https://github.com/markcell/jquery-tabledit/blob/master/jquery.tabledit.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/plugin/Mottie-tablesorter-08bf513/js/jquery.tablesorter.js"/>"> </script>
	<link rel="stylesheet" href="<c:url value="/resources/plugin/Mottie-tablesorter-08bf513/css/theme.default.css"/>">--%>

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

			$('#myTable').Tabledit({
				url: 'example.php',
				columns: {
					identifier: [0, 'id'],
					editable: [[1, 'nickname'], [2, 'firstname'], [3, 'lastname']]
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
<c:if test="${editTableLine==false}">

<form:form method="POST" commandName="contact" action="/crud/add">
	<table>
		<tr>
			<td>Customer Name :</td>
			<td><form:input path="firstName"/></td>
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
		</tr>
		<tr>
		<tr>
			<td>Customer Address :</td>
			<td><form:input path="address" /></td>
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
				<td colspan="3"><input type="submit" name="addButton"
				value="<spring:message code="label.addcontact"/>" /></td>
		</tr>
	</table>
</form:form>
</c:if>


<%--form for editing data--%>
<c:if test="${editTableLine==true}">
	<form:form method="POST" commandName="contact" action="/crud/edit">
		<table>
			<tr>
				<td>Customer Name :</td>
				<td><form:input path="firstName" value="${contactToEdit.firstName}" /> </td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Customer SecondName :</td>
				<td><form:input path="secondName" value="${contactToEdit.secondName}"/></td>
				<td><form:errors path="secondName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Customer Patronymic :</td>
				<td><form:input path="patronymic" value="${contactToEdit.patronymic}"/></td>
				<td><form:errors path="patronymic" cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td>Customer PhoneNumber :</td>
				<td><form:input path="phoneNumber" value="${contactToEdit.phoneNumber}"/></td>
				<td><form:errors path="phoneNumber" cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td>Customer Address :</td>
				<td><form:input path="address" value="${contactToEdit.address}"/></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td>Customer MobileNumber :</td>
				<td><form:input path="mobileNumber" value="${contactToEdit.mobileNumber}" /></td>
				<td><form:errors path="mobileNumber" cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td>Customer email :</td>
				<td><form:input path="email" value="${contactToEdit.email}"/></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
				<%--hiden values--%>
			<td><input id="account_id_2" type=hidden name="account_id" value="${account_id}"  /></td>
			<td><input id="contact_id" type=hidden name="contact_id" value="${contact_id}"  /></td>

			</tr>
			<td><input type="submit" name="save_button"
					   value="<spring:message code="label.save"/>" /></td>
			<td><input action="action" type="button" onclick="history.go(-1);"
					   value="<spring:message code="label.cancel"/>"/></td>

			</tr>
		</table>
	</form:form>
</c:if>

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
				<td><a href="/crud/edit/${contact.id}/${account_id}"><spring:message code="label.edit" /></a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>



</body>
</html>