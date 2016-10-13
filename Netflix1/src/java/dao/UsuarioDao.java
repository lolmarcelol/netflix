package dao;

import java.util.List;
import model.Usuario;

public interface UsuarioDao {

    public void inserirUsuario(Usuario usuario);
    public void editarUsuario(Usuario usuario);
    public void excluirUsuario(Usuario usuario);
    public List pesquisarUsuario(Usuario usuario);
}
