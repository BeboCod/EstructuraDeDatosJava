package EstructuraDeDatos.Ejercicios;

public class MetodosSueltosAleatorios {
    private String[] nom = { 
    "El señor de los anillos", 
    "La tinta",
    "Wigetta 1",
    "Wigetta 2",
    "Wigetta 3",
    "Wigetta 4",
    "Wigetta 5",
    "Wigetta 6",
    "Wigetta 7",
    "Wigetta Final", 
    "El principito", 
    "El diario de Ana Frank", 
    "El libro del ligue",
    "It", 
    "Matematicas avanzadas",
    "Fisica avanzada",
    "Quimica avanzada",
    "Harry Potter 1",
    "Harry potter 2",
    "Harry potter 3",
    "Harry potter 4",
    "Harry potter 5",
    "Harry potter 6",
    "Harry potter 7 Part I",
    "Harry potter 7 Part II"
}; 

    private String[] aut = {
        "Manolo",
        "Chris",
        "Martin",
        "Marta",
        "Vanesa",
        "Violeta",
        "Elli",
        "Pedro",
        "Juan",
        "Gloria",
        "Alejandro",
        "Braulio",
        "Rodrigo",
        "Pera",
        "Vere",
        "Avelino",
        "Higgs",
        "Silvestre",
        "Dalas",
        "Stephen",
        "Maria",
        "Teresa",
        "Enrique",
        "Sam",
        "Wilson",
        "Joel",
        "Steve",
        "Valeria",
        "Madelein",
        "Tania",
        "Ulises",
        "Jesus",
        "Antonio",
        "Carlos",
        "German",
        "Cesar",
        "Luis",
        "Manuel",
        "Sergay",
        "Mattew",
        "Nelson",
        "Peter",
        "Harry",
        "Tony",
        "Antoni",
    };

    public Object[] nombresLibrosAleatorios() {
        Object dat[] = new Object[3];
            dat[0] = nom[(int)Math.floor(Math.random()*(25))];
            dat[1] = aut[(int)Math.floor(Math.random()*(44))];
            dat[2] = (int)Math.floor(Math.random()*(500-25)+25);
        return dat;
    }

    /*public static void main(String[] args) {
        Nombres op = new Nombres();
        for (int i = 0; i < op.nombresLibrosAleatorios().length; i++) {
            System.out.println(op.nombresLibrosAleatorios()[i]);
        }
    }*/
}
