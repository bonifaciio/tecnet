package org.example.tecnet.dao;

import org.example.tecnet.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> findAll() throws SQLException {
        String sql = "SELECT * FROM usuario ORDER BY id DESC";
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Usuario> list = new ArrayList<>();
            while (rs.next()) {
                Usuario u = map(rs);
                list.add(u);
            }
            return list;
        }
    }

    public Usuario findById(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id=?";
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                return rs.next() ? map(rs) : null;
            }
        }
    }

    public void insert(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuario(username,email,nombres,apellidos,carrera,rol,estado) VALUES(?,?,?,?,?,?,?)";
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getNombres());
            ps.setString(4, u.getApellidos());
            ps.setString(5, u.getCarrera());
            ps.setString(6, u.getRol());
            ps.setString(7, u.getEstado());
            ps.executeUpdate();
        }
    }

    public void update(Usuario u) throws SQLException {
        String sql = "UPDATE usuario SET username=?,email=?,nombres=?,apellidos=?,carrera=?,rol=?,estado=? WHERE id=?";
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getNombres());
            ps.setString(4, u.getApellidos());
            ps.setString(5, u.getCarrera());
            ps.setString(6, u.getRol());
            ps.setString(7, u.getEstado());
            ps.setInt(8, u.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection cn = DbUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement("DELETE FROM usuario WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Usuario map(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setEmail(rs.getString("email"));
        u.setNombres(rs.getString("nombres"));
        u.setApellidos(rs.getString("apellidos"));
        u.setCarrera(rs.getString("carrera"));
        u.setRol(rs.getString("rol"));
        u.setEstado(rs.getString("estado"));
        return u;
    }
}