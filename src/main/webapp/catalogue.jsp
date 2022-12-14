<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
    <title>catalogue produits</title>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/style.css" >
    <script type="text/javascript">
        function confirmer(url){
            let rep = confirm("Êtes vous sûr de vouloir supprimer ?");
            if(rep==true){
                document.location = url;
            }
        }
    </script>
</head>
<body>
<div>
    <form action="catalogue" method="post">
        <table>
            <tr>
                <td>Mot Clé:  </td>
                <td> <input type="text" name="motCle" value="${model.motCle}"/></td>
                <td><input type="submit" name="action" value="find" /> </td>
            </tr>
        </table>
    </form>
</div>
<div>
    <span>Ajouter un nouveau produit</span>
    <form action="catalogue" method="post">
        <input type="hidden" value="${model.mode}" name="mode">
        <table>
            <c:if test="${model.mode=='save'}">
                <tr>
                    <td>Reference :  </td>
                    <td> <input type="text" name="reference" value="${model.produit.reference}" /></td>
                    <td></td>
                </tr>
            </c:if>
            <c:if test="${model.mode=='edit'}">
                <tr>
                    <td>Reference :  </td>
                    <td> ${model.produit.reference} <input type="hidden" name="reference" value="${model.produit.reference}" /></td>
                    <td></td>
                </tr>
            </c:if>
            <tr>
                <td>Designation :  </td>
                <td> <input type="text" name="designation" value="${model.produit.designation}"/></td>
                <td></td>
            </tr>
            <tr>
                <td>Prix :  </td>
                <td> <input type="text" name="prix" value="${model.produit.prix}"/></td>
                <td></td>
            </tr>
            <tr>
                <td>Quantite :  </td>
                <td> <input type="text" name="quantite" value="${model.produit.quantite}"/></td>
                <td></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="save"  /> </td>
            </tr>

        </table>
    </form>
    <span>
        ${model.errors}
    </span>
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
                <td><a href="javascript:confirmer('catalogue?action=delete&ref=${p.reference}')"> Supprimer</a></td>
                <td><a href="catalogue?action=edit&ref=${p.reference}" > Modifier</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
