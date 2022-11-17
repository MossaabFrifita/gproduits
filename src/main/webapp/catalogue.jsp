<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
    <title>catalogue produits</title>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/style.css" >
</head>
<body>
<div>
    <form action="/gproduits_war_exploded/catalogue" method="post">
        <table>
            <tr>
                <td>Mot Clé:  </td>
                <td> <input type="text" name="motCle" value="${model.motCle}"/></td>
                <td><input type="submit" name="action" value="chercher" /> </td>
            </tr>
        </table>
    </form>
</div>
<div>
    <table class="styled-table">
        <tr>
            <th> REF </th><th> DES </th><th> PRIX </th><th> QUANTITE</th>
        </tr>
        <c:forEach items="${model.produits}" var="p">
            <tr>
                <td>${p.reference}</td>
                <td>${p.designation}</td>
                <td>${p.prix}</td>
                <td>${p.quantite}</td>
                <td><a href="catalogue?action=delete&ref=${p.reference}"> Supprimer</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
