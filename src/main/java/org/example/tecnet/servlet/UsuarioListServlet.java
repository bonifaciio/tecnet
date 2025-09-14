package org.example.tecnet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tecnet.dao.UsuarioDAO;

import java.io.IOException;

@WebServlet("/usuario")
public class UsuarioListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("usuarios", new UsuarioDAO().findAll());
            req.getRequestDispatcher("/usuario/list.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}