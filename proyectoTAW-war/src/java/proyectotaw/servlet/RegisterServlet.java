/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyectotaw.ejb.TUsersFacade;
import proyectotaw.entity.TRoles;
import proyectotaw.entity.TUsers;

/**
 *
 * @author infernage
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @EJB
    private TUsersFacade tUsersFacade;

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
        TUsers user = (TUsers) request.getSession().getAttribute("user");
        if (user != null && (user.getRol().getId() == 0 || user.getRol().getId() == 1)) {
            String name = (String) request.getParameter("name"),
                    appell = (String) request.getParameter("appell"),
                    dni = (String) request.getParameter("dni"),
                    addr = (String) request.getParameter("address");
            System.out.println(name);
            System.out.println(appell);
            System.out.println(dni);
            System.out.println(addr);
            if (name != null && appell != null && dni != null && addr != null) {
                TUsers register = new TUsers(tUsersFacade.count());
                register.setRol(new TRoles(request.getParameter("type") == null ? 2
                        : request.getParameter("type").equals("admin") ? 0
                        : request.getParameter("type").equals("medic") ? 1 : 2));
                register.setName(name + " " + appell);
                register.setAddress(addr);
                register.setDni(dni);
                register.setUsername(dni);
                register.setPassword(name + "_" + dni);
                register.setNuhsa("");
                tUsersFacade.create(register);
                response.sendRedirect(getServletContext().getContextPath() + "/menu.jsp");
            } else {
                request.setAttribute("cause", "Some fields aren't filled.");
                request.setAttribute("error", "NullPointerException");
                getServletContext().getRequestDispatcher("/error.jsp")
                        .forward(request, response);
            }
        } else{
            request.setAttribute("cause", "You are not allowed to enter into this page");
            request.setAttribute("error", "TUser object null or ID unknown");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
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
