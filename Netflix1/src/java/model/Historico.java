package model;

import java.sql.Timestamp;

public class Historico {

    private Timestamp assistidoEm;
    private int rating;
    private String comentario;
    private Usuario usuario;
    private Video video;
    
    public Historico(){
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
       
    public Timestamp getAssistidoEm() {
        return assistidoEm;
    }

    public void setAssistidoEm(Timestamp assistidoEm) {
        this.assistidoEm = assistidoEm;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
