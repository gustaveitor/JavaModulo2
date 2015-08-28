
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prueba de curso Java</title>
<link type="text/css" rel="stylesheet" href="/Comiqueria/css/estilo.css" />
<script src="/Comiqueria/js/jquery-1.11.3.min.js"></script>
</head>
<body>

	<c:set var="rol" value="${sessionScope.Roles}" />
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
				<c:if test="${rol ne null}">
					<c:if test="${rol[0] eq 'admin'}">
						<label id="lbltweet"
							style="position: absolute; top: 19em; right: .7em">Prestamos</label>
						<div class="tweet menudesplegado">
							<a href="/Comiqueria/obtener_Prestamos"><img
								src="/Comiqueria/imgs/money.png"></a>
						</div>
					</c:if>
				</c:if>
			</div>
		</div>
	</nav>
	<div class="cuerpo">
		<div class="galeria">
			<div class="busqueda">
				<div class="buscar">
					<input type="text" id="search" name="txtBuqueda"
						placeholder="Ingrese busqueda...">
					<c:if test="${rol[0] eq 'admin' }">
						<a class="action" href="/Comiqueria/insertar_Personas"><button
								class="vista cancelacion" type="button" name="alta">Nuevo</button></a>
					</c:if>
					<button class="vista exit" type="button" name="salir" onclick="">Atras</button>
				</div>
			</div>
			<div class="datagrid">
				<table id="table">
					<thead>
						<tr class="bind">
							<th>Name</th>
							<th>Telephone</th>
							<th></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="4">
						</tr>
					</tfoot>
					<tbody>
						<c:choose>
							<c:when test="${ Listado.size() > 0}">
								<c:forEach var="i" begin="0" end="${Listado.size()-1}" step="1">
									<c:choose>
										<c:when test="${i mod 2 ne 0}">
											<tr class='alt'>
												<td><c:out value="${Listado.get(i).getNamePerson()}"></c:out></td>
												<td><c:out
														value="${Listado.get(i).getTelephonePerson()}"></c:out></td>
												<td><c:if test="${rol[0] eq 'admin' }">
														<div class="wwith">
															<a
																href="/Comiqueria/actualizar_Personas?id=${Listado.get(i).getIdPerson()}">
																<img src="/Comiqueria/imgs/editar.png">
															</a>
														</div>
														<c:choose>
															<c:when test="${!Listado.get(i).getDeletable() }">
																<div class="wwith">
																	<a
																		href="/Comiqueria/eliminar_Personas?id=${Listado.get(i).getIdPerson()}"><img
																		src="/Comiqueria/imgs/eliminar.png"></a>
																</div>
															</c:when>
														</c:choose>
													</c:if></td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td><c:out value="${Listado.get(i).getNamePerson()}"></c:out></td>
												<td><c:out
														value="${Listado.get(i).getTelephonePerson()}"></c:out></td>
												<td><c:if test="${rol[0] eq 'admin' }">
														<div class="wwith">
															<a
																href="/Comiqueria/actualizar_Personas?id=${Listado.get(i).getIdPerson()}">
																<img src="/Comiqueria/imgs/editar.png">
															</a>
														</div>
														<c:choose>
															<c:when test="${!Listado.get(i).getDeletable() }">
																<div class="wwith">
																	<a
																		href="/Comiqueria/eliminar_Personas?id=${Listado.get(i).getIdPerson()}"><img
																		src="/Comiqueria/imgs/eliminar.png"></a>
																</div>
															</c:when>
														</c:choose>
													</c:if></td>
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