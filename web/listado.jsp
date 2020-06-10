<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>LISTA DE PRODUCTOS</h1> 
        <p><a href="Inicio?action=add">NUEVO PRODUCTO</a></p>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>DESCRIPCION</th>
                <th>STOCK</th>
                <th></th>
                <th></th>
            </tr>  
            <c:forEach var="item" items="${productos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.stock}</td>
                    <td><a href="Inicio?action=edit&id=${item.id}">EDITAR</a></td>
                    <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('ESTA SEGURO DE ELIMINAR ???'))">ELIMINAR</a></td>
                </tr>
            </c:forEach>
        </table>
        </center>
    </body>
</html>
