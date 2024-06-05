<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Inmobiliaria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link href="index.css" rel="stylesheet">
    </head>
    <body>

        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                <div class="container-fluid">
                    <s:form action="verPropiedades" id="verPropiedades" method="POST" cssClass="d-flex">
                        <button type="submit" class="navbar-brand btn btn-link text-white p-0" style="text-decoration: none;">UPrOpiedades</button>
                    </s:form>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                        <ul class="navbar-nav">
                            <c:choose>
                                <c:when test="${empty sessionScope.usuario}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="login.jsp">Login</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="registrar_usuario.jsp">Registrarse</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="nav-item">
                                        <s:form action="verPropiedades" method="POST" cssClass="d-inline">
                                            <s:submit cssClass="nav-link btn btn-link" style="text-decoration: none;" value="Inicio"/>
                                        </s:form>
                                    </li>
                                    <li class="nav-item">
                                        <s:form action="verUsuario" method="POST" cssClass="d-inline">
                                            <s:hidden name="idUsuario" value="%{#session.idUsuario}"/>
                                            <s:submit cssClass="nav-link btn btn-link" style="text-decoration: none;" value="Perfil"/>
                                        </s:form>
                                    </li>
                                    <li class="nav-item">
                                        <s:form action="misPropiedades" method="POST" cssClass="d-inline">
                                            <s:hidden name="idUsuario" value="%{#session.idUsuario}"/>
                                            <s:submit cssClass="nav-link btn btn-link" style="text-decoration: none;" value="Mis propiedades"/>
                                        </s:form>
                                    </li>
                                    <li class="nav-item">
                                        <s:form action="verFavoritos" method="POST" cssClass="d-inline">
                                            <s:hidden name="idUsuario" value="%{#session.idUsuario}"/>
                                            <s:submit cssClass="nav-link btn btn-link" style="text-decoration: none;" value="Favoritos"/>
                                        </s:form>
                                    </li>
                                    <li class="nav-item">
                                        <s:form action="misAlquileres" method="POST" cssClass="d-inline">
                                            <s:hidden name="idUsuario" value="%{#session.idUsuario}"/>
                                            <s:submit cssClass="nav-link btn btn-link" style="text-decoration: none;" value="Mis alquileres"/>
                                        </s:form>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="listSeguros">Seguros</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="listVisitas">Visitas</a>
                                    </li>
                                    <li class="nav-item">
                                        <s:form action="logout" method="POST" cssClass="d-inline">
                                            <s:hidden name="idUsuario" value="%{#session.idUsuario}"/>
                                            <s:submit cssClass="nav-link btn btn-link" style="text-decoration: none;" value="Cerrar sesión"/>
                                        </s:form>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
