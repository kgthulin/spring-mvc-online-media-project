<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <form:form action="/author/post/create" method="post" modelAttribute="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="cat_id">Choose Category</label>
            <form:select class="form-control" id="cat_id" name="cat_id" path="cat_id">
                <c:forEach var="cat" items="${cats}">
                    <option value="${cat.id}">${cat.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <label for="title">Title</label>
            <form:input type="text" class="form-control" id="title" name="title" path="title" />
        </div>
        <div class="form-group">
            <label for="file">Image Upload</label>
            <form:input type="file" class="form-control-file" id="file" name="file" path="file" />
        </div>
        <div class="form-group">
            <label for="content">Content</label>
            <form:textarea class="form-control" id="content" rows="3" name="content" path="content" />
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>
