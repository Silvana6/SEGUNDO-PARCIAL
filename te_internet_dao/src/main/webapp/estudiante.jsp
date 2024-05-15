<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.estudiante"%>
<%@page import="java.util.List"%>
<%
       List<estudiante> estudiante = (List<estudiante>)request.getAttribute("estudiante");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Estudiantes</title>
</head>
<style>
            .panel {
            text-align: center; 
            border: 3px solid burlywood; 
            border-radius: 5px;
            padding: 10px;
        }
       table {
            margin: 0 auto; 
            text-align: center; 
            border-collapse: collapse; 
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
        }
        th {
            background-color: #f8f9fa;
            font-weight: bold;
        }
        h1{
            text-align: center; 
        }
        a {
            text-decoration: none;
        }
        a:hover {
            color: blueviolet;
            text-decoration: underline;
        }
        
</style>
<body>
    <div class="panel">
        <p>SEGUNDO PARCIAL TEMP-742 </p>
        <p>Nombre: SILVANA CALLEJAS MENESES </p>                  
        <p>Cedula: 9184752</p>
        </div>
    <h1>REGISTRO DIA MUNDIAL DEL INTERNET</h1>
    <a  class="ha" href="estudianteController?action=add" >NUEVO REGISTRO</a>
    <br>
    <p></p>
    <table border="1" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>NOMBRES</th>
            <th>APELLIDOS</th>
            <th>SEMINARIOS</th>
            <th>CONFIRMADO</th>
            <th>FECHA INSCRIPCION</th>
            <th></th>
        </tr>
        <c:forEach  var="est" items="${estudiante}">
            <tr>
                <td>${est.id}</td>
                <td>${est.nombres}</td>
                <td>${est.apellidos}</td>
                <td>${est.seminarios}</td>
                <td><c:choose>
                <c:when test="${est.confirmado eq 'si'}">
                    <input type="checkbox" checked="checked" disabled="disabled">
                </c:when>
                <c:otherwise>
                    <input type="checkbox" disabled="disabled">
                </c:otherwise>
            </c:choose></td>
                <td>${est.fecha_ins}</td>
                <td>
                    <a href="estudianteController?action=edit&id=${est.id}">EDITAR</a> |
                    <a href="estudianteController?action=delete&id=${est.id}">ELIMINAR</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
</body>
</html>
