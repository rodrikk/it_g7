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
                        <s:form id="editarPropiedad" name="editarPropiedad" action="editarPropiedad" method="POST">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <s:textfield id="titulo" name="titulo" value="%{propiedad.titulo}" label="Título"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="descripcion" name="descripcion" value="%{propiedad.descripcion}" label="Descripción"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="superficie" name="superficie" value="%{propiedad.superficie}" label="Superficie (m2)"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="numeroHabitaciones" name="numeroHabitaciones" value="%{propiedad.numeroHabitaciones}" label="Número de habitaciones"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="calle" name="calle" value="%{propiedad.idDireccion.calle}" label="Calle"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="numero" name="numero" value="%{propiedad.idDireccion.numero}" label="Número"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="ciudad" name="ciudad" value="%{propiedad.idDireccion.ciudad}" label="Ciudad"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="provincia" name="provincia" value="%{propiedad.idDireccion.provincia}" label="Provincia"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="pais" name="pais" value="%{propiedad.idDireccion.pais}" label="País"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="codigoPostal" name="codigoPostal" value="%{propiedad.idDireccion.codigoPostal}" label="Código Postal"/>
                                </li>
                                <li class="list-group-item">
                                    <s:textfield id="precio" name="precio" value="%{propiedad.precio}" label="Precio (€)"/>
                                </li>
                                <li class="list-group-item">
                                    <s:select id="idOperacion" name="idOperacion" list="operaciones" listKey="id" listValue="operacion" label="Operación"/>
                                </li>
                            </ul>
                            <s:hidden name="idPropiedad" value="%{propiedad.id}" />
                            <s:hidden name="idDireccion" value="%{propiedad.idDireccion.id}" />
                            <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                            <s:submit name="boton" value="Editar"></s:submit>
                        </s:form>
                    </div>
                </div>
            </div>     
        </section>
    </body>
</html>
