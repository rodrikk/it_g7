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
        <table border="1">
            <thead>
                <tr>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="valoraciones" var="valoracion">
                    <tr>
                        <td><s:property value="#valoracion.idPropiedad.id"></s:property></td>
                        <td class="puntuacion-<s:property value='#valoracion.id'/>"><s:property value="#valoracion.puntuacion"></s:property></td>
                            <td>
                            <s:form id="valorarPropiedad" name="valorarPropiedad" action="valorarPropiedad" method="POST">
                                <label for="rating">Valoración:</label>
                                <!-- <select id="rating" name="rating">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select> -->
                                <div class="rating" id="rating-<s:property value='#valoracionTotal.id'/>">
                                    <i class="bi bi-star-fill star" id="<s:property value="'1' + #valoracionTotal.id"/>"></i>
                                    <i class="bi bi-star-fill star" id="<s:property value="'2' + #valoracionTotal.id"/>"></i>
                                    <i class="bi bi-star-fill star" id="<s:property value="'3' + #valoracionTotal.id"/>"></i>
                                    <i class="bi bi-star-fill star" id="<s:property value="'4' + #valoracionTotal.id"/>"></i>
                                    <i class="bi bi-star-fill star" id="<s:property value="'5' + #valoracionTotal.id"/>"></i>
                                </div>
                                <s:hidden name="idValoracion" value="%{#valoracion.id}"></s:hidden>
                                <s:submit name="boton" value="Valorar"></s:submit>
                            </s:form>
                        </td>
                        <td>
                            <!-- <div class="rating">
                                <i class="bi bi-star-fill star" onclick="calificar(this)" id="<s:property value="'1' + #valoracion.id"></s:property>"></i>
                                <i class="bi bi-star-fill star" onclick="calificar(this)" id="<s:property value="'2' + #valoracion.id"></s:property>"></i>
                                <i class="bi bi-star-fill star" onclick="calificar(this)" id="<s:property value="'3' + #valoracion.id"></s:property>"></i>
                                <i class="bi bi-star-fill star" onclick="calificar(this)" id="<s:property value="'4' + #valoracion.id"></s:property>"></i>
                                <i class="bi bi-star-fill star" onclick="calificar(this)" id="<s:property value="'5' + #valoracion.id"></s:property>"></i>
                                <i id="liveAlertPlaceholder-gta5"></i>
                                <button type="button" class="btn color-ps4-xbox" onclick="valorar(this)"
                                        id="liveAlertBtn-gta5">Valorar</button>
                            </div> -->
                            </td>
                        </tr>
                </s:iterator>
            </tbody>
        </table>
        <p>Valoración total: <s:property value="valoracionTotal"/></p>

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
