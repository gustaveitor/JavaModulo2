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
<link type="text/css" rel="stylesheet" href="../Comicstore/css/estilo.css" />
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
  <form action="/Comicstore/actualizar_Comics" method="post">
    <div class="contenedor-form">
      <div class="ftit renglones">
        <label class="form-tit">Modificar Comic</label>
      </div>
      <div class="renglones">
        <div class="lab-cont">
          <label class="label-form">Comic </label>
        </div>
        <div class="">
          <input class="form-cont" type="text" id="comicname" name="comicname" value="<c:out value="${libro.getNameComic()}"></c:out>"/></div>
        </div>
      <div class="renglones">
        <div class="lab-cont">
          <label class="label-form">Publica </label>
        </div>
        <div class="">
          <input class="form-cont" type="text" id="comicpub" name="comicpub"  value =<c:out value="${libro.getCompanyComic()}"></c:out> />
        </div>

      </div>
      <div class="renglones">
          <div class="lab-cont">
                <label class="label-form">Stock </label>
          </div>
          <div class="">
                    <input class="form-cont" type="number" id="comicstock" name="comicstock" value ="<c:out value="${Integer.parseInt(libro.getQuantityComic())}"></c:out>"/>
          </div>

      </div>
      <div class="renglones">
        <div class="lab-cont">
            <label class="label-form">Review </label>
        </div>
        <div class="">
            <textarea class="form-cont"  id="comicreview" name="comicreview"> <c:out value="${libro.getReviewComic()}"></c:out></textarea>
        </div>

      </div>
      <div class="renglones">

          <button type="submit" name="guardar">Guardar</button>
          <button type="button" name="limpiar" onclick="window.history.back();">Atras</button>

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
<script src="../Comicstore/js/RecursoJS.js"></script>