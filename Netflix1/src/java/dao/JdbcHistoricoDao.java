package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Historico;
import model.Usuario;
import model.Video;

public class JdbcHistoricoDao implements HistoricoDao {

    private Connection connection;
    
    public JdbcHistoricoDao(Connection conexão) {
        this.connection = conexão;
    }

    @Override
    public void registrarVisualizacao(Video video, Usuario usuario) {
            String query = "INSERT INTO historicos ("
                + "Usuarios_id,"
                + "Videos_id,"
                + "assistidoEm )"
                + " VALUES (?,?,NOW())";
             PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1, usuario.getId());
            ps.setInt(2, video.getId());
            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }

    @Override
    public List pesquisarVisualizacao(Usuario usuario) {
        
        try{
            ArrayList<Historico> historicos = new ArrayList(1);
            String query = "SELECT Videos_id,assistidoEm FROM historicos where rating is null and  Usuarios_id=" + usuario.getId();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            JdbcDaoManager video = new JdbcDaoManager();
            while (rs.next())
            {
            Historico historicodb = new Historico();
            Video videodb;
            videodb = video.getVideoDao().findVideoId(rs.getInt("Videos_id"));
            historicodb.setAssistidoEm(rs.getTimestamp("assistidoEm"));
            historicodb.setUsuario(usuario);
            historicodb.setVideo(videodb);
            historicos.add(historicodb);
            }

            return historicos;
        } catch(Exception ex){
            throw new DaoException("Erro ao inserir cliente no banco de dados");
            
        }
    }

    @Override
    public void registrarRating(Video video, Usuario usuario, int rating) {
            String query = "INSERT INTO historicos ("
                + "Usuarios_id,"
                + "Videos_id,"
                + "rating )"
                + " VALUES (?,?,?))";
             PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1, usuario.getId());
            ps.setInt(2, video.getId());
            ps.setInt(3, rating);

            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }

    @Override
    public float obterRating(Video video) {
        try{
            String query = "SELECT avg(rating) as media FROM netflix.historicos where rating is not null and Videos_id =" + video.getId();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            float media =0; 
            while (rs.next())
            {
            media = rs.getFloat("media");            
            }

            return media;
        } catch(Exception ex){
            throw new DaoException("Erro ao inserir cliente no banco de dados");
            
        }    }


    
}
