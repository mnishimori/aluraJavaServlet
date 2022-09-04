<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/mostraEmpresa" var="linkServletEditaEmpresa"/>
<c:url value="/removeEmpresa" var="linkServletRemoveEmpresa"/>


<!DOCTYPE html><html>
<head>
<meta charset="UTF-8">
<title>Lista de empresas</title>
</head>
<body>
	<c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com sucesso!
    </c:if>
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			
			<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="${linkServletEditaEmpresa}?id=${empresa.id}">edita</a>
				<a href="${linkServletRemoveEmpresa}?id=${empresa.id}">remove</a>
			</li>
		</c:forEach>
    </ul>
</body>
</html>