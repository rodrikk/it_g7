<%@ include file="header.jsp" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <body>
        <section class="propiedad">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-6 my-3">
                        <img src="" alt="Imagen de la propiedad">
                    </div>
                    <div class="col-md-6">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item"><strong>Título: </strong><s:property value="propiedad.titulo"></s:property></li>
                            <li class="list-group-item"><strong>Descripción: </strong><s:property value="propiedad.descripcion"></s:property></li>
                            <li class="list-group-item"><strong>Superficie: </strong><s:property value="propiedad.superficie"></s:property> m<sup>2</sup></li>
                            <li class="list-group-item"><strong>Número de habitaciones: </strong><s:property value="propiedad.numeroHabitaciones"></s:property></li>
                            <li class="list-group-item"><strong>Dirección: </strong><s:property value="propiedad.idDireccion.calle + ', ' + propiedad.idDireccion.numero + ', ' + propiedad.idDireccion.ciudad + ', ' + propiedad.idDireccion.provincia + ', ' + propiedad.idDireccion.pais"></s:property></li>
                            <li class="list-group-item"><strong>Código Postal: </strong><s:property value="propiedad.idDireccion.codigoPostal"></s:property></li>
                                <c:choose>
                                    <c:when test="${propiedad.idOperacion.id == 1}">
                                    <li class="list-group-item"><strong>Precio: </strong><s:property value="propiedad.precio"></s:property> €</li>
                                    </c:when>
                                    <c:otherwise>
                                    <li class="list-group-item"><strong>Precio: </strong><s:property value="propiedad.precio"></s:property> €/día</li>
                                    </c:otherwise>
                                </c:choose>

                            <s:if test="%{#session.idUsuario != propiedad.idPropietario.id}">
                                <li>
                                    <s:if test="%{existeValoracion}">
                                        <s:form id="editarValoracion" name="editarValoracion" action="editarValoracion" method="POST">
                                            <label for="rating">Valoración:</label>
                                            <select id="rating" name="rating">
                                                <option value="0">0</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                            </select>
                                            <s:hidden name="idPropiedad" value="%{propiedad.id}" />
                                            <s:hidden name="idValorador" value="%{#session.idUsuario}" />
                                            <s:submit name="boton" value="Editar valoración" />
                                        </s:form>

                                        <s:form id="borrarValoracion" name="borrarValoracion" action="borrarValoracion" method="POST">
                                            <s:hidden name="idPropiedad" value="%{propiedad.id}" />
                                            <s:hidden name="idValorador" value="%{#session.idUsuario}" />
                                            <s:submit name="boton" value="Borrar valoración" />
                                        </s:form>
                                    </s:if>
                                    <s:else>
                                        <s:form id="valorarPropiedad" name="valorarPropiedad" action="valorarPropiedad" method="POST">
                                            <label for="rating">Valoración:</label>
                                            <select id="rating" name="rating">
                                                <option value="0">0</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                            </select>
                                            <s:hidden name="idPropiedad" value="%{propiedad.id}" />
                                            <s:hidden name="idValorador" value="%{#session.idUsuario}" />
                                            <s:submit name="boton" value="Valorar" />
                                        </s:form>
                                    </s:else>


                                    <s:if test="%{propiedad.idOperacion.id == 1}">
                                        <s:form id="comprarPropiedad" name="comprarPropiedad" action="comprarPropiedad" method="POST">
                                            <s:hidden name="idPropiedad" value="%{propiedad.id}" />
                                            <s:hidden name="idPropietario" value="%{propiedad.idPropietario.id}" />
                                            <s:hidden name="idComprador" value="%{#session.idUsuario}" />
                                            <s:submit name="boton" value="Comprar" />
                                        </s:form>
                                    </s:if>
                                    <s:elseif test="%{propiedad.idOperacion.id == 2}">
                                        <s:if test="%{propiedad.idInquilino == null}">
                                            <button onclick="mostrarFormulario()">Alquilar</button>
                                            <s:form id="alquilarPropiedad" name="alquilarPropiedad" action="alquilarPropiedad" method="POST" style="display: none;">
                                                <label for="fecha">Fecha inicio:</label>
                                                <input type="date" id="fechaInicio" name="fechaInicio" required><br/>
                                                <label for="fecha">Fecha fin:</label>
                                                <input type="date" id="fechaFin" name="fechaFin" required>
                                                <s:hidden name="idPropiedad" value="%{propiedad.id}" />
                                                <s:hidden name="idPropietario" value="%{propiedad.idPropietario.id}" />
                                                <s:hidden name="idAlquilado" value="%{#session.idUsuario}" />
                                                <s:submit name="boton" value="Confirmar alquiler" />
                                            </s:form>
                                        </s:if>
                                        <s:else>
                                            <p>Propiedad alquilada</p>
                                        </s:else>
                                    </s:elseif>
                                    <s:elseif test="%{propiedad.idOperacion.id == 3}">
                                        <p>Propiedad no disponible</p>
                                    </s:elseif>
                                </li>
                            </s:if>
                            <s:if test="%{#session.existeFavorito}">
                                <s:form id="borrarFavoritos" name="borrarFavoritos" action="borrarFavoritos" method="POST">
                                    <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                                    <s:hidden name="idPropiedad" value="%{propiedad.id}" />
                                    <s:submit name="boton" value="Eliminar de favoritos"></s:submit>
                                </s:form>
                            </s:if>
                            <s:else>
                                <s:form id="agregarFavoritos" name="agregarFavoritos" action="agregarFavoritos" method="POST">
                                    <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                                    <s:hidden name="idPropiedad" value="%{propiedad.id}" />
                                    <s:submit value="Añadir a favoritos"></s:submit>
                                </s:form>
                            </s:else>
                        </ul>
                    </div>
                </div>
            </div>     
        </section>
        <script type="text/javascript">
            function mostrarFormulario() {
                var formulario = document.getElementById("alquilarPropiedad");
                if (formulario.style.display === "none" || formulario.style.display === "") {
                    formulario.style.display = "block";
                } else {
                    formulario.style.display = "none";
                }
            }
        </script>
    </body>
</html>
