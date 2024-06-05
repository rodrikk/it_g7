<%@include file="header.jsp" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UPrOpiedades</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQ7A2Vp04eCTqOwTxKNTdB1xKjPyUE5tbxUEtP8tptxj9zsvsUePF9CZ2" crossorigin="anonymous">
</head>
<body>
    <!-- Main Content -->
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-md-8 text-center">
                <h1 class="mb-4">Favoritos</h1>
            </div>
        </div>

        <div class="table-responsive">
            <s:if test="!favoritos.isEmpty()">
                <table class="table table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>Imagen</th>
                        <th>Título</th>
                        <th>Descripción</th>
                        <th>Superficie</th>
                        <th>Habitaciones</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="favoritos" var="favorito">
                        <tr>
                            <td><img src="<s:property value="#favorito.idPropiedad.foto"></s:property>"/></td>
                            <td><s:property value="#favorito.idPropiedad.titulo"/></td>
                            <td><s:property value="#favorito.idPropiedad.descripcion"/></td>
                            <td><s:property value="#favorito.idPropiedad.superficie"/> m²</td>
                            <td><s:property value="#favorito.idPropiedad.numeroHabitaciones"/></td>
                            <td>
                                <div class="d-flex justify-content-around">
                                    <s:form id="verPropiedad" name="verPropiedad" action="verPropiedad" method="POST">
                                        <s:hidden name="idPropiedad" value="%{#favorito.idPropiedad.id}"/>
                                        <s:hidden name="idValorador" value="%{#session.idUsuario}"/>
                                        <s:submit name="boton" value="Ver propiedad" cssClass="btn btn-primary"/>
                                    </s:form>
                                    <s:form id="borrarFavoritos" name="borrarFavoritos" action="borrarFavoritos" method="POST">
                                        <s:hidden name="idFavorito" value="%{#favorito.id}"/>
                                        <s:hidden name="idUsuario" value="%{#session.idUsuario}"/>
                                        <s:submit name="boton" value="Borrar" cssClass="btn btn-danger"/>
                                    </s:form>
                                </div>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            </s:if>
            <s:else>
                <p>No tienes propiedades en favoritos</p>
            </s:else>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
