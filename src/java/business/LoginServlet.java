/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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
 * @author Rose
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet","/login"})
public class LoginServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        /** processRequest(request, response); */
               String url = "/index.html";

        // get current action
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "signin";  // default action
        }
         // perform action and set URL to appropriate page
        if (action.equals("signin")) {
            url = "/index.html";    // the "join" page
        }
        else if (action.equals("authorize")) {                
            // get parameters from the request
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            // validate the parameters
            String message;
            if (username.equals("jsmith@toba.com") && 
                    password.equals("letmein"))
                {
                // Add a make believe user to session scope so that Account_activity will recognize
                User user = new User("John", "Smith", "999-999-9999", "123 Bogus Lane", "Clearwater",
                    "FL", "98765", "jsmith@toba.com", "smith98765", "letmein");
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                url = "/Account_activity.jsp";
            }
            else
            {
                url = "/Login_failure.jsp";
            }
        }
        else if (action.equals("pw_reset")) {
            String password = request.getParameter("password");
            HttpSession session = request.getSession();
                        
            User user = (User) session.getAttribute("user");
            session.setAttribute("password", password); 
            session.setAttribute("user", user);   
            url = "/Account_activity.jsp";   
         }
        
        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
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
