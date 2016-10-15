package dao;

import java.util.ArrayList;
import java.util.List;
import model.Video;

public interface IDaoManager 
{
    void iniciar();
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    VideoDao getVideoDao();
    UsuarioDao getUsuarioDao();
    HistoricoDao getHistoricoDao();
}