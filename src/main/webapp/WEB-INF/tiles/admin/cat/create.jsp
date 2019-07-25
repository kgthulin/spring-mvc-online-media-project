<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5">
    <div class="col-md-6 offset-md-3">
        <form:form action="/admin/cat/create" modelAttribute="category" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input type="text" class="form-control" id="name" path="name" />
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
        </form:form>
    </div>
</div>
