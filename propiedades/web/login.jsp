<%-- 
    Document   : login
    Created on : 01-jun-2024, 18:34:27
    Author     : migue
--%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:if test="%{!error.isEmpty}">
            <p style="color: red;">Mensaje de error: <s:property value="error"/></p>
        </s:if>
        <div class="login-container">
            <h2>Inicio de Sesión</h2>
            <s:form id="login" name="login" action="login" method="POST">
                <s:textfield name="email" label="Email"></s:textfield>
                <s:password name="password" label="Contraseña"></s:password>
                <s:submit value="Iniciar sesión"></s:submit>
            </s:form>
        </div>
    </body>
</html>
