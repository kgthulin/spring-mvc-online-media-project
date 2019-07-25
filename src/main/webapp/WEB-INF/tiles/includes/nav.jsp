<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid bg-dark">
    <nav class="container navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="/">
            <img src="/assets/imgs/media.png" width="30" height="30" class="rounded" />
            <span class="text-white ml-3">Online Media</span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link text-white" href="/">Home </a>
                </li>
                <c:if test="${pageContext.request.userPrincipal.authenticated}">
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/author/home">User Panel </a>
                    </li>
                </c:if>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Categories
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                            <c:forEach var="cat" items="${cats}">
                                <a class="dropdown-item" href="/cat/post/${cat.id}">${cat.name}</a>
                            </c:forEach>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Member
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:if test="${!pageContext.request.userPrincipal.authenticated}">
                            <a class="dropdown-item" href="/login">Login</a>
                            <a class="dropdown-item" href="/register">Register</a>
                        </c:if>
                        <c:url var="logout" value="/logout" />
                        <c:if test="${pageContext.request.userPrincipal.authenticated}">
                            <form action="${logout}" method="post">
                                <input type="submit" value="Logout" class="btn btn-default ml-2" />
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </form>
                        </c:if>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="/author/home">Contact </a>
                </li>
            </ul>
        </div>
    </nav>
</div>
