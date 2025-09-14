package org.example.tecnet.dao;

import org.example.tecnet.model.Evento;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    private Evento map(ResultSet rs) throws SQLException {
        Evento e = new Evento();
        e.setId(rs.getInt("id"));
        e.setTitulo(rs.getString("titulo"));
        e.setDescripcion(rs.getString("descripcion"));
        e.setCategoria(rs.getString("categoria"));
        e.setModalidad(rs.getString("modalidad"));
        e.setLugar(rs.getString("lugar"));
        e.setFechaInicio(rs.getTimestamp("fecha_inicio").toLocalDateTime());
        e.setFechaFin(rs.getTimestamp("fecha_fin").toLocalDateTime());
        e.setAforo(rs.getInt("aforo"));
        e.setEstado(rs.getString("estado"));
        return e;
    }

    public List<Evento> findAll() throws SQLException {
        String sql = "SELECT * FROM evento ORDER BY fecha_inicio DESC";
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Evento> list = new ArrayList<>();
            while (rs.next()) list.add(map(rs));
            return list;
        }
    }

    public Evento findById(int id) throws SQLException {
        String sql = "SELECT * FROM evento WHERE id=?";
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                return rs.next()? map(rs): null;
            }
        }
    }

    public void insert(Evento e) throws SQLException {
        String sql = "INSERT INTO evento(titulo,descripcion,categoria,modalidad,lugar,fecha_inicio,fecha_fin,aforo,estado) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getDescripcion());
            ps.setString(3, e.getCategoria());
            ps.setString(4, e.getModalidad());
            ps.setString(5, e.getLugar());
            ps.setTimestamp(6, Timestamp.valueOf(e.getFechaInicio()));
            ps.setTimestamp(7, Timestamp.valueOf(e.getFechaFin()));
            ps.setInt(8, e.getAforo());
            ps.setString(9, e.getEstado());
            ps.executeUpdate();
        }
    }

    public void update(Evento e) throws SQLException {
        String sql = "UPDATE evento SET titulo=?,descripcion=?,categoria=?,modalidad=?,lugar=?,fecha_inicio=?,fecha_fin=?,aforo=?,estado=? WHERE id=?";
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getDescripcion());
            ps.setString(3, e.getCategoria());
            ps.setString(4, e.getModalidad());
            ps.setString(5, e.getLugar());
            ps.setTimestamp(6, Timestamp.valueOf(e.getFechaInicio()));
            ps.setTimestamp(7, Timestamp.valueOf(e.getFechaFin()));
            ps.setInt(8, e.getAforo());
            ps.setString(9, e.getEstado());
            ps.setInt(10, e.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement("DELETE FROM evento WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}