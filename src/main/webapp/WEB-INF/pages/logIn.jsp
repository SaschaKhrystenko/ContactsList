<%--
  Created by IntelliJ IDEA.
  User: ua001022
  Date: 26.11.2015
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <script type='text/javascript'>
    function validate(){
      //вытягиваем значения из полей формы и присв. им переменные
      var userNameValue = document.forms["regForm"]["userName"].value;
      var userPasswordValue = document.forms['regForm']["userPassword"].value;
      var userFullName = document.forms["regForm"]["userFN"].value;

      //Логин (только английские символы, не меньше 3х, без спецсимволов)
      if ( userNameValue.length<3||/[^a-zA-Z]+/.test(userNameValue)){
        document.getElementById("uName").innerHTML="*wrong input, please reenter"+
        "(Login at least 3 symbols only EN)"
        return false;
      }
      else document.getElementById("uName").innerHTML=""

      //Пароль (содержание минимум 1 цифры и 1 заглавной, минимум 5 символов)
      if (userPasswordValue.length<5||!(/.*[0-9].*/.test(userPasswordValue))||!(/.*[A-Z].*/.test(userPasswordValue))){
        document.getElementById("uPasw").innerHTML="*wrong input, please reenter"+
        "(Password at least 5 symbols, min one number and one letter in upperCase)"
        return false;
      }
      else document.getElementById("uPasw").innerHTML=""

      //ФИО (минимум 5 символов)
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

<%--<form action="/logIn"  name="regForm" method="post" onsubmit='return validate()'>

  Name:<input type="text" name="userName" required="required"> <span style='color:red' id='uName'></span>
  <br>
  Password:<input type="password" name="userPassword" required="required"><span style='color:red' id='uPasw'></span>
  <br>
  Last First Middle<input type='text' name='userFN' required="required"> <span style='color:red' id='uFN'></span><br />
  <button type="submit">submit</button>

</form>--%>

<%--Error Message--%>




<%--LogIn form--%>
<form:form method="POST" commandName="account" action="/logIn" >
  <table>
    <tr>
      <td>Login :</td>
      <td><form:input path="login"/></td>
      <td><form:errors path="login" cssClass="error" /></td>
    </tr>
    <tr>
      <td>Password :</td>
      <td><form:input path="password" /></td>
      <td><form:errors path="password" cssClass="error" /></td>
    </tr>
    <tr>
      <td>FullName :</td>
      <td><form:input path="fullName" /></td>
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
        <div class="alert alert-danger text-center">Log In failed. Check your login/password.</div>
      </div>
    </div>
  </c:when>
</c:choose>

<%--Error message in case double login input --%>
<c:choose>
  <c:when test="${double_login == true}">
    <div class="row">
      <div class="container">
        <div class="alert alert-danger text-center">Sign In failed. Provided login already exist, please choose different.</div>
      </div>
    </div>
  </c:when>
</c:choose>



</body>
</html>
