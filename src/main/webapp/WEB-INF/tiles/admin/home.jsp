<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <table class="table table-bordered">
        <thead>
        <tr class="bg-dark text-white">
            <th>No.</th>
            <th>title</th>
            <th>Content</th>
            <th>Image</th>
            <th>Category</th>
            <th>Author</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="post" items="${posts}" varStatus="count">
            <tr>
                <td>${count.count}</td>
                <td>${post.title}</td>
                <td>${post.content}</td>
                <td>
                    <img src="/assets/imgs/${post.image}" width="50" height="50" />
                </td>
                <td>${post.category.name}</td>
                <td>${post.user.username}</td>
                <td>
                    <a href="/author/post/edit/${post.id}" class="btn btn-warning btn-sm"><i class="fa fa-edit"></i></a>
                    <a href="/author/post/delete/${post.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

