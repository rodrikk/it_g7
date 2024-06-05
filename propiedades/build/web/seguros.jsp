<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Seguros</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="container my-5">
            <h1 class="text-center mb-4">Seguros de UPrOpiedades</h1>

                    <s:iterator var="seguro" value="seguros">
                        <h2>Seguro ID: ${seguro.id}</h2>
                        <div class="card">
                            <div class="card-header bg-primary text-white">Seguro ${seguro.id}</div>
                            <div class="card-body">
                                <h5 class="card-title">Tarifa: ${seguro.tarifa} €/mes</h5>
                                <ul class="list-unstyled">
                                    <li>
                                        <strong>Cobertura:</strong>
                                        <ul>
                                            <c:set var="coberturas" value="${fn:split(seguro.cobertura, ',')}" />
                                            <c:forEach var="cobertura" items="${coberturas}">
                                                <li>${cobertura}</li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li><strong>Fecha de Inicio:</strong> <fmt:formatDate value="${seguro.fechaInicio}" pattern="dd/MM/yyyy"/></li>
                                    <li><strong>Fecha de Fin:</strong> <fmt:formatDate value="${seguro.fechaFin}" pattern="dd/MM/yyyy"/></li>
                                    <li><strong>Propiedad ID:</strong> ${seguro.idPropiedad.id}</li>
                                    <li><strong>Inquilino ID:</strong> ${seguro.idInquilino.id}</li>
                                </ul>
                                <!-- Edit Button -->
                                <s:form name="viewEditarSeguro" id="viewEditarSeguro" action="viewEditarSeguro" method="POST">
                                    <s:hidden name="id" value="%{#seguro.id}"/>
                                    <s:submit name="boton" value="Editar" cssClass="btn btn-warning"/>
                                </s:form>
                                <!-- Delete Button -->
                                <s:form id="deleteSeguro" name="deleteSeguro" action="deleteSeguro" method="POST">
                                    <s:hidden name="id" value="%{#seguro.id}"/>
                                    <s:submit name="boton" onclick="return confirm('¿Estás seguro de que quieres eliminar este seguro?');" value="Eliminar" cssClass="btn btn-danger"></s:submit>
                                </s:form>
                            </div>
                        </div>
                    </s:iterator>
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
