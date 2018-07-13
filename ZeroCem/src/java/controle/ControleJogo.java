/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.ZeroCem;

/**
 *
 * @author LEESE
 */
@WebServlet(name = "ControleJogo", urlPatterns = {"/ControleJogo"})
public class ControleJogo extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
              HttpSession ses = request.getSession();
             int numero = Integer.parseInt(request.getParameter("numero"));  
            ZeroCem jogo = (ZeroCem) ses.getAttribute("jogo");
            if (jogo == null) {
                jogo = new ZeroCem(numero);
                ses.setAttribute("jogo", jogo);
            }
            jogo.setNumeroUsuario(numero);
            
           
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControleJogo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(" " + jogo.getNumeroSorteado() + "</h1>");
            out.println(" " + jogo.getNumeroUsuario() + "</h1>");
            out.println(" " + jogo.jogar() + "</h1>");
             out.println(" <form action=\"ControleJogo\" method=\"POST\">\n" +
"            Numero: <input type=\"text\" name=\"numero\"/><br>\n" +
"            <input type=\"submit\" name=\"bt\" value=\"Jogar\"/><br>\n" +
"        </form>");
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
