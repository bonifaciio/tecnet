package org.example.tecnet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tecnet.dao.UsuarioDAO;
import org.example.tecnet.model.Usuario;

import java.io.IOException;

@WebServlet({"/usuario/guardar","/usuario/actualizar","/usuario/eliminar"})
public class UsuarioSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            if ("/usuario/eliminar".equals(path)) {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.delete(id);
            } else {
                Usuario u = new Usuario();
                u.setUsername(req.getParameter("username"));
                u.setEmail(req.getParameter("email"));
                u.setNombres(req.getParameter("nombres"));
                u.setApellidos(req.getParameter("apellidos"));
                u.setCarrera(req.getParameter("carrera"));
                u.setRol(req.getParameter("rol"));
                u.setEstado(req.getParameter("estado"));
                if ("/usuario/guardar".equals(path)) {
                    dao.insert(u);
                } else if ("/usuario/actualizar".equals(path)) {
                    u.setId(Integer.parseInt(req.getParameter("id")));
                    dao.update(u);
                }
            }
            resp.sendRedirect(req.getContextPath() + "/usuario");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}