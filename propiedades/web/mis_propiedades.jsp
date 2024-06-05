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
                    <h1>Mis Propiedades</h1>
                </div>
            </div>

            <s:form id="formAgregarPropiedad" name="formAgregarPropiedad" action="formAgregarPropiedad" method="POST" cssClass="text-center my-3">
                <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                <s:submit name="boton" value="Añadir propiedad" cssClass="btn btn-success"></s:submit>
            </s:form>

            <s:if test="!misPropiedades.isEmpty()">
                <div class="row row-cols-1 row-cols-md-2 g-4">
                    <s:iterator value="misPropiedades" var="propiedad">
                        <div class="col">
                            <div class="card">
                                <img src="<s:property value="#propiedad.foto"></s:property>" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title"><s:property value="#propiedad.titulo"></s:property></h5>
                                    <p class="card-text"><s:property value="#propiedad.descripcion"></s:property></p>
                                    <p class="card-text"><small class="text-muted"><s:property value="#propiedad.superficie"></s:property> m<sup>2</sup>, <s:property value="#propiedad.numeroHabitaciones"></s:property> habitaciones</small></p>
                                </div>
                                <div class="card-footer">
                                    <s:form id="verPropiedad" name="verPropiedad" action="verPropiedad" method="POST" cssClass="d-inline">
                                        <s:hidden name="idPropiedad" value="%{#propiedad.id}"/>
                                        <s:hidden name="idValorador" value="%{#session.idUsuario}"/>
                                        <s:submit name="boton" value="Ver" cssClass="btn btn-info btn-sm"></s:submit>
                                    </s:form>
                                    <s:form id="formEditarPropiedad" name="formEditarPropiedad" action="formEditarPropiedad" method="POST" cssClass="d-inline ms-2">
                                        <s:hidden name="idPropiedad" value="%{#propiedad.id}"/>
                                        <s:submit name="boton" value="Editar" cssClass="btn btn-warning btn-sm"></s:submit>
                                    </s:form>
                                    <s:form id="borrarPropiedad" name="borrarPropiedad" action="borrarPropiedad" method="POST" cssClass="d-inline ms-2">
                                        <s:hidden name="idPropiedad" value="%{#propiedad.id}"/>
                                        <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                                        <s:submit name="boton" value="Borrar" cssClass="btn btn-danger btn-sm"></s:submit>
                                    </s:form>
                                </div>
                            </div>
                        </div>
                    </s:iterator>
                </div>
            </s:if>
            <s:else>
                <p class="text-center">No dispone de ninguna propiedad</p>
            </s:else>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>