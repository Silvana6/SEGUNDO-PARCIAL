package com.emergentes.dao;

import com.emergentes.modelo.estudiante;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class estudianteDAOimpl extends ConexionDB implements estudianteDAO {

    @Override
    public void insert(estudiante estudiante) throws Exception {
      String sql = "insert into estudiantes (nombres,apellidos,seminarios,confirmado,fecha_ins)values(?,?,?,?,?)";
      this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombres());
        ps.setString(2, estudiante.getApellidos());
        ps.setString(3, estudiante.getSeminarios());
        ps.setString(4, estudiante.getConfirmado());
        ps.setString(5, estudiante.getFecha_ins());
        ps.executeUpdate();
    }

    @Override
    public void update(estudiante estudiante) throws Exception {
           String sql = "update estudiantes set nombres=?,apellidos=?,seminarios=?,confirmado=?,fecha_ins=? where id=?";
      this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombres());
        ps.setString(2, estudiante.getApellidos());
        ps.setString(3, estudiante.getSeminarios());
        ps.setString(4, estudiante.getConfirmado());
        ps.setString(5, estudiante.getFecha_ins());
        ps.setInt(6, estudiante.getId());
        ps.executeUpdate();
    
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from estudiantes where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    
    @Override
    public List<estudiante> getAll() throws Exception {
       List<estudiante> lista=null;
        String sql= "select * from estudiantes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista =new ArrayList<estudiante>();
        while(rs.next()){
            estudiante est =new estudiante();
            est.setId(rs.getInt("id"));
            est.setNombres(rs.getString("nombres"));
            est.setApellidos(rs.getString("apellidos"));
            est.setSeminarios(rs.getString("seminarios"));
            est.setConfirmado(rs.getString("confirmado"));
            est.setFecha_ins(rs.getString("fecha_ins"));
            lista.add(est);
        }
        return lista;
    }
    
    @Override
    public estudiante getById(int id) throws Exception {
        estudiante est =new estudiante();
        try{
        String sql= "select * from estudiantes where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            est.setId(rs.getInt("id"));
            est.setNombres(rs.getString("nombres"));
            est.setApellidos(rs.getString("apellidos"));
            est.setSeminarios(rs.getString("seminarios"));
            est.setConfirmado(rs.getString("confirmado"));
            est.setFecha_ins(rs.getString("fecha_ins"));
        }}catch(SQLException e){
                throw e;
                }finally{
                        this.desconectar();
                        }
        return est;
    }
    
}
