package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    static public String driver = "com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_almacen";
    static public String usuario = "root";
    static public String password = "";
    
    protected Connection conn = null;
    
    public ConexionBD()
    {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null){
                System.out.println("Conexion exitosa");   
            } 
        } catch (ClassNotFoundException e) {
                 System.out.println("Error de driver:" + e.getMessage());
        } catch (SQLException e) {
                 System.out.println("Error al conectar:" + e.getMessage());                
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar()
    {              
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la BD ");        }
        }  
}
