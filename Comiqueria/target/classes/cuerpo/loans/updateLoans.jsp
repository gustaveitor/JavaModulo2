<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="com.comics.app.Model.Comic" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prueba de curso Java</title>
<link type="text/css" rel="stylesheet" href="/Comiqueria/css/estilo.css" />
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
			<div id="opciones" class="menubut"><img src="/Comiqueria/imgs/plus.png" ></div>
			<label id="lblevent" style="position:absolute;top:7em;right:.7em">Comics</label><div class="eventbut menudesplegado"><a href="/Comiqueria/obtener_Comics"><img src="/Comiqueria/imgs/event.png"></a></div>
			<label id="lblcontact" style="position:absolute;top:13em;right:.7em">Personas</label><div class="conmenu menudesplegado"><a href="/Comiqueria/obtener_Personas"><img src="/Comiqueria/imgs/contact.png" ></a></div>
			<label id="lbltweet" style="position:absolute;top:19em;right:.7em">Prestamos</label><div class="tweet menudesplegado" ><a href="/Comiqueria/obtener_Prestamos"><img src="/Comiqueria/imgs/money.png" ></a></div></div>
	</div>
</nav>
<div class="cuerpo" >
<div class="galeria">
  <form class="" action="/Comiqueria/actualizar_Prestamos" method="post">
    <div class="contenedor-form">
      <div class="ftit renglones">
        <label class="form-tit">Modificacion Prestamo</label>
      </div>
      <div class="renglones">
        <div class="lab-cont">
          <label class="label-form">Persona </label>
        </div>
        <div class="">
          <select id="personaselect" name="personaselect" >
      			<c:forEach var="personas" items="${pListado}">
      			<c:choose>
      			<c:when test="${personas.getIdPerson() != cloan.getPerson().getIdPerson()}">
      			<option id="<c:out value="${personas.getIdPerson()}"></c:out>" value="<c:out value="${personas.getIdPerson()}">
             	</c:out>">
             	<c:out value="${personas.getNamePerson()}"></c:out>
             	</option>
      			</c:when>
      			<c:otherwise>
      			<option selected id="<c:out value="${personas.getIdPerson()}"></c:out>" value="<c:out value="${personas.getIdPerson()}">
             	</c:out>">
             	<c:out value="${personas.getNamePerson()}"></c:out>
             	</option>
      			</c:otherwise>
      			</c:choose>
      			
      			</c:forEach>
          </select>
        </div>

      </div>
      <div class="renglones">
          <div class="lab-cont">
                <label class="label-form">Comic </label>
          </div>
          <div class="">
             <select  id="comicselect" name="comicselect">
             	<c:forEach var="comiques" items="${cListado}">
             	<c:choose>
             	<c:when test="${comiques.getIdComic() != cloan.getComic().getIdComic()}">
             	<option id="<c:out value="${comiques.getIdComic()}"></c:out>" value="<c:out value="${comiques.getIdComic()}">
             	</c:out>">
             	<c:out value="${comiques.getNameComic()}"></c:out>
             	</option>
             	</c:when>
             	<c:otherwise>
             	<option selected id="<c:out value="${comiques.getIdComic()}"></c:out>" value="<c:out value="${comiques.getIdComic()}">
             	</c:out>">
             	<c:out value="${comiques.getNameComic()}"></c:out>
             	</option>
             	</c:otherwise>
             	</c:choose>
            
				</c:forEach>
             </select>
          </div>

      </div>
      <div class="renglones">
        <div class="lab-cont">
            <label class="label-form">Hasta </label>
        </div>
        <div class="">
            <input type="date" id="hasta" name="hasta" class="form-cont" value="${cloan.getDate()}"> 
        </div>

      </div>
      <div class="renglones">

          <button type="submit" name="guardar">Guardar</button>


          <button type="reset" name="limpiar">Limpiar</button>

      </div>
    </div>
  </form>
</div>
</div>
<footer>
<div>Todas las cuestiones reservadas y todo eso que hace falta para que no te destruyan <script type="text/javascript">document.write(new Date().getFullYear());
</script> </div>
<div><a href="mailto:emilio.gonzalez@globant.com">Super direccion cosmica</a> </div>
</footer>

</body>
</html>
<script src="/Comiqueria/js/RecursoJS.js"></script>