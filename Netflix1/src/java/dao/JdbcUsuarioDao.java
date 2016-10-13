package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class JdbcUsuarioDao implements UsuarioDao {

    private Connection connection;
    
    public JdbcUsuarioDao(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public void inserirUsuario(Usuario usuario) {
        String query = "INSERT INTO usuarios ("
                + "login,"
                + "senha,"
                + "nome,"
                + "cpf )"
                + " VALUES (?,?,?,?)";
             PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNome());
            ps.setInt(4, usuario.getCpf());
                        
            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        
    String query = "UPDATE usuarios SET "
                + " login=? ,"
                + " senha=? ,"
                + " nome=? ,"
                + " cpf=? "
                + " WHERE videos.id="+usuario.getId();
                
             PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNome());
            ps.setInt(4, usuario.getCpf());
            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public void excluirUsuario(Usuario usuario) {
        String query = "Delete FROM netflix.usuarios where id ="+usuario.getId();
             PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public List pesquisarUsuario(Usuario usuario) {
         try{
            String query = "select login,nome,cpf from usuarios where id = " + usuario.getId();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Usuario> usuarios = new ArrayList(1);
            Usuario usuariodb = new Usuario();
            while (rs.next())
            {
                usuariodb.setLogin(rs.getString("login"));
                usuariodb.setNome(rs.getString("nome"));
                usuariodb.setCpf(rs.getInt("cpf"));
                usuarios.add(usuariodb);
            }

            return usuarios;
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }
    
}
