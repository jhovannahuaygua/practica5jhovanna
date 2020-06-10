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
        <h1>
            <c:if test="${prod.id == 0}">NUEVO</c:if>
            <c:if test="${prod.id != 0}">EDITAR</c:if>
            PRODUCTO
        </h1>
            <form action="Inicio" method="POST">
                <input type="hidden" name="id" value="${prod.id}" />
                <label>DESCRIPCION</label>
                <textarea name="descripcion">${prod.descripcion}</textarea>
                <br>
                <label>STOCK</label>
                <input type="text" name="stock" value="${prod.stock}" />
                <br>
                    <input type="submit" value="AGREGAR" />
            </form>
        </center>
    </body>
</html>
