/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IVideoManager;
import dao.VideoManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Video;

/**
 *
 * @author Usuario
 */
public class VideoDetalhe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id;
        String idParam;
        idParam = request.getParameter("id");
        id = Integer.parseInt(idParam);
        
        IVideoManager manager = new VideoManager();
        Video video;
        video = manager.obterPorId(id);
        
        request.setAttribute("videos", video);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/video_detalhe.jsp");

        rd.forward(request, response);
    }
}
