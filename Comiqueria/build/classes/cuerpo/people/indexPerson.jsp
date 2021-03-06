<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.comics.app.Model.Comic" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prueba de curso Java</title>
<link type="text/css" rel="stylesheet" href="/Comicstore/css/estilo.css" />
</head>
<body>
   

<nav role="navigation">
	<!--Contenido de imagen perfil y marca-->
	<div class ="barra clearfix">	
		<!--<div class="profdiv"><img class="profile" src="https://f1.bcbits.com/img/0000101507_10.jpg"></div>-->
		<div class="brandiv clearfix"><label class="brand">Comics</label></div>
	</div>
	<!--Menu de opciones para sistema-->
	<div class="menudiv">
		<div class="menubar">
				<div id="opciones" class="menubut"><img src="../Comicstore/imgs/plus.png" ></div>
			<label id="lblevent" style="position:absolute;top:7em;right:.7em">Comics</label><div class="eventbut menudesplegado"><a href="../Comicstore/obtener_Comics"><img src="../Comicstore/imgs/event.png"></a></div>
			<label id="lblcontact" style="position:absolute;top:13em;right:.7em">Personas</label><div class="conmenu menudesplegado"><a href="../Comicstore/obtener_Personas"><img src="../Comicstore/imgs/contact.png" ></a></div>
			<label id="lbltweet" style="position:absolute;top:19em;right:.7em">Prestamos</label><div class="tweet menudesplegado" ><a href="../Comicstore/obtener_Prestamos"><img src="../Comicstore/imgs/money.png" ></a></div></div>
	</div>
</nav>
<div class="cuerpo" >
<div class="galeria">
  <div class="busqueda">
    <div class="buscar">
      <input type="text" name="txtBuqueda" placeholder="Ingrese busqueda...">
     <button class="vista busquedabut" type="button" name="btnbusq">Buscar</button>
       <a  class ="action" href="/Comicstore/insertar_Personas"><button class="vista cancelacion" type="button" name="alta">Nuevo</button></a>
      <button class="vista exit" type="button" name="salir" onclick="">Atras</button>
    </div>
    </div>
    <div class="datagrid"><table>
      <thead><tr><th>Name</th><th>Telephone</th><th></th></tr></thead>
   <tfoot><tr><td colspan="4"></tr></tfoot>
   <tbody>
    <c:choose>
      <c:when test="${ Listado.size() > 0}">
	<c:forEach var="i" begin="0" end="${Listado.size()-1}" step="1">
	 <c:choose>
      <c:when test="${i mod 2 ne 0}">
          <tr class='alt'>
        <td>  <c:out value="${Listado.get(i).getNamePerson()}"></c:out></td>
        <td><c:out value="${Listado.get(i).getTelephonePerson()}"></c:out></td>
        <td>
         <div class="wwith">   <a href="/Comicstore/actualizar_Personas?id=${Listado.get(i).getIdPerson()}"> <img  src="/Comicstore/imgs/editar.png"></a> </div>
        <div  class="wwith">    <a href="/Comicstore/eliminar_Personas?id=${Listado.get(i).getIdPerson()}"><img src="/Comicstore/imgs/eliminar.png"></a>   </div>
   
      
         </td></tr>
      </c:when>
      <c:otherwise>
      <tr>
       <td>  <c:out value="${Listado.get(i).getNamePerson()}"></c:out></td>
        <td><c:out value="${Listado.get(i).getTelephonePerson()}"></c:out></td>
        <td>
         <div class="wwith">   <a href="/Comicstore/actualizar_Personas?id=${Listado.get(i).getIdPerson()}"> <img  src="/Comicstore/imgs/editar.png"></a> </div>
        <div  class="wwith">    <a href="/Comicstore/eliminar_Personas?id=${Listado.get(i).getIdPerson()}"><img src="/Comicstore/imgs/eliminar.png"></a>   </div>
   
       
</td>
      </tr>
      </c:otherwise>
      </c:choose>

	</c:forEach>
    </c:when>
      </c:choose>
	</tbody>
	</table>
	</div>
</div>
</div>
<footer>
<div>Todas las cuestiones reservadas y todo eso que hace falta para que no te destruyan <script type="text/javascript">document.write(new Date().getFullYear());
</script> </div>
<div><a href="mailto:emilio.gonzalez@globant.com">Super direccion cosmica</a> </div>
</footer>

</body>
</html>
<script src="/Comicstore/js/RecursoJS.js"></script>