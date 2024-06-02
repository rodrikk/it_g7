<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Seguros</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="container my-5">
        <h1 class="text-center mb-4">Seguros de UPrOpiedades</h1>
        
        <!-- Seguros de Alquiler -->
        <div class="mb-5">
            <h2>Seguros de Alquiler</h2>
            <div class="card-deck">
                <div class="card">
                    <div class="card-header bg-primary text-white">Seguro Básico</div>
                    <div class="card-body">
                        <h5 class="card-title">Tarifa: 50€/mes</h5>
                        <ul class="list-unstyled">
                            <li><strong>Cobertura:</strong></li>
                            <li> Daños a la propiedad</li>
                            <li> Robo</li>
                            <li> Responsabilidad civil</li>
                        </ul>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header bg-success text-white">Seguro Completo</div>
                    <div class="card-body">
                        <h5 class="card-title">Tarifa: 80€/mes</h5>
                        <ul class="list-unstyled">
                            <li><strong>Cobertura:</strong></li>
                            <li> Daños a la propiedad</li>
                            <li> Robo</li>
                            <li> Responsabilidad civil</li>
                            <li> Daños por agua</li>
                            <li> Pérdida de alquiler</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- Seguros de Compra -->
        <div class="mb-5">
            <h2>Seguros de Compra</h2>
            <div class="card-deck">
                <div class="card">
                    <div class="card-header bg-primary text-white">Seguro Básico</div>
                    <div class="card-body">
                        <h5 class="card-title">Tarifa: 100€/mes</h5>
                        <ul class="list-unstyled">
                            <li><strong>Cobertura:</strong></li>
                            <li> Daños a la propiedad</li>
                            <li> Robo</li>
                            <li> Responsabilidad civil</li>
                            <li> Daños estructurales</li>
                        </ul>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header bg-success text-white">Seguro Completo</div>
                    <div class="card-body">
                        <h5 class="card-title">Tarifa: 150€/mes</h5>
                        <ul class="list-unstyled">
                            <li><strong>Cobertura:</strong></li>
                            <li> Daños a la propiedad</li>
                            <li> Robo</li>
                            <li> Responsabilidad civil</li>
                            <li> Daños estructurales</li>
                            <li> Daños por agua</li>
                            <li> Desastres naturales</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
