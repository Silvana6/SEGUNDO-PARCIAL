<%@page import="com.emergentes.modelo.estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%
        estudiante est = (estudiante) request.getAttribute("estudiante");
    %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>NUEVO REGISTRO</h1>
    <form action="estudianteController" method="post">
        <input type="hidden" name="id" value="<%= est != null ? est.getId() : "" %>">
        <table>
            <tr>
                <td>NOMBRES: </td>
                <td><input type="text" name="nombres" value="<%= est != null ? est.getNombres() : "" %>"/></td>
            </tr>
            <tr>
                <td>APELLIDOS: </td>
                <td><input type="text" name="apellidos" value="<%= est != null ? est.getApellidos() : "" %>"/></td>
            </tr>
            <tr>
                <td>SEMINARIOS: </td>
                <td><input type="text" name="seminarios" value="<%= est != null ? est.getSeminarios() : "" %>"/></td>
            </tr>
            <tr>
                <td>CONFRIMADO: </td>
                <td>
                    <input type="checkbox" name="confirmado" value="si" ${est.confirmado == 'si' ? 'checked' : ''}/> Si<br>
                        <input type="checkbox" name="confirmado" value="no" ${est.confirmado == 'no' ? 'checked' : ''}/> No
                </td>
            </tr>
            <tr>
                <td>FECHA INSCRIPCION: </td>
                <td><input type="date" name="fecha_ins" value="<%= est != null ? est.getFecha_ins(): "" %>"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="ENVIAR"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
