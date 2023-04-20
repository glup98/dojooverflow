<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <title>Question Dashboard</title>
</head>
<body>
    <div class="m-3" >
        <a class="me-3" href="/">Dashboard</a> <a href="/questions/new">New Question</a>
    </div>

    <h1>Question Dahsboard</h1>

    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Questions</th>
                <th scope="col">Tags</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questions}" var="question">
                <tr>
                    <th scope="row"><a href="/answers/${question.id}"><c:out value="${question.questionText}"/></a></th>
                    <td>
                        <c:forEach items="${question.tags}" var="tag">
                            <c:out value="${tag.subject},"/>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>