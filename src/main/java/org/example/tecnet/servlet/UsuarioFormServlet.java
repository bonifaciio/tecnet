package org.example.tecnet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tecnet.dao.UsuarioDAO;
import org.example.tecnet.model.Usuario;

import java.io.IOException;

@WebServlet({"/usuario/nuevo", "/usuario/editar"})
public class UsuarioFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if ("/usuario/editar".equals(path)) {
            int id = Integer.parseInt(req.getParameter("id"));
            try { req.setAttribute("u", new UsuarioDAO().findById(id)); }
            catch (Exception e){ throw new ServletException(e); }
        }
        req.getRequestDispatcher("/usuario/form.jsp").forward(req, resp);
    }
}