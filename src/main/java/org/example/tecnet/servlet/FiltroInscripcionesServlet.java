package org.example.tecnet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tecnet.dao.EventoDAO;
import org.example.tecnet.dao.InscripcionDAO;
import org.example.tecnet.dao.UsuarioDAO;

import java.io.IOException;

@WebServlet("/inscripciones")
public class FiltroInscripcionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String modo = req.getParameter("modo"); // "alumno" o "evento"
        String idStr = req.getParameter("id");  // id de alumno o id de evento
        try {
            req.setAttribute("usuarios", new UsuarioDAO().findAll());
            req.setAttribute("events", new EventoDAO().findAll());

            if (modo != null && idStr != null && !idStr.isBlank()) {
                int id = Integer.parseInt(idStr);
                var inscDao = new InscripcionDAO();
                if ("alumno".equalsIgnoreCase(modo)) {
                    req.setAttribute("modo", "alumno");
                    req.setAttribute("listaEventos", inscDao.eventosPorUsuario(id));
                } else if ("evento".equalsIgnoreCase(modo)) {
                    req.setAttribute("modo", "evento");
                    req.setAttribute("listaUsuarios", inscDao.usuariosPorEvento(id));
                }
                req.setAttribute("seleccionId", id);
            }
            req.getRequestDispatcher("/inscripcion/filtro.jsp").forward(req, resp);
        } catch (Exception e){
            throw new ServletException(e);
        }
    }
}