<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <div class="col-md-6 offset-md-3">
        <h1 class="text-info text-center mb-3">Login To Post</h1>
        <h4 class="text-danger">${error}</h4>
        <h4 class="text-success">${logout}</h4>
        <h4 class="text-success">${register}</h4>
        <form action="<c:url value="/j_spring_security_check" />" method="post">
            <div class="form-group">
                <label for="username">User Name</label>
                <input type="text" id="username" name="username" class="form-control" />
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" class="form-control" />
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="Login" class="btn btn-primary btn-sm float-right" />
        </form>
    </div>
</div>
