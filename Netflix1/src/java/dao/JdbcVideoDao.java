package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Video;

public class JdbcVideoDao implements VideoDao {

    private Connection connection;
    public JdbcVideoDao(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public void inserirVideo(Video video) {
            String query = "INSERT INTO videos ("
                + "titulo,"
                + "adicionadoEm,"
                + "produzidoEm,"
                + "status,"
                + "Produtoras_id,"
                + "Categorias_id,"
                + "Idiomas_id,"
                + "Generos_id )"
                + " VALUES (?,?,?,?,?,?,?,?)";
             PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, video.getTitulo());
            ps.setTimestamp(2, video.getAdicionadosEm());
            ps.setTimestamp(3, video.getProduzidoEm());
            ps.setBoolean(4, video.getStatus());
            ps.setInt(5, video.getProdutora().getId());
            ps.setInt(6, video.getCategoria().getId());
            ps.setInt(7, video.getIdioma().getId());
            ps.setInt(8, video.getGenero().getId());
            
            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }

    @Override
    public void alterarStatusVideo(Video video) { // UPDATE videos SET status=1 WHERE videos.id=1;
        String query = "UPDATE videos SET status="+video.getStatus()+ "WHERE videos.id="+video.getId();
               
             PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);          
            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }

    @Override
    public void editarVideo(Video video) { //UPDATE videos SET status=1, Produtoras_id=2 WHERE videos.id=1;

    String query = "UPDATE videos SET "
                + " titulo=? ,"
                + " adicionadoEm=? ,"
                + " produzidoEm=? ,"
                + " status=? ,"
                + " Produtoras_id=? ,"
                + " Categorias_id=? ,"
                + " Idiomas_id=? ,"
                + " Generos_id=? "
                + " WHERE videos.id="+video.getId();
                
             PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, video.getTitulo());
            ps.setTimestamp(2, video.getAdicionadosEm());
            ps.setTimestamp(3, video.getProduzidoEm());
            ps.setBoolean(4, video.getStatus());
            ps.setInt(5, video.getProdutora().getId());
            ps.setInt(6, video.getCategoria().getId());
            ps.setInt(7, video.getIdioma().getId());
            ps.setInt(8, video.getGenero().getId());
            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public List pesquisarVideoDao(Video video) {
        
         try{
            String query = "select titulo,adicionadoEm,produzidoEm,status,Produtoras_id,Categorias_id,Idiomas_id,Generos_id from mensagens where titulo = " + video.getTitulo();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Video> videos = new ArrayList(1);
            Video videodb = new Video();
            while (rs.next())
            {
                videodb.setTitulo(rs.getString("titulo"));
                videodb.setAdicionadosEm(rs.getTimestamp("adicionadoEm"));
                videodb.setProduzidoEm(rs.getTimestamp("produzidoEm"));
                videodb.setStatus(rs.getBoolean("status"));
                videodb.getProdutora().setId(rs.getInt("Produtoras_id"));
                videodb.getCategoria().setId(rs.getInt("Categorias_id"));
                videodb.getIdioma().setId(rs.getInt("Idiomas_id"));
                videodb.getGenero().setId(rs.getInt("Generos_id"));
                videos.add(videodb);
            }

            return videos;
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }

    @Override
    public List pesquisarAllVideo() {
         try{
            String query = "select titulo,adicionadoEm,produzidoEm,status,Produtoras_id,Categorias_id,Idiomas_id,Generos_id from mensagens";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Video> videos = new ArrayList(1);
            Video videodb = new Video();
            while (rs.next())
            {
                videodb.setTitulo(rs.getString("titulo"));
                videodb.setAdicionadosEm(rs.getTimestamp("adicionadoEm"));
                videodb.setProduzidoEm(rs.getTimestamp("produzidoEm"));
                videodb.setStatus(rs.getBoolean("status"));
                videodb.getProdutora().setId(rs.getInt("Produtoras_id"));
                videodb.getCategoria().setId(rs.getInt("Categorias_id"));
                videodb.getIdioma().setId(rs.getInt("Idiomas_id"));
                videodb.getGenero().setId(rs.getInt("Generos_id"));
                videos.add(videodb);
            }

            return videos;
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }

    @Override
    public void excluirVideo(int video_id) {
        String query = "Delete FROM netflix.videos where id ="+video_id;
                
             PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public Video findVideoId(int id) {
         try{
            String query = "select titulo,adicionadoEm,produzidoEm,status,Produtoras_id,Categorias_id,Idiomas_id,Generos_id from mensagens where id = " + id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            Video videodb = new Video();
            while (rs.next())
            {
                videodb.setTitulo(rs.getString("titulo"));
                videodb.setAdicionadosEm(rs.getTimestamp("adicionadoEm"));
                videodb.setProduzidoEm(rs.getTimestamp("produzidoEm"));
                videodb.setStatus(rs.getBoolean("status"));
                videodb.getProdutora().setId(rs.getInt("Produtoras_id"));
                videodb.getCategoria().setId(rs.getInt("Categorias_id"));
                videodb.getIdioma().setId(rs.getInt("Idiomas_id"));
                videodb.getGenero().setId(rs.getInt("Generos_id"));
            }

            return videodb;
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }    }
    
}
