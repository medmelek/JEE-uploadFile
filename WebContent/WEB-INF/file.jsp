<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myJSP</title>
</head>
<body>

<h1>Med</h1>
<h2>Melek</h2>
<p>Med Melek</p>

<%@ include file="menu.jsp" %>

<%
for (int i=0 ; i<9; i++)
out.println(request.getAttribute("temp")+"<br>") ;
%>


<c:out value="Bonjour"/>
    
<c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p></c:if>
 
    <form method="post" action="api" enctype="multipart/form-data">
        <p>
            <label for="description">Description du fichier : </label>
            <input type="text" name="description" id="description" />
        </p>
        <p>
            <label for="fichier">Fichier à envoyer : </label>
            <input type="file" name="fichier" id="fichier" />
        </p>
        
        <input type="submit" />
    </form>

</body>
</html>