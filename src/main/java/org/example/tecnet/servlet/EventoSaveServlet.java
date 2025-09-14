package org.example.tecnet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tecnet.dao.EventoDAO;
import org.example.tecnet.model.Evento;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet({"/evento/guardar","/evento/actualizar","/evento/eliminar"})
public class EventoSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        try {
            EventoDAO dao = new EventoDAO();
            if ("/evento/eliminar".equals(path)) {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.delete(id);
            } else {
                Evento e = new Evento();
                e.setTitulo(req.getParameter("titulo"));
                e.setDescripcion(req.getParameter("descripcion"));
                e.setCategoria(req.getParameter("categoria"));
                e.setModalidad(req.getParameter("modalidad"));
                e.setLugar(req.getParameter("lugar"));
                e.setFechaInicio(LocalDateTime.parse(req.getParameter("fechaInicio")));
                e.setFechaFin(LocalDateTime.parse(req.getParameter("fechaFin")));
                e.setAforo(Integer.parseInt(req.getParameter("aforo")));
                e.setEstado(req.getParameter("estado"));
                if ("/evento/guardar".equals(path)) {
                    dao.insert(e);
                } else if ("/evento/actualizar".equals(path)) {
                    e.setId(Integer.parseInt(req.getParameter("id")));
                    dao.update(e);
                }
            }
            resp.sendRedirect(req.getContextPath() + "/evento");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}