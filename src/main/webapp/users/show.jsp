<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>
<div class="container-fluid">

  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
    <a href="<c:url value='/user/show'/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
      <i class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników</a>
  </div>
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Użytkownik:</h6>
    </div>
    <div class="card-body">
      <table  class="table">
        <thead>
        <tr>
          <th>ID</th>
          <th>Nazwa użytkownika</th>
          <th>Email</th>
          <th>Akcja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
          <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>
              <a href="edit?id=${user.id}" class="btn btn-info btn-sm">Edit</a>
              <a href="delete?id=${user.id}" class="btn btn-info btn-sm">Usuń</a>
              <a href="show?id=${user.id}" class="btn btn-info btn-sm">Pokaż</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
</div>
<%@ include file="/footer.jsp" %>


