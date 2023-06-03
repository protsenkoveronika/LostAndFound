/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.web;

import com.example.model.ExpItem;
import com.example.services.ExpItemManager;
import com.example.model.Item;
import com.example.services.ItemManager;
import com.example.model.User;
import com.example.services.UserManager;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author user
 */
@WebServlet(name = "Servlet", urlPatterns = {"/do/*"})
public class Servlet extends HttpServlet {
    
    private ItemManager itemManager;
    private ExpItemManager expItemManager;

    @Override
    public void init() throws ServletException {
        super.init();
        itemManager = new ItemManager();
        expItemManager = new ExpItemManager();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            pathInfo = "/";
        }
        try {
            switch (pathInfo) {
                case "/loginpage":
                    loginpage(request, response);
                    break;
                case "/login":
                    login(request, response);
                    break;
                case "/signup":
                    signup(request, response);
                    break;
                case "/catalog":
                    catalog(request, response);
                    break;
                case "/expensive":
                    expensive(request, response);
                    break;
                case "/addpage":
                    addpage(request, response);
                    break;
                case "/add":
                    add(request, response);
                    break;
                case "/item.jsp":
                    item(request, response);
                    break;
                case "/expitem.jsp":
                    expitem(request, response);
                    break;
                case "/delete":
                    delete(request, response);
                    break;
                case "/search":
                    search(request, response);
                    break;
                default:
                    break;
            }
        } catch (RuntimeException ex) {
            error(request, response, "Oops, " + ex.getMessage());
        }

    }
    
    protected void loginpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }
    
    private int oklogin = 0;
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        UserManager userManager = new UserManager();
        User user = userManager.findUserByLogin(login);

        if (user == null) {
            error(request, response, "Sorry, user with login '" + login + "' does not exist");
            return;
        }

        if (!userManager.checkPassword(user, password)) {
            error(request, response, "Sorry, wrong password");
            return;
        }

        // Successful login
        oklogin = 1;
        
        ExpItemManager expitemManager = new ExpItemManager();
        List<ExpItem> explostItems = expitemManager.getExpLostItems();
        List<ExpItem> expfoundItems = expitemManager.getExpFoundItems();

        request.setAttribute("explostItems", explostItems);
        request.setAttribute("expfoundItems", expfoundItems);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/expensive.jsp");
        dispatcher.forward(request, response);
    }
    
    private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        UserManager userManager = new UserManager();
        
        User existingUser = userManager.findUserByLogin(login);
        if (existingUser != null) {
            error(request, response, "User already exists.");
            return;
        }
        
        if (name == "" || surname == "" || login == "" || password == "") {
            error(request, response, "Sorry, you must fill each field in sign up form.");
            return;
        }

        int id = userManager.getLargestUserId() + 1;

        User newUser = new User(id, name, surname, login, password);
        userManager.addUser(newUser);
        
        oklogin = 1;
        
        ExpItemManager expitemManager = new ExpItemManager();
        List<ExpItem> explostItems = expitemManager.getExpLostItems();
        List<ExpItem> expfoundItems = expitemManager.getExpFoundItems();

        request.setAttribute("explostItems", explostItems);
        request.setAttribute("expfoundItems", expfoundItems);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/expensive.jsp");
        dispatcher.forward(request, response);
    }
    
    private void catalog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> lostItems = itemManager.getLostItems();
        List<Item> foundItems = itemManager.getFoundItems();

        request.setAttribute("lostItems", lostItems);
        request.setAttribute("foundItems", foundItems);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/catalog.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void expensive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (oklogin==0) {
            error(request, response, "Sorry, you need to log in");
            return;
        }
        
        List<ExpItem> explostItems = expItemManager.getExpLostItems();
        List<ExpItem> expfoundItems = expItemManager.getExpFoundItems();

        request.setAttribute("explostItems", explostItems);
        request.setAttribute("expfoundItems", expfoundItems);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/expensive.jsp");
        dispatcher.forward(request, response);
    }
    
    private void addpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        request.setAttribute("type", type);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add.jsp");
        dispatcher.forward(request, response);
    }
    
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String contact = request.getParameter("contact");
        String type = request.getParameter("type");
        
        if (name == "" || name == " ") {
            error(request, response, "Sorry, at least the item name must be entered.");
            return;
        }
        
        int largestId = Math.max(itemManager.getLargestId(), expItemManager.getLargestId());

        int nextId = largestId + 1;

        if (type.equals("lost")) {
            Item item = new Item(nextId, name, description, contact);
            itemManager.addLostItem(item);
            response.sendRedirect("catalog");
        } else if (type.equals("found")) {
            Item item = new Item(nextId, name, description, contact);
            itemManager.addFoundItem(item);
            response.sendRedirect("catalog");
        } else if (type.equals("explost")) {
            ExpItem expItem = new ExpItem(nextId, name, description, contact);
            expItemManager.addExpLostItem(expItem);
            response.sendRedirect("expensive");
        } else if (type.equals("expfound")) {
            ExpItem expItem = new ExpItem(nextId, name, description, contact);
            expItemManager.addExpFoundItem(expItem);
            response.sendRedirect("expensive");
        }
    }
    
    private void item(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("id"));
        
        Item item = itemManager.getItemById(itemId);

        if (item != null) {
            request.setAttribute("item", item);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
            dispatcher.forward(request, response);
        } else {
            error(request, response, "Item not found");
        }
        
    }
    
    private void expitem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("id"));
        
        ExpItem item = expItemManager.getExpItemById(itemId);

        if (item != null) {
            request.setAttribute("item", item);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
            dispatcher.forward(request, response);
        } else {
            error(request, response, "Item not found");
        }
    }
        
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        
        Item item = itemManager.getItemById(itemId);
        ExpItem expItem = expItemManager.getExpItemById(itemId);

        if (item != null) {
            itemManager.getLostItems().remove(item);
            itemManager.getFoundItems().remove(item);
            response.sendRedirect("catalog");
        } else if (expItem != null) {
            expItemManager.getExpLostItems().remove(expItem);
            expItemManager.getExpFoundItems().remove(expItem);
            response.sendRedirect("expensive");
        } else{
            error(request, response, "Item not found");
        }
    }
    
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String searchText = request.getParameter("info");
        
        List<Item> lostItems = itemManager.getLostItems();
        List<Item> foundItems = itemManager.getFoundItems();
        List<ExpItem> explostItems = expItemManager.getExpLostItems();
        List<ExpItem> expfoundItems = expItemManager.getExpFoundItems();

        if (type.equals("lost")) {
            List<Item> searchResults = itemManager.searchLostItems(searchText);
            request.setAttribute("lostItems", searchResults); 
            request.setAttribute("foundItems", foundItems); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/catalog.jsp");
            dispatcher.forward(request, response);
        } else if (type.equals("found")) {
            List<Item> searchResults = itemManager.searchFoundItems(searchText);
            request.setAttribute("lostItems", lostItems);
            request.setAttribute("foundItems", searchResults);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/catalog.jsp");
            dispatcher.forward(request, response);
        } else if (type.equals("explost")) {
            List<ExpItem> searchResults = expItemManager.searchExpLostItems(searchText);
            request.setAttribute("explostItems", searchResults);
            request.setAttribute("expfoundItems", expfoundItems);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/expensive.jsp");
            dispatcher.forward(request, response);
        } else if (type.equals("expfound")) {
            List<ExpItem> searchResults = expItemManager.searchExpFoundItems(searchText);
            request.setAttribute("explostItems", explostItems);
            request.setAttribute("expfoundItems", searchResults);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/expensive.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    protected void error(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
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
