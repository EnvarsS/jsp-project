<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Нічний автобус – гра</title>
    <link rel="stylesheet" href="/css/game-style.css">
    <script src="${pageContext.request.contextPath}/js/game-scripts.js"></script>
</head>
<body>
    <div class="container">
        <div id="sceneText" class = "text-box">${currentScene.text}</div>

        <form method="post" class="choices-form">
            <c:forEach var="choice" items="${currentScene.choices}">
                <button type="submit" name="isBusPlot" class="choice-button" value ="${choice.isPositive()}">${choice.text}</button>
            </c:forEach>
        </form>
    </div>
</body>
</html>
