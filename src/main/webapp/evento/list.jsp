<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, org.example.tecnet.model.Evento" %>
<html>
<head>
  <title>Eventos</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/app.css"/>
</head>
<body>
<div class="header"><h2>Eventos</h2></div>
<div class="container">
  <div class="card">
    <a class="btn" href="<%=request.getContextPath()%>/evento/nuevo">Nuevo evento</a>
  </div>
  <div class="card">
    <table class="table">
      <tr><th>ID</th><th>Título</th><th>Categoría</th><th>Modalidad</th><th>Lugar</th><th>Fecha Inicio</th><th>Acciones</th></tr>
      <%
        List<Evento> eventos = (List<Evento>) request.getAttribute("eventos");
        for (Evento e : eventos) {
      %>
      <tr>
        <td><%=e.getId()%></td>
        <td><%=e.getTitulo()%></td>
        <td><%=e.getCategoria()%></td>
        <td><%=e.getModalidad()%></td>
        <td><%=e.getLugar()%></td>
        <td><%=e.getFechaInicio()%></td>
        <td>
          <a class="btn" href="<%=request.getContextPath()%>/evento/editar?id=<%=e.getId()%>">Editar</a>
          <form action="<%=request.getContextPath()%>/evento/eliminar" method="post" style="display:inline">
            <input type="hidden" name="id" value="<%=e.getId()%>"/>
            <button class="btn outline" type="submit">Eliminar</button>
          </form>
        </td>
      </tr>
      <% } %>
    </table>
  </div>
</div>
</body>
</html>