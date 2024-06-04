<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Registro de Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <style>
            .register-container {
                max-width: 600px;
                margin: 50px auto;
                padding: 20px;
                border: 1px solid #ddd;
                border-radius: 8px;
                background-color: #f9f9f9;
            }
            .register-container h2 {
                margin-bottom: 20px;
            }
            .register-container .form-label {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="register-container shadow p-4">
                <h2 class="text-center">Registro de Usuario</h2>
                <s:form id="nuevoUsuario" name="nuevoUsuario" action="nuevoUsuario" method="POST">
                    <div class="mb-3">
                        <s:textfield id="nombre" name="nombre" cssClass="form-control" label="Nombre"/>
                    </div>
                    <div class="mb-3">
                        <s:textfield id="apellidos" name="apellidos" cssClass="form-control" label="Apellidos"/>
                    </div>
                    <div class="mb-3">
                        <s:textfield id="email" name="email" cssClass="form-control" label="Email"/>
                    </div>
                    <div class="mb-3">
                        <s:password id="password" name="password" cssClass="form-control" label="Contraseña"/>
                    </div>
                    <div class="mb-3">
                        <s:textfield id="telefono" name="telefono" cssClass="form-control" label="Teléfono"/>
                    </div>
                    <div class="mb-3">
                        <label for="fecha">Fecha de nacimiento:</label>
                        <input type="date" id="fechaNacimiento" name="fechaNacimiento" required><br/>
                    </div>
                    <div class="d-grid">
                        <s:submit cssClass="btn btn-primary" value="Registrarse"/>
                    </div>
                </s:form>
                <div class="d-grid mt-3">
                    <a href="login.jsp" class="btn btn-outline-secondary">¿Ya tienes cuenta? Iniciar sesión</a>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>