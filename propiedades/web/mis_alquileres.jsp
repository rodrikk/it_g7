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
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        <s:if test="%{!alquileres.isEmpty()}">
            <table border="1">
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
                            <td><!-- Poner lo necesario para que se vea la imagen --></td>
                            <td><s:property value="#alquiler.idPropiedad.titulo"></s:property></td>
                            <td><s:property value="#alquiler.idPropiedad.descripcion"></s:property></td>
                            <td><s:property value="#alquiler.idPropiedad.superficie"></s:property> m2</td>
                            <td><s:property value="#alquiler.idPropiedad.numeroHabitaciones"></s:property></td>
                            <td><s:property value="#alquiler.idPropiedad.precio"></s:property> €/día</td>
                            <td><s:property value="#alquiler.fechaInicio"></s:property></td>
                            <td><s:property value="#alquiler.fechaFin"></s:property></td>
                            <td>
                                <s:form id="editarAlquiler" name="editarAlquiler" action="editarAlquiler" method="POST" style="display: none;">
                                    <label for="fecha">Fecha inicio:</label>
                                    <input type="date" id="fechaInicio" name="fechaInicio" required><br/>
                                    <label for="fecha">Fecha fin:</label>
                                    <input type="date" id="fechaFin" name="fechaFin" required>
                                    <s:hidden name="idAlquiler" value="%{#alquiler.id}"/>
                                    <s:hidden name="idUsuario" value="%{#session.idUsuario}"/>
                                    <s:submit name="boton" value="Confirmar" />
                                </s:form>
                            </td>
                            <td>
                                <s:form id="verPropiedad" name="verPropiedad" action="verPropiedad" method="POST">
                                    <s:hidden name="idPropiedad" value="%{#alquiler.idPropiedad.id}"/>
                                    <s:submit name="boton" value="Ver propiedad"></s:submit>
                                </s:form>
                            </td>
                            <td>
                                <button onclick="mostrarFormulario()">Editar alquiler</button>
                            </td>
                            <td>
                                <s:form id="cancelarAlquiler" name="cancelarAlquiler" action="cancelarAlquiler" method="POST">
                                    <s:hidden name="idAlquiler" value="%{#alquiler.id}"/>
                                    <s:hidden name="idUsuario" value="%{#session.idUsuario}"/>
                                    <s:hidden name="idPropiedad" value="%{#alquiler.idPropiedad.id}"/>
                                    <s:submit name="boton" value="Cancelar alquiler"></s:submit>
                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:else>
            <p>Todavía no has alaquilado</p>
        </s:else>
        <script type="text/javascript">
            function mostrarFormulario() {
                var formulario = document.getElementById("editarAlquiler");
                if (formulario.style.display === "none" || formulario.style.display === "") {
                    formulario.style.display = "block";
                } else {
                    formulario.style.display = "none";
                }
            }
        </script>
    </body>
</html>
