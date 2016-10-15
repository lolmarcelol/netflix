package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Video {

    private int id;
    private String titulo;
    private Genero genero;
    private Produtora produtora;
    private Categoria categoria;
    private Idioma idioma;
    private Timestamp adicionadosEm;
    private Timestamp produzidoEm;
    private Boolean status;
    
    public Video(){
            
    }
     public Video(int id, String titulo)
    {
     this.id = id;
     this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Produtora getProdutora() {
        return produtora;
    }

    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Timestamp getAdicionadosEm() {
        return adicionadosEm;
    }

    public void setAdicionadosEm(Timestamp adicionadosEm) {
        this.adicionadosEm = adicionadosEm;
    }

    public Timestamp getProduzidoEm() {
        return produzidoEm;
    }

    public void setProduzidoEm(Timestamp produzidoEm) {
        this.produzidoEm = produzidoEm;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
    
    
}
