/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaw.servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proyectotaw.ejb.TusersFacadeLocal;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Alberto
 */
@WebServlet(name = "AuthenticatorServlet", urlPatterns = {"/auth"})
public class AuthenticatorServlet extends HttpServlet {
    @EJB
    private TusersFacadeLocal tusersFacade;


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
        String username = request.getParameter("user"),
                pass = request.getParameter("pass");
        if (username == null || pass == null){
            request.setAttribute("error", "Username or passowrd is null");
            request.setAttribute("cause", "The username or password wasn't getted correctly.");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }
        Tusers user = tusersFacade.findByDni(username);
        if (user == null) {
            request.setAttribute("cause", "The username " + username + " is not registered");
            request.setAttribute("error", "Username not found");
            getServletContext().getRequestDispatcher("/error.jsp")
                    .forward(request, response);
            return;
        }
        if (!pass.equals(user.getPassword())) {
            request.setAttribute("error", "Password missmatch");
            request.setAttribute("cause", "The password isn't correct");
            getServletContext().getRequestDispatcher("/error.jsp")
                    .forward(request, response);
            return;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/menu").forward(request, response);
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
