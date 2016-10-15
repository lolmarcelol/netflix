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
import java.util.List;
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
public class VideoListaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        IVideoManager manager = new VideoManager();
        List<Video> videos;
        videos = manager.getVideos();
        
        request.setAttribute("videos", videos);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/lista_videos.jsp");

        rd.forward(request, response);
    }
}
