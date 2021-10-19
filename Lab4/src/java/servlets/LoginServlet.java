package servlets;

import domain.BankingSystem;
import domain.Customer;
import domain.Account;
import exceptions.LoginException;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        String url = "/index.html";
        String option = request.getParameter("option");
        System.out.println("option = " + option);
        ArrayList <Account> customerAccounts;
        
        if (option.equals("login")) {
            BankingSystem.initialize();
            try {
                String userID = request.getParameter("userID");
                String password = request.getParameter("password");
                Customer customer = BankingSystem.login(userID, password);
                customerAccounts = customer.getAccounts();
                
                session.setAttribute("customer", customer);
                session.setAttribute("customerAccounts", customerAccounts);
                url = "/accountList.jsp";
            }
            
            catch(LoginException e) {
                System.out.println("Login Exception");
                session.setAttribute("message", e.getMessage());
                url = "/login.jsp";
            }
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
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
