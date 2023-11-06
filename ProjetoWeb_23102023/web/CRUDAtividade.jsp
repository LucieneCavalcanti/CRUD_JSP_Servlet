<%-- 
    Document   : CRUDAtividade
    Created on : 23 de out de 2023, 10:56:14
    Author     : luciene.rodrigues
--%>
<%@ page import="br.pro.luciene.model.AtividadeModel"%>
<%@ page import="br.pro.luciene.data.AtividadeData"%>
<%@ page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin:: Atividade</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <link rel="stylesheet" href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/dist/mdb5/standard/core.min.css">
        <link rel="stylesheet" id="roboto-subset.css-css" href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/mdb5/fonts/roboto-subset.css?ver=3.9.0-update.5" type="text/css" media="all">
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <h1>Atividades</h1>
        <%
            AtividadeModel obj = (AtividadeModel)request.getAttribute("objAtividade");
            if(obj==null) obj = new AtividadeModel();
        %>
        <form name="form1" action="AtividadeControl" method="POST">
            <label for="id">ID:<%=obj.getId() %></label>
            <input type="hidden" name="id" value="<%=obj.getId() %>"><br>
            <% if (obj.getId()==0) { %>
                <input type="hidden" name='acao' value='incluir'>
            <% } else {%>
                <input type="hidden" name='acao' value='atualizar'>
            <% } %>
            <!-- campo utilizado para enviar o que deve ser executado na servlet -->
            <label for="descricao">Descrição</label>
            <input type="text" name="descricao" value="<%=obj.getDescricao()%>" required><br>
            <label for="data">Data</label>
            <input type="text" name="data" value="<%=obj.getData()%>" required><br>
            <label for="status">Status</label>
            <input type="text" name="status" value="<%=obj.getStatus()%>" required><br>
            <% if (obj.getId()==0) {%>
                <input type="submit" value="Cadastrar">
            <% } else { %>
                <input type="submit" value="Atualizar">
            <% } %>
            <input type="reset" value="Limpar">
        </form>
        <h3>Listagem</h3>
        <%
            try{
                ArrayList<AtividadeModel> listaAtividades = new ArrayList<>();
                AtividadeData DAO = new AtividadeData();
                listaAtividades = DAO.pesquisar("");
                for(AtividadeModel a: listaAtividades) {
                    out.print("<p>" + a.getDescricao() + 
                    " <a href='AtividadeControl?id="+a.getId()+"&acao=editar'>Editar</a>"+
                    " <a href='AtividadeControl?id="+a.getId()+"&acao=excluir'>Excluir</a></p>");
                }
            }catch(Exception erro){
                out.println("Erro ao listar: " + erro.getMessage());
            }

        %>
    </body>
</html>
