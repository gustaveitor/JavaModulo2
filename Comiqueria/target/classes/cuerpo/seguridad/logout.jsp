<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.comics.app.Model.Comic"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comicstorieishon</title>
<link type="text/css" rel="stylesheet" href="/Comiqueria/css/estilo.css" />
</head>
<body>
	<nav role="navigation">
		<!--Contenido de imagen perfil y marca-->
		<div class="barra clearfix">
			<!--<div class="profdiv"><img class="profile" src="https://f1.bcbits.com/img/0000101507_10.jpg"></div>-->
			<div class="brandiv clearfix">
				<label class="brand">Comic</label><a href="/Comiqueria/login_App"
					class="login"> <c:choose>
						<c:when test="${sessionScope.Usuario ne null}">
			[<c:out value="${sessionScope.Usuario }"></c:out>]
			</c:when>
						<c:otherwise>
			[Inicie sesion]
		
			</c:otherwise>
					</c:choose>
				</a>
			</div>
		</div>
		<!--Menu de opciones para sistema-->
		<div class="menudiv">
			<div class="menubar">
				<div id="opciones" class="menubut">
					<img src="/Comiqueria/imgs/plus.png">
				</div>
				<label id="lblevent"
					style="position: absolute; top: 7em; right: .7em">Comics</label>
				<div class="eventbut menudesplegado">
					<a href="/Comiqueria/obtener_Comics"><img
						src="/Comiqueria/imgs/event.png"></a>
				</div>
				<label id="lblcontact"
					style="position: absolute; top: 13em; right: .7em">Personas</label>
				<div class="conmenu menudesplegado">
					<a href="/Comiqueria/obtener_Personas"><img
						src="/Comiqueria/imgs/contact.png"></a>
				</div>
				<label id="lbltweet"
					style="position: absolute; top: 19em; right: .7em">Prestamos</label>
				<div class="tweet menudesplegado">
					<a href="/Comiqueria/obtener_Prestamos"><img
						src="/Comiqueria/imgs/money.png"></a>
				</div>
			</div>
		</div>
	</nav>
	<div class="cuerpo">
		<div class="galeria">
			<form action="/Comiqueria/logout_App" method="post">
				<div class="contenedor-form">
					<div class="ftit renglones">
						<label class="form-tit">Estado de la sesion</label>
					</div>
					<div class="renglones">
						<div>
							<label class="label-form">El usuario actual es : <c:out value="${sessionScope.Usuario }"></c:out> </label>
						</div>
					</div>
					<div class="renglones">
						<button type="submit" tabindex=3 name="guardar">Cerrar</button>	
						<button type="button"
							onclick="window.location.href='/Comiqueria/index_App';"
							tabindex=4 name="limpiar">Atras</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<footer>
		<div>
			Todas las cuestiones reservadas y todo eso que hace falta para que no
			te destruyan
			<script type="text/javascript">
				document.write(new Date().getFullYear());
			</script>
		</div>
		<div>
			<a href="mailto:emilio.gonzalez@globant.com">Super direccion
				cosmica</a>
		</div>
	</footer>

</body>
</html>
<script src="/Comiqueria/js/RecursoJS.js"></script>