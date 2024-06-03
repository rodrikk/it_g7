<%@ include file="header.jsp" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Editar Perfil del Usuario</h5>
                <s:form action="editarUsuario" method="POST">
                    <div class="mb-3">
                        <s:textfield name="nombre" value="%{usuario.nombre}" label="Nombre" cssClass="form-control" />
                    </div>
                    <div class="mb-3">
                        <s:textfield name="apellidos" value="%{usuario.apellidos}" label="Apellidos" cssClass="form-control" />
                    </div>
                    <div class="mb-3">
                        <s:textfield name="email" value="%{usuario.email}" label="Email" cssClass="form-control" />
                    </div>
                    <div class="mb-3">
                        <s:textfield name="password" value="%{usuario.password}" label="Contraseña" cssClass="form-control" />
                    </div>
                    <div class="mb-3">
                        <s:textfield name="telefono" value="%{usuario.telefono}" label="Teléfono" cssClass="form-control" />
                    </div>
                    <div class="mb-3">
                        <s:textfield name="fechaNacimiento" value="%{usuario.fechaNacimiento}" label="Fecha de Nacimiento" cssClass="form-control" />
                    </div>
                    <s:hidden name="idUsuario" value="%{usuario.id}" />
                    <s:submit value="Actualizar" cssClass="btn btn-primary" />
                </s:form>
            </div>
        </div>
    </div>
</body>
</html>
