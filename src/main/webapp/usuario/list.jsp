<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, org.example.tecnet.model.Usuario" %>
<html>
<head>
  <title>Usuarios</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/app.css"/>
</head>
<body>
<div class="header"><h2>Usuarios</h2></div>
<div class="container">
  <div class="card">
    <a class="btn" href="<%=request.getContextPath()%>/usuario/nuevo">Nuevo usuario</a>
  </div>
  <div class="card">
    <table class="table">
      <tr><th>ID</th><th>Username</th><th>Email</th><th>Nombres</th><th>Apellidos</th><th>Acciones</th></tr>
      <%
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        for (Usuario u : usuarios) {
      %>
      <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getUsername()%></td>
        <td><%=u.getEmail()%></td>
        <td><%=u.getNombres()%></td>
        <td><%=u.getApellidos()%></td>
        <td>
          <a class="btn" href="<%=request.getContextPath()%>/usuario/editar?id=<%=u.getId()%>">Editar</a>
          <form action="<%=request.getContextPath()%>/usuario/eliminar" method="post" style="display:inline">
            <input type="hidden" name="id" value="<%=u.getId()%>"/>
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