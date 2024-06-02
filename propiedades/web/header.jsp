<%-- 
    Document   : index
    Created on : 31-may-2024, 16:33:49
    Author     : migue
--%>

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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link href="index.css" rel="stylesheet">
    </head>
    <body>

        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                <div class="container-fluid d-flex justify-content-between">
                    <a class="navbar-brand" href="#">UPrOpiedades</a>
                    <div class="d-flex">
                        <button class="navbar-toggler shadow-none" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-center mt-3" id="navbarNav">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Propiedades</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Propietarios</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Seguros</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Valoraciones</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <c:choose>
                        <c:when test="${empty sessionScope.usuario}">
                            <div class="d-flex">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="login.jsp">Login</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Registrarse</a>
                                    </li>
                                </ul>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="d-flex">
                                <ul class="navbar-nav">
                                    <li class="nav-item">                                      
                                        <s:form action="verUsuario" id="verUsuario" method="POST">
                                            <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                                            <s:submit class="nav-link btn btn-link" style="padding: 0; border: none; background: none; cursor: pointer;" value="%{#session.usuario}">                                                
                                            </s:submit>
                                        </s:form>
                                        <s:form action="misPropiedades" id="misPropiedades" method="POST">
                                            <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                                            <s:submit class="nav-link btn btn-link" style="padding: 0; border: none; background: none; cursor: pointer;" value="Mis propiedades"></s:submit>
                                        </s:form>
                                        <s:form action="verFavoritos" id="verFavoritos" method="POST">
                                            <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                                            <s:submit class="nav-link btn btn-link" style="padding: 0; border: none; background: none; cursor: pointer;" value="Favoritos"></s:submit>
                                        </s:form>
                                        <s:form action="logout" id="logout" method="POST">
                                            <s:hidden name="idUsuario" value="%{#session.idUsuario}" />
                                            <s:submit class="nav-link btn btn-link" style="padding: 0; border: none; background: none; cursor: pointer;" value="Cerrar sesión"></s:submit>
                                        </s:form>
                                    </li>
                                </ul>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </div>
            </nav>
        </header>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
