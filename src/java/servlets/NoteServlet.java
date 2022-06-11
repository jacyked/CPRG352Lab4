/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Matt
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // GET requests will end up here!
        
        BufferedReader r;
        try{
            ServletContext context = getServletContext();
            InputStream is = context.getResourceAsStream("/WEB-INF/note.txt");
            r = new BufferedReader(new InputStreamReader(is));
            String t = r.readLine();
            
            String c = r.readLine();
            r.close();
            
            Note n = new Note(t, c);
            
            request.setAttribute("title", n.getTitle());
            request.setAttribute("content", n.getContent());
            
        }catch(Exception e){
            System.out.println(e);
            request.setAttribute("error",true);
        }
        // Load a JSP from this servlet
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        // After a JSP has been loaded, stop the code call
        return; // VERY IMPORTANT!
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // POST requests will end up here!
        
        // Capture the incoming parameters from the JSP
        String newtitle = request.getParameter("title");
        String newcontent = request.getParameter("content");
        
        // Validation
        if( newtitle == null || newtitle.equals("") || newcontent == null || newcontent.equals("") ){
            // if validation fails:
            // Set attributes in the request object, to be forwarded to the JSP
            request.setAttribute("title", newtitle);
            request.setAttribute("content", newcontent);
            // use an attribute as a flag to indicate that an error has occured
            request.setAttribute("error",true);
            // load the form once again
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            // after a JSP has been loaded, stop the code call
            return;
        }
        
        // if validation passes:
        // we can safely create a new instance of our object
        Note newnote = new Note(newtitle,newcontent);
        // set the Person object as an attribute in the request object
        request.setAttribute("note", newnote);
       BufferedWriter w;
        try{
            ServletContext context = getServletContext();
            String path = context.getRealPath("/WEB-INF/note.txt");
            w = new BufferedWriter(new FileWriter(path));
            w.write(newnote.getTitle());
            w.newLine();
            w.write(newnote.getContent());
            w.flush();
            w.close();
            
        }catch(Exception e){
            System.out.println(e);
            request.setAttribute("error",true);
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            // after a JSP has been loaded, stop the code call
            return;
        }
        // Load the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        // Stop the code call after loading a JSP
        return;
    }
}
