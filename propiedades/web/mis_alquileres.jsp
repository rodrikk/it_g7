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
                    <h1>Mis alquileres</h1>
                </div>
            </div>

            <s:if test="%{!alquileres.isEmpty()}">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Imagen</th>
                                <th>Título</th>
                                <th>Descripción</th>
                                <th>Superficie</th>
                                <th>Habitaciones</th>
                                <th>Precio</th>
                                <th>Fecha inicio</th>
                                <th>Fecha fin</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="alquileres" var="alquiler">
                                <tr>
                                    <td><img src="<s:property value="#alquiler.idPropiedad.foto"></s:property>"/></td>
                                    <td><s:property value="#alquiler.idPropiedad.titulo"></s:property></td>
                                    <td><s:property value="#alquiler.idPropiedad.descripcion"></s:property></td>
                                    <td><s:property value="#alquiler.idPropiedad.superficie"></s:property> m<sup>2</sup></td>
                                    <td><s:property value="#alquiler.idPropiedad.numeroHabitaciones"></s:property></td>
                                    <td><s:property value="#alquiler.idPropiedad.precio"></s:property> €/día</td>
                                    <td><s:property value="#alquiler.fechaInicio"></s:property></td>
                                    <td><s:property value="#alquiler.fechaFin"></s:property></td>
                                    <td>
                                        <button class="btn btn-primary" onclick="mostrarFormulario()">Editar alquiler</button>
                                    </td>
                                    <td>
                                        <s:form id="cancelarAlquiler" name="cancelarAlquiler" action="cancelarAlquiler" method="POST">
                                            <s:hidden name="idAlquiler" value="%{#alquiler.id}"/>
                                            <s:hidden name="idUsuario" value="%{#session.idUsuario}"/>
                                            <s:hidden name="idPropiedad" value="%{#alquiler.idPropiedad.id}"/>
                                            <s:submit name="boton" value="Cancelar alquiler" cssClass="btn btn-danger"></s:submit>
                                        </s:form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
            </s:if>
            <s:else>
                <p>Todavía no has alaquilado</p>
            </s:else>

            <!-- Edit Rental Form -->
            <div class="modal" tabindex="-1" id="editRentalModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Editar Alquiler</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <s:form id="editarAlquiler" name="editarAlquiler" action="editarAlquiler" method="POST">
                    <div class="mb-3">
                        <label for="fechaInicio" class="form-label">Fecha inicio:</label>
                        <input type="date" id="fechaInicio" name="fechaInicio" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="fechaFin" class="form-label">Fecha fin:</label>
                        <input type="date" id="fechaFin" name="fechaFin" class="form-control" required>
                    </div>
                    <s:hidden name="idAlquiler" value="%{#alquiler.id}"/>
                    <s:hidden name="idUsuario" value="%{#session.idUsuario}"/>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Confirmar</button>
                    </div>
                </s:form>
            </div>
        </div>
    </div>
</div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
            <script type="text/javascript">
                function mostrarFormulario() {
                    var myModal = new bootstrap.Modal(document.getElementById('editRentalModal'), {});
                    myModal.show();
                }
            </script>
        </div>
    </body>
</html>