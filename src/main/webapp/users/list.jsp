<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp"%>

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
          <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
          <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                  class="fas fa-download fa-sm text-white-50"></i> Add new User</a>
        </div>

        <!-- Content Row -->
        <div class="row">
            <div class="col-12">
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary"> Users list</h6>
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
                        <button type="button" class="btn btn-warning btn-sm" onclick="openEditModal(${user.id}, '${user.userName}', '${user.email}')">
                          Edytuj
                        </button>
<%--                        <a href="edit?id=${user.id}" class="btn btn-info btn-sm">Edit</a>--%>
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
        </div>
      </div>



<%--    // Source - https://stackoverflow.com/q/29388142--%>
<%--    // Posted by Pharetra, modified by community. See post 'Timeline' for change history--%>
<%--    // Retrieved 2026-07-24, License - CC BY-SA 3.0--%>

    <!-- Edit Modal -->
    <div class="modal fade" id="editmodal" tabindex="-1" role="dialog" aria-labelledby="editmodallabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" > Edytuj użytkownika</h5>
            <button class="close" type="button" data-dismiss="modal">
              <span aria-hidden="true"> x </span>
            </button>
          </div>
          <div class="modal-body">
            <form id="editForm" action="user/edit" method="post">
              <input type="hidden" id="editId" name="id">
              <label>Username: <input type="text" id="editUsername" name="username"></label> <br>
              <label> Email: <input type="text" id="editEmail" name="email"></label> <br>
              <label>Password: <input type="password" id="editPassword" name="password"> </label> <br>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Anuluj</button>
            <button type="button" class="btn btn-primary" form="editForm">Zapisz</button>
          </div>
        </div>
      </div>



  <script>
    function openEditModal(id, username, email) {
      document.getElementById('editId').value = id;
      document.getElementById('editUsername').value = username;
      document.getElementById('editEmail').value = email;
      $('#editModal').modal('show');
    }
  </script>
</div>
<%@include file="/footer.jsp"%>
