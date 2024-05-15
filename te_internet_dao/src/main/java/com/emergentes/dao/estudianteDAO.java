package com.emergentes.dao;

import com.emergentes.modelo.estudiante;
import java.util.List;

public interface estudianteDAO {
    public void insert(estudiante estudiante) throws Exception;
    public void update(estudiante estudiante) throws Exception;
    public void delete(int id) throws Exception;
    public estudiante getById(int id)throws Exception;
    public List<estudiante> getAll() throws Exception;
}

