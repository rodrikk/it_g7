<%-- 
    Document   : editarSeguro
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
    <title>Editar Seguro</title>
</head>
<body>
    <div class="container mt-4">
        <h1>Editar Seguro</h1>
        <s:form id="editSeguro" name="editSeguro" action="editSeguro" method="POST" cssClass="form-horizontal">
            <!-- Hidden fields for ID -->
            <s:hidden name="id" value="%{seguro.id}" />
            <s:property value="seguro" />
            <!-- Cobertura -->
            <div class="mb-3">
                <s:textfield label="Cobertura" name="cobertura" id="cobertura" value="%{seguro.cobertura}" cssClass="form-control"/>
            </div>

            <!-- Tarifa -->
            <div class="mb-3">
                <s:textfield label="Tarifa (€ / mes)" name="tarifa" id="tarifa" value="%{seguro.tarifa}" cssClass="form-control"/>
            </div>

            <!-- Fecha de Inicio -->
            <div class="mb-3">
                <s:textfield label="Fecha de Inicio" name="fechaInicio" id="fechaInicio" value="<fmt:formatDate value='%{seguro.fechaInicio}' pattern='yyyy-MM-dd'/>" cssClass="form-control" type="date"/>
            </div>

            <!-- Fecha de Fin -->
            <div class="mb-3">
                <s:textfield label="Fecha de Fin" name="fechaFin" id="fechaFin" value="<fmt:formatDate value='%{seguro.fechaFin}' pattern='yyyy-MM-dd'/>" cssClass="form-control" type="date"/>
            </div>

            <!-- Propiedad ID -->
            <div class="mb-3">
                <s:textfield label="Propiedad ID" name="idPropiedad" id="idPropiedad" value="%{seguro.idPropiedad.id}" cssClass="form-control"/>
            </div>

            <!-- Inquilino ID -->
            <div class="mb-3">
                <s:textfield label="Inquilino ID" name="idInquilino" id="idInquilino" value="%{seguro.idInquilino.id}" cssClass="form-control"/>
            </div>

            <!-- Submit Button -->
            <div class="mb-3">
                <s:submit name="boton" value="Actualizar Seguro" cssClass="btn btn-primary"/>
            </div>
        </s:form>
    </div>

</body>
</html>
