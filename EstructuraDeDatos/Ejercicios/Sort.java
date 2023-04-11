package EstructuraDeDatos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sort {
    public int a[];
    public ArrayList<Integer> p = new ArrayList<>();
    public ArrayList<Integer> p1 = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);

    public void datos(int j) {
        a = new int[j];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
    }

    public void sort() {
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            p.add(a[i]);
        }
        int k = 0;
        for (int i = 0; i < p.size(); i++) {
            k=0;
            for (int j = 0; j < a.length; j++) {
                if (p.get(i)>a[j]) {
                    k++;
                }
            }
            p1.add(k);
        }
    }

    public void Imprimir() {
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
        Collections.sort(p1);
        for (int i : p1) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        Sort op = new Sort();
        Scanner sc = new Scanner(System.in);
        int j = sc.nextInt();

        op.datos(j);
        op.sort();
        op.Imprimir();
        sc.close();
    }
}
