package com.emergentes.dao;

import com.emergentes.modelo.Productos;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAOimpl extends ConexionBD implements ProductosDAO{

    @Override
    public void insert(Productos producto) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT into productos (descripcion,stock) values (?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getStock());
            //ejecutar la consulta
            ps.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.desconectar();
        }  
    }

    @Override
    public void update(Productos producto) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos set descripcion=?, stock=? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getStock());
            ps.setInt(3, producto.getId());
            //ejecutar la consulta
            ps.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.desconectar();
        }  
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE from productos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            //ejecutar la consulta
            ps.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Productos getById(int id) throws Exception {
        Productos avi = new Productos();
        try {
            this.conectar();
            
            String sql = "select * from productos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                avi.setId(rs.getInt("id"));
                avi.setDescripcion(rs.getString("descripcion"));
                avi.setStock(rs.getInt("stock"));
            }
            
        }catch (Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
        return avi;
    }

    @Override
    public List<Productos> getAll() throws Exception {
          
        List<Productos> lista = null;
        try{
            this.conectar();
            String sql = "select * from productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Productos>();
            while(rs.next()){
                Productos avi = new Productos();
                avi.setId(rs.getInt("id"));
                avi.setDescripcion(rs.getString("descripcion"));
                avi.setStock(rs.getInt("stock"));
                //adicionar ala coleccion
                lista.add(avi);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        } finally{
            this.desconectar();
        }
        return lista;
    }
    
}
