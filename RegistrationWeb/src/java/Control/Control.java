/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interfaces.AuthDBIF;
import Interfaces.AuthIF;
import Interfaces.RegIF;
import Model.AuthService;
import Model.AuthServiceDB;
import Model.RegistratedUsers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RolfMoikjær
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            AuthIF auth = new AuthService();
            AuthDBIF au = new AuthServiceDB();
            RegIF rusers = new RegistratedUsers();
            String origin = request.getParameter("origin");

            switch (origin) {
                case "Registration":
                    String name;
                    String id;
                    String pwd;
                    String gender;
                    String age;
                    String country;

                    name = request.getParameter("name");
                    id = request.getParameter("id");
                    pwd = request.getParameter("pwd");
                    gender = request.getParameter("gender");
                    age = request.getParameter("age");
                    country = request.getParameter("country");

                    rusers.authCheck(name, id, pwd, gender, age, country);
                    rusers.addUser(name, id, pwd, gender, age, country);
                    request.getSession().setAttribute("name", name);
                    response.sendRedirect("Succes.jsp");

                    return;
                case "Login":
                    String id1;
                    String pwd1;

                    id1 = request.getParameter("id");
                    pwd1 = request.getParameter("pwd");

                    auth.authCheck(id1, pwd1);
                    String name1 = auth.getUser(id1).getName();
                    request.getSession().setAttribute("name", name1);
                    response.sendRedirect("Succes.jsp");

                    return;
                case "ListUsers":
                    request.getSession().setAttribute("users", au.getAllUsers());
                    response.sendRedirect("ListUsers.jsp");
                    return;
                case "ShowUsers":
                    request.getSession().setAttribute("List", au.getAllUsers());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ShowUsers.jsp");
                    request.setAttribute("users", au.getAllUsers());
                    dispatcher.forward(request, response);
            }
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
