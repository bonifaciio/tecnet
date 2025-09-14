<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, org.example.tecnet.model.Usuario, org.example.tecnet.model.Evento" %>
<html>
<head>
  <title>Filtrar Inscripciones</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/app.css"/>
</head>
<body>
<div class="header"><h2>Filtrar Inscripciones</h2></div>
<div class="container">
  <div class="card">
    <form method="get" action="<%=request.getContextPath()%>/inscripciones" class="form-grid">
      <div>
        <label>Modo</label>
        <select class="select" name="modo" required>
          <option value="">-- Selecciona --</option>
          <option value="alumno" <%= "alumno".equals(request.getAttribute("modo"))?"selected":"" %>>Alumno → ver eventos</option>
          <option value="evento" <%= "evento".equals(request.getAttribute("modo"))?"selected":"" %>>Evento → ver alumnos</option>
        </select>
      </div>
      <div>
        <label>Alumno</label>
        <select class="select" name="id">
          <option value="">-- Selecciona --</option>
          <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            Integer selId = (Integer) request.getAttribute("seleccionId");
            if (usuarios != null) {
              for (Usuario u: usuarios) {
          %>
            <option value="<%=u.getId()%>" <%= ("alumno".equals(request.getAttribute("modo")) && selId != null && selId.equals(u.getId())) ? "selected" : "" %>>
              <%=u.getId()%> - <%=u.getApellidos()%>, <%=u.getNombres()%>
            </option>
          <% }} %>
        </select>
      </div>
      <div>
        <label>Evento</label>
        <select class="select" name="id">
          <option value="">-- Selecciona --</option>
          <%
            List<Evento> events = (List<Evento>) request.getAttribute("events");
            if (events != null) {
              for (Evento e: events) {
          %>
            <option value="<%=e.getId()%>" <%= ("evento".equals(request.getAttribute("modo")) && selId != null && selId.equals(e.getId())) ? "selected" : "" %>>
              <%=e.getId()%> - <%=e.getTitulo()%>
            </option>
          <% }} %>
        </select>
      </div>
      <div class="full">
        <button class="btn" type="submit">Buscar</button>
        <a class="btn outline" href="<%=request.getContextPath()%>/">Inicio</a>
      </div>
    </form>
  </div>

  <%
    if ("alumno".equals(request.getAttribute("modo"))) {
      List<Evento> listaEventos = (List<Evento>) request.getAttribute("listaEventos");
  %>
    <div class="card"><h3>Eventos donde está inscrito el alumno</h3>
      <table class="table">
        <tr><th>ID</th><th>Título</th><th>Categoría</th><th>Modalidad</th><th>Fecha Inicio</th></tr>
        <% if (listaEventos != null) for (Evento e: listaEventos) { %>
          <tr>
            <td><%=e.getId()%></td>
            <td><%=e.getTitulo()%></td>
            <td><%=e.getCategoria()%></td>
            <td><%=e.getModalidad()%></td>
            <td><%=e.getFechaInicio()%></td>
          </tr>
        <% } %>
      </table>
    </div>
  <%
    } else if ("evento".equals(request.getAttribute("modo"))) {
      List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
  %>
    <div class="card"><h3>Alumnos inscritos en el evento</h3>
      <table class="table">
        <tr><th>ID</th><th>Username</th><th>Email</th><th>Nombres</th><th>Apellidos</th></tr>
        <% if (listaUsuarios != null) for (Usuario u: listaUsuarios) { %>
          <tr>
            <td><%=u.getId()%></td>
            <td><%=u.getUsername()%></td>
            <td><%=u.getEmail()%></td>
            <td><%=u.getNombres()%></td>
            <td><%=u.getApellidos()%></td>
          </tr>
        <% } %>
      </table>
    </div>
  <% } %>
</div>
</body>
</html>
