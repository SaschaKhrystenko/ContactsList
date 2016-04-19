
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

  <script type='text/javascript'>
    function validate(){
      var userNameValue = document.forms["regForm"]["userName"].value;
      var userPasswordValue = document.forms['regForm']["userPassword"].value;
      var userFullName = document.forms["regForm"]["userFN"].value;

      if ( userNameValue.length<3||/[^a-zA-Z]+/.test(userNameValue)){
        document.getElementById("uName").innerHTML="*wrong input, please reenter"+
        "(Login at least 3 symbols only EN)"
        return false;
      }
      else document.getElementById("uName").innerHTML=""

      if (userPasswordValue.length<5||!(/.*[0-9].*/.test(userPasswordValue))||!(/.*[A-Z].*/.test(userPasswordValue))){
        document.getElementById("uPasw").innerHTML="*wrong input, please reenter"+
        "(Password at least 5 symbols, min one number and one letter in upperCase)"
        return false;
      }
      else document.getElementById("uPasw").innerHTML=""

      if ( userFullName.length<5||/[^a-zA-Z]+/.test(userFullName)){
        document.getElementById("uFN").innerHTML="*wrong input, please repeat"+
        "(At least 5 symbols)"
        return false;
      }
      else document.getElementById("uFN").innerHTML=""

    }

  </script>


    <title></title>

  <style>
    .error {
      color: #ff0000;
    }

  </style>
</head>

<body>


<%--LogIn form--%>
<form:form method="POST" commandName="account" action="/logIn" name="regForm" onsubmit='return validate()' >
  <table>
    <tr>
      <td>Login * :</td>
      <td><form:input path="login" required="required" name="userName" /> <span style='color:red' id='uName'></span></td>
      <td><form:errors path="login" cssClass="error" /></td>
    </tr>
    <tr>
      <td>Password * :</td>
      <td><form:input path="password" type="password" required="required" name="userPassword"/><span style='color:red' id='uPasw'></span</td>
      <td><form:errors path="password" cssClass="error" /></td>
    </tr>
    <tr>
      <td>FullName * :</td>
      <td><form:input path="fullName" required="required" name="userFN"/> <span style='color:red' id='uFN'></span></td>
      <td><form:errors path="fullName" cssClass="error" /></td>
    </tr>
    <tr>
        <td colspan="3"><input type="submit" name="login_button"
                           value="<spring:message code="label.logIn"/>" /></td>
    </tr>
         <td colspan="3"><input type="submit" name="signIn_button"
                             value="<spring:message code="label.signIn"/>" /></td>
    </tr>
  </table>
</form:form>

<%--Error message in case wrong password/login--%>
<c:choose>
  <c:when test="${error == true}">
    <div class="row">
      <div class="container">
        <div class="error">Log In failed. Check your login/password.</div>
      </div>
    </div>
  </c:when>
</c:choose>

<%--Error message in case double login input --%>
<c:choose>
  <c:when test="${double_login == true}">
    <div class="row">
      <div class="container">
        <div class="error">Sign In failed. Provided login already exist, please choose different.</div>
      </div>
    </div>
  </c:when>
</c:choose>


</body>
</html>
