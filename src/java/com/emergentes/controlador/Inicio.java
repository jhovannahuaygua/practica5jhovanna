package com.emergentes.controlador;

import com.emergentes.dao.ProductosDAO;
import com.emergentes.dao.ProductosDAOimpl;
import com.emergentes.modelo.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductosDAO dao = new ProductosDAOimpl();
            //para recibir el id
            int id;
            // para gestionar los registros
            Productos pro = new Productos();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    //nuevo registro
                    request.setAttribute("prod", pro);
                    request.getRequestDispatcher("frmproductos.jsp").forward(request, response);
                    break;
                case "edit":
                    //para editar un registro
                    id = Integer.parseInt(request.getParameter("id"));
                    pro = dao.getById(id);
                    request.setAttribute("prod", pro);
                    request.getRequestDispatcher("frmproductos.jsp").forward(request, response);
                    break;
                case "delete":
                    //para eliminar un registro
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    request.getRequestDispatcher("Inicio").forward(request, response); 
                    break;
                default:
                    //listar los registros
                    List<Productos> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("listado.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    
    }

       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        ProductosDAO dao = new ProductosDAOimpl();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        int stock = Integer.parseInt(request.getParameter("stock"));
               
        Productos pro = new Productos();
        
        pro.setId(id);
        pro.setDescripcion(descripcion);
        pro.setStock(stock);
        
        if (id == 0){
            try {
                dao.insert(pro);
                response.sendRedirect("Inicio");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
        else {
            try {
                dao.update(pro);
                response.sendRedirect("Inicio");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());

            }            
        }
    
    }

}
