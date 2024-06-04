<%-- 
    Document   : visitas
    Created on : 02-jun-2024, 13:57:42
    Author     : migue
--%>

<%@ include file="header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <body>
        <!-- Main Content -->
        <div class="container mt-4">
            <div class="row justify-content-center">
                <div class="col-md-8 text-center">
                    <h1>Visitas de UPrOpiedades</h1>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        <div class="table-responsive mt-4">
            <table class="table table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID Visita</th>
                        <th>Duración (minutos)</th>
                        <th>ID Propiedad</th>
                        <th>Propiedad</th>
                        <th>ID Visitante</th>
                        <th>Visitante</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="visitas" var="visita">
                        <tr>
                            <td><s:property value="#visita.id"></s:property></td>
                            <td><s:property value="#visita.duracion"></s:property></td>
                            <td><s:property value="#visita.idPropiedad.id"></s:property></td>
                            <td><s:property value="#visita.idPropiedad.titulo"></s:property></td>
                            <td><s:property value="#visita.idVisitante.id"></s:property></td>
                            <td><s:property value="#visita.idVisitante.nombre"></s:property></td>
                            <td>
                                <s:form id="editVisita" name="editVisita" action="editVisita" method="POST">
                                    <s:hidden name="id" value="%{#visita.id}"></s:hidden>
                                    <s:submit name="boton" value="Editar"></s:submit>
                                </s:form>
                            </td>
                            <td>
                                <s:form id="deleteVisita" name="deleteVisita" action="deleteVisita" method="POST">
                                    <s:hidden name="id" value="%{#visita.id}"></s:hidden>
                                    <s:submit name="boton" value="Eliminar" onclick="return confirm('¿Estás seguro de que quieres eliminar esta visita?');"></s:submit>
                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </body>
</html>
