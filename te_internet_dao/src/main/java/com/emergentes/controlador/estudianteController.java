package com.emergentes.controlador;

import com.emergentes.dao.estudianteDAO;
import com.emergentes.dao.estudianteDAOimpl;
import com.emergentes.modelo.estudiante;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/estudianteController"})
public class estudianteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            estudianteDAO dao = (estudianteDAO) new estudianteDAOimpl();
            estudiante est = new estudiante();
            int id;
            
            String action =(request.getParameter("action")!=null)? request.getParameter("action"):"view";
            switch (action){
                case "add" :
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    try {
                        est = dao.getById(id);
                        request.setAttribute("estudiante", est);
                        request.getRequestDispatcher("frmestudiante.jsp").forward(request, response); 
                    } catch (Exception ex) {
                        System.out.println("Error al obtener el registro: " + ex.getMessage());
                    }
                    break;
                case "delete" :
                    id = Integer.parseInt(request.getParameter("id"));
                    try{
                        dao.delete(id);
                    } catch (Exception ex) {
                        Logger.getLogger(estudianteController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    response.sendRedirect("estudianteController");
                    break;
                    
                case "view" :
                    List<estudiante> lista= dao.getAll();
                    request.setAttribute(("estudiante"), lista);
                    request.getRequestDispatcher("estudiante.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(estudianteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres= request.getParameter("nombres");
        String apellidos= request.getParameter("apellidos");
        String seminarios= request.getParameter("seminarios");
        String confirmado= request.getParameter("confirmado");
        String fecha_ins=request.getParameter("fecha_ins");
        estudiante est = new estudiante();
        
        est.setId(id);
        est.setNombres(nombres);
        est.setApellidos(apellidos);
        est.setSeminarios(seminarios);
        est.setConfirmado(confirmado);
        est.setFecha_ins(fecha_ins);
        estudianteDAO dao=new estudianteDAOimpl();
            
        if (id==0){
            try{
                dao.insert(est);
            } catch (Exception ex) {
            Logger.getLogger(estudianteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try{
                dao.update(est);
            } catch (Exception ex) {
            Logger.getLogger(estudianteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("estudianteController?action=view");
    }
}
