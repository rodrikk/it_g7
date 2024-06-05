<%@include file="header.jsp" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UPrOpiedades - Favoritos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQ7A2Vp04eCTqOwTxKNTdB1xKjPyUE5tbxUEtP8tptxj9zsvsUePF9CZ2" crossorigin="anonymous">
    <style>
        .card-img-top {
            max-height: 200px;
            object-fit: cover;
        }
    </style>
</head>
<body>
    <!-- Main Content -->
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-md-8 text-center">
                <h1 class="mb-4">Favoritos</h1>
            </div>
        </div>

        <div class="row">
            <s:if test="!favoritos.isEmpty()">
                <s:iterator value="favoritos" var="favorito">
                    <div class="col-md-6 col-lg-4 mb-4">
                        <div class="card">
                            <img src="<s:property value="#favorito.idPropiedad.foto"/>" class="card-img-top" alt="<s:property value="#favorito.idPropiedad.titulo"/>">
                            <div class="card-body">
                                <h5 class="card-title"><s:property value="#favorito.idPropiedad.titulo"/></h5>
                                <p class="card-text"><s:property value="#favorito.idPropiedad.descripcion"/></p>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Superficie: <s:property value="#favorito.idPropiedad.superficie"/> m²</li>
                                    <li class="list-group-item">Habitaciones: <s:property value="#favorito.idPropiedad.numeroHabitaciones"/></li>
                                </ul>
                            </div>
                            <div class="card-footer d-flex justify-content-between">
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
                        </div>
                    </div>
                </s:iterator>
            </s:if>
            <s:else>
                <div class="col-12">
                    <p class="text-center">No tienes propiedades en favoritos</p>
                </div>
            </s:else>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
