package Biblioteca;

import java.io.Serializable;

public class Libro implements Serializable{
    private int codigo;
    private String titulo;
    private String autor;
    private int añoEd;
    private String genero;
    private String editorial;
    private int numPaginas;
    private boolean fisico;
    private int numFisicos;
    private boolean exclusivo;

    public Libro(String titulo,String autor,int  añoEd, String genero, String editorial,int  codigo, int numPaginas, boolean fisico, int numFisicos, boolean exclusivo){
        this.titulo = titulo;
        this.autor = autor;
        this.añoEd = añoEd;
        this.genero = genero;
        this.editorial = editorial;
        this.codigo = codigo;
        this.numPaginas = numPaginas;
        this.fisico = fisico;
        if(fisico){
            this.numFisicos = numFisicos;
        }
        else{
            this.numFisicos = 0;
        }
        this.exclusivo = exclusivo;
    }

    @Override
    public String toString() {
        String disponible;
        if(fisico){
            disponible = "Si";
        }
        else{
            disponible = "No";
        }
        return "Codigo: " + codigo + " Titulo: " + titulo + " Autor: " + autor + "Publicación: " + añoEd + " Genero: " + genero + " Editorial: " + editorial + " Numero de Paginas: " +numPaginas + " Disponible Fisico: " + disponible + " Cantidad: " + numFisicos;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAñoEd() {
        return añoEd;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAñoEd(int añoEd) {
        this.añoEd = añoEd;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setExclusivo(boolean exclusivo) {
        this.exclusivo = exclusivo;
    }

    public void setFisico(boolean fisico) {
        this.fisico = fisico;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNumFisicos(int numFisicos) {
        this.numFisicos = numFisicos;
    }


    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void datosRelevantes(){
        System.out.println("Titulo: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("Año publicación: " + añoEd);
    }

}




