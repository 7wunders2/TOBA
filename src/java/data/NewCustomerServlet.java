/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.User;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rose
 */
@WebServlet(name = "NewCustomerServlet", urlPatterns = {"/NewCustomerServlet"})
public class NewCustomerServlet extends HttpServlet {

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
            out.println("<title>Servlet NewCustomerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewCustomerServlet at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        /** processRequest(request, response); - temporary comment out*/
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
        else if (action.equals("add")) {                
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            String email = request.getParameter("email");

            String username = lastName + zip;
            String password = "welcome1";
        
            // store data in User object
            User user = new User(firstName, lastName, phone, address, city,
                state, zip, email, username, password);
            
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
           
        // remove this?????
            Enumeration names = session.getAttributeNames();
            while (names.hasMoreElements()) {
                System.out.println((String) names.nextElement());
            }
            
            // validate the parameters
            String message;
            if (firstName == null || lastName == null || email == null ||
                phone == null || address == null || city == null ||
                state == null || zip == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
                phone.isEmpty() || address.isEmpty() || city.isEmpty() ||
                state.isEmpty() || zip.isEmpty()) {
                message = "Please fill out all the form fields.";
                url = "/New_customer.jsp";
                }
             else {
                message = "";
                request.setAttribute("user", user);
                url = "/Success.jsp";
            }
            
           request.setAttribute("message", message);          

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
