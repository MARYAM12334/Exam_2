<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Affectation des Employés à un Projet</title>
</head>
<body>
<h2>Affectation des Employés à un Projet</h2>
<form action="affectation" method="post">
    <label for="employe">Employé:</label>
    <select id="employe" name="employeId">
        <c:forEach items="${employes}" var="employe">
            <option value="${employe.id}">${employe.name}</option>
        </c:forEach>
    </select>
    <br/><br/>

    <label for="projetName">Nom du Projet:</label>
    <input type="text" id="projetName" name="projetName" required>
    <br/><br/>

    <label for="implication">Implication (%):</label>
    <select id="implication" name="implication">
        <c:forEach begin="10" end="100" step="10" var="i">
            <option value="${i}">${i}%</option>
        </c:forEach>
    </select>
    <br/><br/>

    <input type="submit" value="Affecter Projet">
</form>
</body>
</html>
