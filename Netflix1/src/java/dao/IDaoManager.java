package dao;

import java.util.ArrayList;

public interface IDaoManager 
{
    void iniciar();
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    VideoDao getVideoDao();
    UsuarioDao getUsuarioDao();
}