package com.emergentes.dao;

import com.emergentes.modelo.Productos;
import java.util.List;

public interface ProductosDAO {
    public void insert(Productos producto) throws Exception;
    public void update(Productos producto) throws Exception;
    public void delete(int id) throws Exception;
    public Productos getById(int id) throws Exception;
    public List<Productos> getAll() throws Exception;
}
