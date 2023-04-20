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
    <title>What is your question?</title>
</head>
<body>
    <div class="m-3" >
        <a class="m-1" href="/">Dahsboard</a> <a href="/questions">All Question</a>
    </div>

    <h1>What is your question?</h1>

    <form:form class="d-inline-block" action="/questions/new" method="post" modelAttribute="question">
        <div class="mb-3">
            <form:label path="questionText" class="form-label">Question:</form:label>
            <form:errors path="questionText"/>
            <form:textarea path="questionText" class="form-control" rows="3"></form:textarea>
        </div>
        <div class="mb-3">
            <label class="form-label">Tag:</label>
            <c:out value="${error}"/>
            <input name="subjects" type="text" class="form-control" placeholder="tag your question..."/>
        </div>
            <input type="submit" class="btn btn-secondary" value="Submit"/>
    </form:form>
</body>
</html>