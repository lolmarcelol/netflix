/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Video;

/**
 *
 * @author Usuario
 */
public class VideoManager implements IVideoManager {
    
    private static List <Video> videos;
    

    public VideoManager(){
        
        this.videos = new ArrayList();
        Video p1 = new Video();
        p1.setId(1);
        p1.setTitulo("ffagito");

        Video p2 = new Video(2,"iambread");
        
        Video p3 = new Video (3, "rocketleague");
        
        videos.add(p1);
        videos.add(p2);
        videos.add(p3);
        
    }
            
    public List <Video> getVideos() {
        return videos;
    }

    public void setVideos(List videos) {
        this.videos = videos;
    }
    
    @Override
     public Video obterPorId(int id){
       for(Video video : videos){
           if(video.getId() == id)
               return video;
       }
       return null;
       
   }
    
    
}