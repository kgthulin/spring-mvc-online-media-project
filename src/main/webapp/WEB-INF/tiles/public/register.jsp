<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5">
    <div class="col-md-6 offset-md-3">
        <h1 class="text-info text-center mb-3">Register To Post</h1>
        <form:form action="/register" method="post" modelAttribute="user">
            <div class="form-group">
                <label for="username">User Name</label>
                <form:input type="text" id="username" name="username" class="form-control" path="username" />
                <form:errors path="username" id="username" cssClass="text-danger" />
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input type="email" id="email" name="email" class="form-control" path="email" />
                <form:errors path="email" id="email" cssClass="text-danger" />
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <form:input type="password" id="password" name="password" class="form-control" path="password" />
                <form:errors path="password" id="password" cssClass="text-danger" />
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="Register" class="btn btn-primary btn-sm float-right" />
        </form:form>
    </div>
</div>

