package Biblioteca;

public class Libro {
    private int codigo;
    private String titulo;
    private String autor;
    private int añoEd;
    private String genero;
    private String editorial;
    private int numPaginas;
    private boolean fisico;
    private int numFisicos;

    public Libro(String titulo,String autor,int  añoEd, String genero, String editorial,int  codigo, int numPaginas, boolean fisico, int numFisicos){
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

}




