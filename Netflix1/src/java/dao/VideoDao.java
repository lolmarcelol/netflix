package dao;

import java.util.List;
import model.Video;

public interface VideoDao {

    public void inserirVideo(Video video);
    public void alterarStatusVideo(Video video);
    public void editarVideo(Video video);
    public List pesquisarVideoDao(Video video);
    public List pesquisarAllVideo();
    public void excluirVideo(int video_id);
    
}
