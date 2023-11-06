/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.pro.luciene.control;

import br.pro.luciene.data.AtividadeData;
import br.pro.luciene.model.AtividadeModel;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author luciene.rodrigues
 */
public class AtividadeControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AtividadeControl</title>");            
            out.println("</head>");
            out.println("<body>");
            String descricao = request.getParameter("descricao");
            //out.println("<p>" + descricao + "</p>");
            String data = request.getParameter("data");
            //out.println("<p>" + data + "</p>");
            String status = request.getParameter("status");
            //out.println("<p>" + status + "</p>");
            String acao = request.getParameter("acao");
            //out.println("<p>" + acao + "</p>");
            int id = Integer.parseInt(request.getParameter("id"));
            AtividadeModel obj = new AtividadeModel(id, descricao, data, status);
            try{
                AtividadeData DAO = new AtividadeData();
                if(acao.equals("incluir")){
                    if(DAO.incluir(obj))
                        out.println("<h3>Salvo com sucesso</h3>");
                    else
                        out.println("<h3 style='color:red;'>Erro ao salvar</h3>");
                }
                if(acao.equals("atualizar")){
                    if(DAO.atualizar(obj))
                        out.println("<h3>Atualizado com sucesso</h3>");
                    else
                        out.println("<h3 style='color:red;'>Erro ao salvar</h3>");
                }
                if(acao.equals("excluir")){
                    if(DAO.excluir(id))
                        out.println("<h3>Excluído com sucesso!</h3>");
                    else
                        out.println("<h3 style='color:red;'>Erro ao excluir</h3>");
                }
                if(acao.equals("editar")){
                    obj=DAO.obter(id); //criar no AtividadeData
                    request.setAttribute("objAtividade", obj);
                    RequestDispatcher rq = request.getRequestDispatcher("CRUDAtividade.jsp");
                    rq.forward(request, response);
                }
            }catch(Exception erro){
                out.println("<h3 style='color:red;'>Erro ao salvar: "
                        +erro.getMessage()+"</h3>");
            }
            //out.println("<h1>Servlet AtividadeControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
