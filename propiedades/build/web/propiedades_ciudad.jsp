<%@ include file="header.jsp" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <body>
        <!-- Main Content -->
        <div class="container mt-4">
            <div class="row justify-content-center">
                <div class="col-md-8 text-center">
                    <h1 class="display-4">Propiedades en <s:property value="ciudad"></s:property></h1>
                </div>
            </div>

            <s:form id="buscarPropiedades" name="buscarPropiedades" action="buscarPropiedades" method="POST" cssClass="mb-3">
                <div class="input-group">
                    <s:textfield id="ciudad" name="ciudad"  placeholder="Buscar por ciudad" cssClass="form-control"/>
                    <div class="input-group-append">
                        <s:submit name="boton" value="Buscar" cssClass="btn btn-primary"></s:submit>
                    </div>
                </div>
            </s:form>

            <s:if test="!propiedadesCiudad.isEmpty()">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Imagen</th>
                            <th>Título</th>
                            <th>Descripción</th>
                            <th>Superficie</th>
                            <th>Habitaciones</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="propiedadesCiudad" var="propiedad">
                            <tr>
                                <td><img src="<s:property value="#propiedad.foto"></s:property>" class="img-thumbnail"/></td>
                                <td><s:property value="#propiedad.titulo"></s:property></td>
                                <td><s:property value="#propiedad.descripcion"></s:property></td>
                                <td><s:property value="#propiedad.superficie"></s:property> m<sup>2</sup></td>
                                <td><s:property value="#propiedad.numeroHabitaciones"></s:property></td>
                                <td>
                                    <s:form id="verPropiedad" name="verPropiedad" action="verPropiedad" method="POST" cssClass="d-inline">
                                        <s:hidden name="idPropiedad" value="%{#propiedad.id}"/>
                                        <s:hidden name="idValorador" value="%{#session.idUsuario}"/>
                                        <s:submit name="boton" value="Ver" cssClass="btn btn-info btn-sm"></s:submit>
                                    </s:form>
                                    <s:form id="formEditarPropiedad" name="formEditarPropiedad" action="formEditarPropiedad" method="POST" cssClass="d-inline">
                                        <s:hidden name="idPropiedad" value="%{#propiedad.id}"/>
                                        <s:submit name="boton" value="Editar" cssClass="btn btn-warning btn-sm"></s:submit>
                                    </s:form>
                                    <s:form id="borrarPropiedad" name="borrarPropiedad" action="borrarPropiedad" method="POST" cssClass="d-inline">
                                        <s:hidden name="idPropiedad" value="%{#propiedad.id}"/>
                                        <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                                        <s:submit name="boton" value="Borrar" cssClass="btn btn-danger btn-sm"></s:submit>
                                    </s:form>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                <div class="alert alert-warning" role="alert">
                    No hay propiedades disponibles en <s:property value="ciudad"></s:property>
                </div>
            </s:else>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>