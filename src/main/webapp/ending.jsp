<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.08.2025
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Нічний автобус – гра</title>
    <link rel="stylesheet" href="/css/game-style.css">
    <script src="${pageContext.request.contextPath}/js/game-scripts.js"></script>
</head>
<body>
<div class="container">
    <div id="sceneText" class="text-box">${currentScene.text}</div>

    <form method="post" class="choices-form">
        <button type="submit" name="choice" class="choice-button" >Restart</button>
    </form>
</div>
</body>
</html>
