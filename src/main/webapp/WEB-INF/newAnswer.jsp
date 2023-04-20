<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <title>New Answer</title>
</head>
<body>
    <div class="m-3" >
        <a class="m-1" href="/">Dahsboard</a> <a href="/questions">All Question</a>
    </div>

    <h1><c:out value="${question.questionText}"/></h1>
    <div>
        <h2 class="d-inline-block">Tags:</h2>
        <c:forEach items="${tagsList}" var="tag">
            <p class="d-inline-block bg-secondary bg-gradient p-2 rounded text-light"><c:out value="${tag.subject}"/></p>
        </c:forEach>
    </div>

    <div class="d-inline-block align-top p-5">
        <h3>Answers:</h3>
        <ul class="list-group">
            <c:forEach items="${question.answers}" var="answer">
                <li class="list-group-item"><c:out value="${answer.answerText}"/></li>    
            </c:forEach>
        </ul>        
    </div>

    <form:form class="d-inline-block" action="/answers/${question.id}" method="post" modelAttribute="answer">
        <div class="mb-3">
            <form:label path="answerText" class="form-label">Answer:</form:label>
            <form:errors path="answerText"/>
            <form:textarea path="answerText" class="form-control" rows="9" cols="50"></form:textarea>
        </div>
        <input type="submit" class="btn btn-secondary" value="Submit"/>
    </form:form>
    
</body>
</html>