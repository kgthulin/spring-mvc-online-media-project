<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <a href="/admin/cat/create" class="btn btn-primary btn-sm mb-3">
        Create  <i class="fa fa-plus"></i>
    </a>
    <table class="table table-bordered">
        <thead>
        <tr class="bg-dark text-white">
            <th>No.</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cat" items="${cats}" varStatus="count">
            <tr>
                <td>${count.count}</td>
                <td>${cat.name}</td>
                <td>
                    <a href="/admin/cat/edit/${cat.id}" class="btn btn-warning btn-sm"><i class="fa fa-edit"></i></a>
                    <a href="/admin/cat/delete/${cat.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>