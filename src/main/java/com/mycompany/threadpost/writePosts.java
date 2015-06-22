package com.mycompany.threadpost;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.threadpost.Post;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mormon
 */
@WebServlet(urlPatterns = {"/writePosts"})
public class writePosts extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        String user = session.getAttribute("name").toString();
        String post = request.getParameter("post");
        Date date  = new Date();
        Post pPost = new Post(post, user, date.toString());
        request.setAttribute("thePost", pPost);
        
        //String path = "C:\\Users\\mormon\\Documents\\NetBeansProjects\\threadPost\\src\\main\\java\\com\\mycompany\\threadpost\\posts.txt";
        String dir = System.getenv("OPENSHIFT_DATA_DIR");
        String path = "/posts.txt";
        String fullPath = dir + path;
        try {
            FileWriter write = new FileWriter(fullPath, true);
            String fileQuery = user + "," + post + "," + date + "\n";
            write.write(fileQuery);
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("posts", new PostDataHandler().getPosts());
        request.getRequestDispatcher("ShowPost").forward(request, response);
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
