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
                        <s:form id="agregarPropiedad" name="agregarPropiedad" action="agregarPropiedad" method="POST">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <s:textfield id="titulo" name="titulo" label="Título"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="descripcion" name="descripcion" label="Descripción"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="superficie" name="superficie" label="Superficie (m2)"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="numeroHabitaciones" name="numeroHabitaciones" label="Número de habitaciones"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="calle" name="calle" label="Calle"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="numero" name="numero" label="Número"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="ciudad" name="ciudad" label="Ciudad"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="provincia" name="provincia" label="Provincia"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="pais" name="pais" label="País"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="codigoPostal" name="codigoPostal" label="Código Postal"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="precio" name="precio" label="Precio (€)"/>
                                </li>
                                <li class="list-group-item">
                                    <s:select id="idOperacion" name="idOperacion" list="operaciones" listKey="id" listValue="operacion" label="Operación"/>
                                </li>
                            </ul>
                            <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                            <s:submit name="boton" value="Añadir"></s:submit>
                        </s:form>
                    </div>
                </div>
            </div>     
        </section>
    </body>
</html>
