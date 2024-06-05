<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Visita</title>
</head>
<body>
    <div class="container mt-4">
        <h1>Editar Visita</h1>
        <s:form id="editVisita" name="editVisita" action="editVisita" method="POST" cssClass="form-horizontal">
            <!-- Hidden fields for ID -->
            <s:hidden name="id" value="%{visita.id}" />
            <!-- Cobertura -->
            <div class="mb-3">
                <s:textfield label="Duración(minutos)" name="duracion" id="duracion" value="%{visita.duracion}" cssClass="form-control"/>
            </div>

            <!-- Propiedad ID -->
            <div class="mb-3">
                <s:textfield label="Propiedad ID" name="idPropiedad" id="idPropiedad" value="%{visita.idPropiedad.id}" cssClass="form-control"/>
            </div>

            <!-- Inquilino ID -->
            <div class="mb-3">
                <s:textfield label="Visitante ID" name="idVisitante" id="idVisitante" value="%{visita.idVisitante.id}" cssClass="form-control"/>
            </div>

            <!-- Submit Button -->
            <div class="mb-3">
                <s:submit name="boton" value="Actualizar Visita" cssClass="btn btn-primary"/>
            </div>
        </s:form>
    </div>

</body>
</html>
