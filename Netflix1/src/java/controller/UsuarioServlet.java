/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import java.text.ParseException;


/**
 *
 * @author Usuario
 */
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/usuario_form.jsp");
        rd.forward(request,response);
    }
    
    //Usar quando clicar no botao enviar 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("Nome"));
        String cpfAux = request.getParameter("CPF");
        
        int cpf = Integer.parseInt(cpfAux);
        usuario.setCpf(cpf);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            String dataAux = request.getParameter("DataNascimento");
            Date data;
            data = sdf.parse(request.getParameter("DataNascimento"));

        }

        
        
        catch(ParseException ex){
            //Logger.getLogger(ClienteServlet.class.getName().log())
        }
        
        usuario.setLogin(request.getParameter("Login"));
        usuario.setPassword(request.getParameter("Password"));

        
        
    }
    

}
