<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.example.tecnet.model.Evento" %>
<%
  Evento e = (Evento) request.getAttribute("e");
  boolean edit = (e != null && e.getId()!=null);
%>
<html>
<head>
  <title><%= edit ? "Editar Evento" : "Nuevo Evento" %></title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/app.css"/>
</head>
<body>
<div class="header"><h2><%= edit ? "Editar Evento" : "Nuevo Evento" %></h2></div>
<div class="container">
  <div class="card">
    <form method="post" action="<%=request.getContextPath()%><%= edit? "/evento/actualizar" : "/evento/guardar" %>">
      <% if (edit) { %><input type="hidden" name="id" value="<%=e.getId()%>"/><% } %>
      <div class="form-grid">
        <div class="full"><label>Título</label><input class="input" name="titulo" value="<%= edit? e.getTitulo() : "" %>" required></div>
        <div class="full"><label>Descripción</label><input class="input" name="descripcion" value="<%= edit? e.getDescripcion() : "" %>" required></div>
        <div><label>Categoría</label>
          <select class="select" name="categoria">
            <option value="CONFERENCIA" <%= edit && "CONFERENCIA".equals(e.getCategoria())?"selected":"" %>>CONFERENCIA</option>
            <option value="TALLER" <%= edit && "TALLER".equals(e.getCategoria())?"selected":"" %>>TALLER</option>
            <option value="SEMINARIO" <%= edit && "SEMINARIO".equals(e.getCategoria())?"selected":"" %>>SEMINARIO</option>
          </select>
        </div>
        <div><label>Modalidad</label>
          <select class="select" name="modalidad">
            <option value="PRESENCIAL" <%= edit && "PRESENCIAL".equals(e.getModalidad())?"selected":"" %>>PRESENCIAL</option>
            <option value="VIRTUAL" <%= edit && "VIRTUAL".equals(e.getModalidad())?"selected":"" %>>VIRTUAL</option>
            <option value="HIBRIDO" <%= edit && "HIBRIDO".equals(e.getModalidad())?"selected":"" %>>HÍBRIDO</option>
          </select>
        </div>
        <div><label>Lugar</label><input class="input" name="lugar" value="<%= edit? e.getLugar() : "" %>" required></div>
        <div><label>Aforo</label><input class="input" type="number" name="aforo" value="<%= edit? e.getAforo() : "" %>" required></div>
        <div><label>Fecha Inicio</label><input class="input" type="datetime-local" name="fechaInicio" value="<%= edit? e.getFechaInicio() : "" %>" required></div>
        <div><label>Fecha Fin</label><input class="input" type="datetime-local" name="fechaFin" value="<%= edit? e.getFechaFin() : "" %>" required></div>
        <div class="full"><label>Estado</label>
          <select class="select" name="estado">
            <option value="PROGRAMADO" <%= edit && "PROGRAMADO".equals(e.getEstado())?"selected":"" %>>PROGRAMADO</option>
            <option value="EN_CURSO" <%= edit && "EN_CURSO".equals(e.getEstado())?"selected":"" %>>EN CURSO</option>
            <option value="FINALIZADO" <%= edit && "FINALIZADO".equals(e.getEstado())?"selected":"" %>>FINALIZADO</option>
            <option value="CANCELADO" <%= edit && "CANCELADO".equals(e.getEstado())?"selected":"" %>>CANCELADO</option>
          </select>
        </div>
      </div>
      <br/>
      <button class="btn success" type="submit"><%= edit ? "Actualizar" : "Guardar" %></button>
      <a class="btn outline" href="<%=request.getContextPath()%>/evento">Volver</a>
    </form>
  </div>
</div>
</body>
</html>