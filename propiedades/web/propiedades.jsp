<%@include file="header.jsp" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-r4NyJjSL3QUNp5bDFH8SI7X6UpgfyD0PwnxFOLtE9i5z8gjZwGy5IBPTmZLAb9a6" crossorigin="anonymous">
    </head>
    <body>
        <!-- Main Content -->
        <div class="container mt-4">
            <div class="row justify-content-center">
                <div class="col-md-8 text-center">
                    <h1 class="display-4">Bienvenidos a UPrOpiedades</h1>
                </div>
            </div>

            <s:if test="%{#session.idUsuario}">
                <s:form id="buscarPropiedades" name="buscarPropiedades" action="buscarPropiedades" method="POST" cssClass="mb-3">
                    <div class="input-group">
                        <s:textfield id="ciudad" name="ciudad" placeholder="Buscar por ciudad" cssClass="form-control"/>
                        <div class="input-group-append">
                            <s:submit name="boton" value="Buscar" cssClass="btn btn-primary"></s:submit>
                        </div>
                    </div>
                </s:form>
            </s:if>

            <div class="table-responsive mt-4">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Imagen</th>
                            <th>Título</th>
                            <th>Descripción</th>
                            <th>Superficie</th>
                            <th>Habitaciones</th>
                            <th>Valoración</th>
                            <s:if test="%{#session.idUsuario}">
                                <th>Acciones</th>
                            </s:if>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="valoracionesTotales" var="valoracionTotal">
                            <tr>
                                <td><img src="<s:property value="#valoracionTotal.idPropiedad.foto"></s:property>" class="img-thumbnail"/></td>
                                <td><s:property value="#valoracionTotal.idPropiedad.titulo"></s:property></td>
                                <td><s:property value="#valoracionTotal.idPropiedad.descripcion"></s:property></td>
                                <td><s:property value="#valoracionTotal.idPropiedad.superficie"></s:property> m<sup>2</sup></td>
                                <td><s:property value="#valoracionTotal.idPropiedad.numeroHabitaciones"></s:property></td>
                                <td class="puntuacion-<s:property value='#valoracionTotal.id'/>" data-puntuacion="<s:property value='#valoracionTotal.valoracionTotal'/>">
                                    <div class="rating" id="rating-<s:property value='#valoracionTotal.id'/>">
                                        <i class="bi bi-star-fill star" id="<s:property value="'1' + #valoracionTotal.id"></s:property>" value="1"></i>
                                        <i class="bi bi-star-fill star" id="<s:property value="'2' + #valoracionTotal.id"></s:property>" value="2"></i>
                                        <i class="bi bi-star-fill star" id="<s:property value="'3' + #valoracionTotal.id"></s:property>" value="3"></i>
                                        <i class="bi bi-star-fill star" id="<s:property value="'4' + #valoracionTotal.id"></s:property>" value="4"></i>
                                        <i class="bi bi-star-fill star" id="<s:property value="'5' + #valoracionTotal.id"></s:property>" value="5"></i>
                                    </div>
                                </td>
                                <s:if test="%{#session.idUsuario}">
                                    <td>
                                        <s:form id="verPropiedad" name="verPropiedad" action="verPropiedad" method="POST" cssClass="d-inline">
                                            <s:hidden name="idPropiedad" value="%{#valoracionTotal.idPropiedad.id}"/>
                                            <s:hidden name="idValorador" value="%{#session.idUsuario}"/>
                                            <s:submit name="boton" value="Ver propiedad" cssClass="btn btn-primary btn-sm"></s:submit>
                                        </s:form>
                                    </td>
                                </s:if>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
            <script type="text/javascript">
                function inicializarEstrellas() {
                    var valoraciones = document.querySelectorAll('.rating');
                    valoraciones.forEach(function (ratingElement) {
                        var id = ratingElement.id.split('-').pop();
                        var puntuacionElement = document.querySelector("td.puntuacion-" + id);
                        var puntuacion = parseInt(puntuacionElement.getAttribute("data-puntuacion"));
                        var estrellas = ratingElement.querySelectorAll('.bi.star');
                        estrellas.forEach(function (star, index) {
                            if (index < puntuacion) {
                                star.classList.add('checked');
                            }
                        });
                    });
                }

                document.addEventListener('DOMContentLoaded', inicializarEstrellas);
            </script>
        </div>
    </body>
</html>
