package org.example.tecnet.dao;

import org.example.tecnet.model.Evento;
import org.example.tecnet.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAO {

    // Eventos donde está inscrito un alumno
    public List<Evento> eventosPorUsuario(int usuarioId) throws SQLException {
        String sql = """
            SELECT e.* FROM inscripcion i
            JOIN evento e ON e.id = i.evento_id
            WHERE i.usuario_id = ?
            ORDER BY e.fecha_inicio DESC
        """;
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                List<Evento> list = new ArrayList<>();
                EventoDAO mapper = new EventoDAO();
                while (rs.next()) list.add(mapper.findById(rs.getInt("id"))); // o mapear directo
                return list;
            }
        }
    }

    // Alumnos inscritos en un evento
    public List<Usuario> usuariosPorEvento(int eventoId) throws SQLException {
        String sql = """
            SELECT u.* FROM inscripcion i
            JOIN usuario u ON u.id = i.usuario_id
            WHERE i.evento_id = ?
            ORDER BY u.apellidos, u.nombres
        """;
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, eventoId);
            try (ResultSet rs = ps.executeQuery()) {
                List<Usuario> list = new ArrayList<>();
                while (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setEmail(rs.getString("email"));
                    u.setNombres(rs.getString("nombres"));
                    u.setApellidos(rs.getString("apellidos"));
                    u.setCarrera(rs.getString("carrera"));
                    u.setRol(rs.getString("rol"));
                    u.setEstado(rs.getString("estado"));
                    list.add(u);
                }
                return list;
            }
        }
    }
}