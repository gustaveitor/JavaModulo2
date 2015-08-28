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
				<label class="brand">Comic</label>
			</div>
		</div>
		<!--Menu de opciones para sistema-->
		<div class="menudiv">
		</div>
	</nav>
	<div class="cuerpo">
		<div class="galeria">
			<form action="/Comiqueria/logout_App" method="post">
				<div class="contenedor-form">
					<div class="ftit renglones">
						<label class="form-tit">Surgio un error en lo que intentaba hacer</label>
					</div>
					<div class="renglones">
						<div>
							<label class="label-form">El usuario actual es : <c:out
									value="${sessionScope.error.toString() }"></c:out>
							</label>
						</div>
					</div>
					<div class="renglones">
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