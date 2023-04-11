package EstructuraDeDatos.Ejercicios;

public class Libro extends Biblioteca{
    //Atributos
    private String nombreLibro;
    private String autor;
    private int numeroPaginas;

    //Constructor
    public Libro(String nombreLibro, String autor, int numeroPaginas) {
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }
    
    //Getters
    public String getAutor() {
        return autor;
    }
    public String getNombreLibro() {
        return nombreLibro;
    }
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
}
