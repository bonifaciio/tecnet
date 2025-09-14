package org.example.tecnet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tecnet.dao.EventoDAO;
import org.example.tecnet.model.Evento;

import java.io.IOException;

@WebServlet({"/evento/nuevo", "/evento/editar"})
public class EventoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if ("/evento/editar".equals(path)) {
            int id = Integer.parseInt(req.getParameter("id"));
            try { req.setAttribute("e", new EventoDAO().findById(id)); }
            catch (Exception e){ throw new ServletException(e); }
        }
        req.getRequestDispatcher("/evento/form.jsp").forward(req, resp);
    }
}