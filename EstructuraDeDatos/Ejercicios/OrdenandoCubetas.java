package EstructuraDeDatos;

import java.util.Arrays;
import java.util.Scanner;

public class OrdenandoCubetas {
    int[] cubetas;
    int[] ncub;
    int m;
    int n;
    Scanner sc = new Scanner(System.in);

    public OrdenandoCubetas(int m, int n){
        this.m = m;
        this.n = n;
        Ordenamiento(m);
    }
    
    public void Ordenamiento(int m) {
        int o=0;
        cubetas = new int[m];
        ncub = new int[n];
        for (int i = 0; i < m; i++) {
            do {
                o = sc.nextInt();
            } while (o>n);
            cubetas[i] = o;
        }
        Arrays.sort(cubetas);
        int k = 0;
        for (int i = 0; i < ncub.length; i++) {
            k=0;
            for (int j = 0; j < cubetas.length; j++) {
                if (cubetas[j] == (i+1)) {
                    k++;
                }
            }
            ncub[i] = k;
        }
    }

    public void Imprimr() {
        for (int i = 0; i < ncub.length; i++) {
            System.out.print((i+1)+": "+ncub[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        OrdenandoCubetas op = new OrdenandoCubetas(m, n);
        op.Imprimr();
        sc.close();
    }
}
