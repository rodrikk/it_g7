<%-- 
    Document   : index
    Created on : 31-may-2024, 16:33:49
    Author     : migue
--%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Inmobiliaria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
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
                                <a class="nav-link" href="#">Inquilinos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Seguros</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Operaciones</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Valoraciones</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Favoritos</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="d-flex">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Main Content -->
        <div class="container mt-4">
            <div class="row justify-content-center">
                <div class="col-md-8 text-center">
                    <h1>Bienvenidos a la Inmobiliaria</h1>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        <table border="1">
            <thead>
                <tr>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="usuarios" var="usuario">
                <tr>
                    <td><s:property value="#usuario.id"></s:property></td>
                    <td><s:property value="#usuario.nombre"></s:property></td>
                    <td><s:property value="#usuario.idRol.rol"></s:property></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</body>
</html>
