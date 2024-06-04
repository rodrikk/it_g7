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
                    <h1>Bienvenidos a UPrOpiedades</h1>
                </div>
            </div>

            <div class="table-responsive mt-4">
                <table class="table table-bordered table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>Imagen</th>
                            <th>Título</th>
                            <th>Descripción</th>
                            <th>Superficie</th>
                            <th>Habitaciones</th>
                            <th>Valoración</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="valoracionesTotales" var="valoracionTotal">
                            <tr>
                                <td>
                                    <img src="<s:property value='#valoracionTotal.idPropiedad.imagenUrl' />" alt="Imagen" class="img-thumbnail" data-bs-toggle="modal" data-bs-target="#imagenModal<s:property value='#valoracionTotal.idPropiedad.id' />" style="cursor:pointer;"/>

                                    <!-- Modal -->
                                    <div class="modal fade" id="imagenModal<s:property value='#valoracionTotal.idPropiedad.id' />" tabindex="-1" aria-labelledby="imagenModalLabel<s:property value='#valoracionTotal.idPropiedad.id' />" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="imagenModalLabel<s:property value='#valoracionTotal.idPropiedad.id' />">Imagen de la propiedad</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <img src="<s:property value='#valoracionTotal.idPropiedad.imagenUrl' />" alt="Imagen" class="img-fluid"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td><s:property value="#valoracionTotal.idPropiedad.titulo"></s:property></td>
                                <td><s:property value="#valoracionTotal.idPropiedad.descripcion"></s:property></td>
                                <td><s:property value="#valoracionTotal.idPropiedad.superficie"></s:property> m<sup>2</sup></td>
                                <td><s:property value="#valoracionTotal.idPropiedad.numeroHabitaciones"></s:property></td>
                                <td class="puntuacion-<s:property value='#valoracionTotal.id'/>">
                                    <s:property value="#valoracionTotal.valoracionTotal"></s:property>
                                    <div class="rating" id="rating-<s:property value='#valoracionTotal.id'/>">
                                        <i class="bi bi-star-fill star" id="<s:property value="'1' + #valoracionTotal.id"></s:property>" value="1"></i>
                                        <i class="bi bi-star-fill star" id="<s:property value="'2' + #valoracionTotal.id"></s:property>" value="2"></i>
                                        <i class="bi bi-star-fill star" id="<s:property value="'3' + #valoracionTotal.id"></s:property>" value="3"></i>
                                        <i class="bi bi-star-fill star" id="<s:property value="'4' + #valoracionTotal.id"></s:property>" value="4"></i>
                                        <i class="bi bi-star-fill star" id="<s:property value="'5' + #valoracionTotal.id"></s:property>" value="5"></i>
                                        </div>
                                    </td>
                                    <td>
                                    <s:form id="verPropiedad" name="verPropiedad" action="verPropiedad" method="POST">
                                        <s:hidden name="idPropiedad" value="%{#valoracionTotal.idPropiedad.id}"/>
                                        <s:submit name="boton" value="Ver propiedad" cssClass="btn btn-primary btn-sm"></s:submit>
                                    </s:form>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
        
        <%@include file="footer.jsp" %>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        <script type="text/javascript">
            function inicializarEstrellas() {
                var valoraciones = document.querySelectorAll('.rating');
                valoraciones.forEach(function (ratingElement) {
                    var id = ratingElement.id.split('-').pop();
                    var puntuacion = parseInt(document.querySelector("td.puntuacion-" + id).innerText.trim());
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
    </body>
</html>
