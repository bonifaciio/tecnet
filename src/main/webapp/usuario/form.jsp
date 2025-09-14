<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.example.tecnet.model.Usuario" %>
<%
  Usuario u = (Usuario) request.getAttribute("u");
  boolean edit = (u != null && u.getId()!=null);
%>
<html>
<head>
  <title><%= edit ? "Editar Usuario" : "Nuevo Usuario" %></title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/app.css"/>
</head>
<body>
<div class="header"><h2><%= edit ? "Editar Usuario" : "Nuevo Usuario" %></h2></div>
<div class="container">
  <div class="card">
    <form method="post" action="<%=request.getContextPath()%><%= edit? "/usuario/actualizar" : "/usuario/guardar" %>">
      <% if (edit) { %><input type="hidden" name="id" value="<%=u.getId()%>"/><% } %>
      <div class="form-grid">
        <div><label>Username</label><input class="input" name="username" value="<%= edit? u.getUsername() : "" %>" required></div>
        <div><label>Email</label><input class="input" name="email" value="<%= edit? u.getEmail() : "" %>" required></div>
        <div><label>Nombres</label><input class="input" name="nombres" value="<%= edit? u.getNombres() : "" %>" required></div>
        <div><label>Apellidos</label><input class="input" name="apellidos" value="<%= edit? u.getApellidos() : "" %>" required></div>
        <div><label>Carrera</label><input class="input" name="carrera" value="<%= edit? u.getCarrera() : "" %>" required></div>
        <div><label>Rol</label>
          <select class="select" name="rol">
            <option <%= edit && "DOCENTE".equals(u.getRol())?"":"selected" %> value="ESTUDIANTE">ESTUDIANTE</option>
            <option <%= edit && "DOCENTE".equals(u.getRol())?"selected":"" %> value="DOCENTE">DOCENTE</option>
            <option <%= edit && "PROFESIONAL".equals(u.getRol())?"selected":"" %> value="PROFESIONAL">PROFESIONAL</option>
          </select>
        </div>
        <div class="full"><label>Estado</label>
          <select class="select" name="estado">
            <option value="ACTIVO" <%= edit && "ACTIVO".equals(u.getEstado())?"selected":"" %>>ACTIVO</option>
            <option value="INACTIVO" <%= edit && "INACTIVO".equals(u.getEstado())?"selected":"" %>>INACTIVO</option>
          </select>
        </div>
      </div>
      <br/>
      <button class="btn success" type="submit"><%= edit ? "Actualizar" : "Guardar" %></button>
      <a class="btn outline" href="<%=request.getContextPath()%>/usuario">Volver</a>
    </form>
  </div>
</div>
</body>
</html>