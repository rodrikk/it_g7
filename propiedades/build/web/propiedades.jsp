<%-- 
    Document   : index
    Created on : 31-may-2024, 16:33:49
    Author     : migue
--%>

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
                    <h1>Bienvenidos a UPrOpiedades</h1>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        <table border="1">
            <thead>
                <tr>
                    <th>Imagen</th>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th>Superficie</th>
                    <th>Habitaciones</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="valoracionesTotales" var="valoracionTotal">
                    <tr>
                        <td><!-- Poner lo necesario para que se vea la imagen --></td>
                        <td><s:property value="#valoracionTotal.idPropiedad.titulo"></s:property></td>
                        <td><s:property value="#valoracionTotal.idPropiedad.descripcion"></s:property></td>
                        <td><s:property value="#valoracionTotal.idPropiedad.superficie"></s:property> m2</td>
                        <td><s:property value="#valoracionTotal.idPropiedad.numeroHabitaciones"></s:property></td>
                        <td class="puntuacion-<s:property value='#valoracionTotal.id'/>"><s:property value="#valoracionTotal.valoracionTotal"></s:property></td>
                            <td>
                                <label for="rating">Valoración:</label>
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
                                <s:hidden name="idPropiedad" value="%{#valoracionTotal.idPropiedad.id}"></s:hidden>
                                <s:submit name="boton" value="Ver propiedad"></s:submit>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>

        <script type="text/javascript">
            function inicializarEstrellas() {
                var valoraciones = document.querySelectorAll('.rating');
                valoraciones.forEach(function (ratingElement) {
                    var id = ratingElement.id.split('-').pop();
                    var puntuacion = parseFloat(document.querySelector("td.puntuacion-" + id).innerText.trim());
                    var estrellas = ratingElement.querySelectorAll('.bi.star');
                    var puntuacionEntera = Math.floor(puntuacion);
                    var fraccion = puntuacion - puntuacionEntera;

                    for (var i = 0; i < estrellas.length; i++) {
                        if (i < puntuacionEntera) {
                            estrellas[i].classList.add('checked');
                        } else if (i == puntuacionEntera && fraccion > 0) {
                            estrellas[i].style.background = "linear-gradient(90deg, gold " + (fraccion * 100) + "%, #ddd " + (fraccion * 100) + "%)";
                        }
                    }
                });
            }

            document.addEventListener('DOMContentLoaded', inicializarEstrellas);
        </script>

    </body>
</html>
