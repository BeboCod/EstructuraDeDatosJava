package EstructuraDeDatos.Ejercicios;

import java.util.Scanner;

public class Cliente {
    Scanner sc = new Scanner(System.in);
    public String nombre;
    public int edad;
    public String direccion;
    public String curp;
    public String rfc;
    public char sexo;

    public Cliente(String nombre, int edad, String direccion, String curp, String rfc, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.curp = curp;
        this.rfc = rfc;
        this.sexo = sexo;
    }
}
