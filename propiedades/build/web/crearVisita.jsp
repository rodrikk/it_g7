<%-- 
    Document   : crearVisita
    Created on : 04-jun-2024, 21:54:16
    Author     : Rodri
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Crear Visita</title>
</head>
<body>
    <div class="container mt-4">
        <h1>Crear Visita</h1>
        <s:form id="createVisita" name="createVisita" action="createVisita" method="POST" cssClass="form-horizontal">
            <!-- Duración -->
            <div class="mb-3">
                <s:textfield label="Duración (minutos)" name="duracion" id="duracion" cssClass="form-control"/>
            </div>

            <!-- Propiedad ID -->
            <div class="mb-3">
                <s:textfield label="Propiedad ID" name="idPropiedad" id="idPropiedad" cssClass="form-control"/>
            </div>

            <!-- Visitante ID -->
            <div class="mb-3">
                <s:textfield label="Visitante ID" name="idVisitante" id="idVisitante" cssClass="form-control"/>
            </div>

            <!-- Submit Button -->
            <div class="mb-3">
                <s:submit name="boton" value="Crear Visita" cssClass="btn btn-success"/>
            </div>
        </s:form>
    </div>
</body>
</html>
