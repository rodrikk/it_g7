<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Inicio de Sesión</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <style>
            .login-container {
                max-width: 400px;
                margin: 50px auto;
                padding: 20px;
                border: 1px solid #ddd;
                border-radius: 8px;
                background-color: #f9f9f9;
            }
            .login-container h2 {
                margin-bottom: 20px;
            }
            .login-container .form-label {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <s:if test="%{!error.isEmpty}">
                <div class="alert alert-danger" role="alert">
                    Mensaje de error: <s:property value="error"/>
                </div>
            </s:if>
            <div class="login-container shadow p-4">
                <h2 class="text-center">Inicio de Sesión</h2>
                <s:form id="login" name="login" action="login" method="POST">
                    <div class="mb-3">
                        <s:textfield id="email" name="email" cssClass="form-control" label="Email" />
                    </div>
                    <div class="mb-3">
                        <s:password id="password" name="password" cssClass="form-control" label="Contraseña" />
                    </div>
                    <div class="d-grid">
                        <s:submit cssClass="btn btn-primary" value="Iniciar sesión" />
                    </div>
                </s:form>
                <div class="d-grid">
                    <a href="registro.jsp" class="btn btn-outline-secondary">¿No tienes cuenta?</a>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
