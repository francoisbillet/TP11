/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pedago
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

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
        
        HttpSession session = ((HttpServletRequest)request).getSession(true);
        
        String playerName = request.getParameter("playerName");
        
        int guess;
        int tries;
        String jspView;
        
        if (playerName==null) { //page de login
            jspView = "view.jsp";
                    String action = request.getParameter("action2");
                    if ("CONNECT".equals(action)) {
                            playerName = request.getParameter("playerName");

                            System.out.println(playerName+"if");

                            session.setAttribute("playerName",playerName);

                            guess = (int)(Math.random() * (100 + 1));  //nombre aléatoire
                            session.setAttribute("guess",guess);

                            tries = 0;                              //essai
                            session.setAttribute("tries",tries);
                        }
        }
        
        else {
            System.out.println(playerName+"else");
                    jspView = "game.jsp";
                    
                    String bas = "bas";
                    String haut = "haut";

                    //getServletContext().setAttribute("mini",0);
                    //getServletContext().setAttribute("maxi",100);

                    
                    guess = (int) session.getAttribute("guess");
                                        
                    String action = request.getParameter("action");
                    
                    if ("ADD".equals(action)) { 
                        
                        int proposition = Integer.parseInt(request.getParameter("nombre"));
                        
                        System.out.println("nombre"+proposition);
                        
                        tries = (int) session.getAttribute("tries");    //tries++
                        tries += 1;
                        getServletContext().setAttribute("tries",tries);
                        session.setAttribute("tries",tries);

                        if (proposition < guess) getServletContext().setAttribute("hauteur",bas);

                        else if (proposition > guess) getServletContext().setAttribute("hauteur",haut);

                        else request.getRequestDispatcher("victory.jsp").forward(request, response); 
                    }
        }
        request.getRequestDispatcher("view.jsp").forward(request, response);
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
