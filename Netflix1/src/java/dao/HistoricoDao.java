package dao;

import java.util.List;
import model.Historico;
import model.Usuario;
import model.Video;

public interface HistoricoDao {
    
    public void registrarVisualizacao(Video video, Usuario usuario);
    public List pesquisarVisualizacao(Usuario usuario);
    public void registrarRating(Video video,Usuario usuario,int rating);
    public float obterRating(Video video);
   
}
