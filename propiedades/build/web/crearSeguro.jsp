<%-- 
    Document   : crearSeguro
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
    <title>Crear Seguro</title>
</head>
<body>
    <div class="container mt-4">
        <h1>Crear Seguro</h1>
        <s:form id="createSeguro" name="createSeguro" action="createSeguro" method="POST" cssClass="form-horizontal">
            <!-- Cobertura -->
            <div class="mb-3">
                <s:textfield label="Cobertura" name="cobertura" id="cobertura" cssClass="form-control"/>
            </div>

            <!-- Tarifa -->
            <div class="mb-3">
                <s:textfield label="Tarifa (€ / mes)" name="tarifa" id="tarifa" cssClass="form-control"/>
            </div>

            <!-- Fecha de Inicio -->
            <div class="mb-3">
                <s:textfield label="Fecha de Inicio" name="fechaInicio" id="fechaInicio" cssClass="form-control" type="date"/>
            </div>

            <!-- Fecha de Fin -->
            <div class="mb-3">
                <s:textfield label="Fecha de Fin" name="fechaFin" id="fechaFin" cssClass="form-control" type="date"/>
            </div>

            <!-- Propiedad ID -->
            <div class="mb-3">
                <s:textfield label="Propiedad ID" name="idPropiedad" id="idPropiedad" cssClass="form-control"/>
            </div>

            <!-- Inquilino ID -->
            <div class="mb-3">
                <s:textfield label="Inquilino ID" name="idInquilino" id="idInquilino" cssClass="form-control"/>
            </div>

            <!-- Submit Button -->
            <div class="mb-3">
                <s:submit name="boton" value="Crear Seguro" cssClass="btn btn-success"/>
            </div>
        </s:form>
    </div>

</body>
</html>
