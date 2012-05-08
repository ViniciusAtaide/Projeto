<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="v" uri="MinhasTags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
$("#abrircadastro").click(function() {
	$("#cadastro").show(100);
	$("#login").hide(100);
});
</script>


<script type="text/javascript">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=StyleSheet href="estilo.css" type="text/css" media=screen>
<title>TweetMusic</title>
</head>
<body>
<%@include file="header.jsp" %>

<c:if test="${logado eq null}">
	<div id="logincadastro">
		<div id="login">
			<form action='loga.do' method='post'>
				Login<input type="text" class='input-text' name="login"/> 
				Senha<input type="password" class='input-text' name="senha"/>
				<input type="submit" value="Login" class="input-submit"/>
				<font style="float: right;">Não está cadastrado? <a href="#" id="abrircadastro">Clique aqui</a> para se cadastrar.</font>			
			</form>
		</div>		
	<div id='cadastro'>		
		<form action='cadastra.do' method='post'>
			Login<input type="text" class="input-text" name="login" />
			Senha<input type="password" class="input-text" name="senha" />
			<input type="Submit" value="Cadastrar" class="input-submit" />
	 	</form>
	</div>
	${mensagemerro}			
</div>
</c:if>
<c:if test="${logado ne null}">
	<div id="painel">
		Bem vindo ${login}.		
	</div>
</c:if>
	<div id="musicas" class="post">
		Busque sua música.
		<form action="achamusica.do" method='post'>
			<input type="text" name="busca" class="input-text" />
			<input type="Submit" value="procurar" class="input-submit"/>
		</form>
		Top 10 musicas mais escutadas.
		<c:forEach items="${musicas}" var="musica" >
			${musica.titulo} <br /> 
		</c:forEach>
	</div>
	<c:if test="${logado ne null}">
		<div id="miniposts" class="post">
			MiniPosts:
			<c:forEach items="${usuario.miniposts}" var="minipost">
				<div id="minipost">
					<h2>${minipost.titulo}</h2>
					<p>${minipost.conteudo}</p>
				</div>
			</c:forEach>
		</div>				
	</c:if>
	<div id="artistas" class="post">
		Busque seu artista.
		<form action="achaartista.do" method="post">
			<input type="text" name="busca" class="input-text"/>
			<input type="submit" value="procurar" class="input-submit"/>		
		</form>
		Top 10 artistas mais escutados.
		<c:forEach items="${autores}" var="autor">
			${autor.nome}
		</c:forEach>
	</div>
	
	<a href="/painel.jsp">Painel de Controle</a>
	
	<%@include file="rodape.jsp" %>
	
</body>
</html>