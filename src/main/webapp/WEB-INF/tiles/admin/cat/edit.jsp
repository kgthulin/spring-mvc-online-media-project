<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5">
    <div class="col-md-6 offset-md-3">
        <form:form action="/admin/cat/edit" modelAttribute="category" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input type="text" class="form-control" id="name" path="name" value="${category.name}" />
            </div>
            <form:input type="hidden" id="id" name="id" path="id" value="${category.id}" />
            <button type="submit" class="btn btn-primary">Update</button>
        </form:form>
    </div>
</div>
