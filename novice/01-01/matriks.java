import java.util.Scanner;

public class matriks {
    public static void main(String[] args) {
        int[][] contoh = new int [5][5];

        contoh[2][2] = 1;
        for (int i = 1; i < 4; i++){
            contoh[i][3] = 1;
        }
        for (int i = 0; i < 5; i++){
            contoh[i][4] = 1;
        }
        for (int j = 0; j < contoh.length; j++) {
            for (int i = 0; i < contoh.length; i++) {
                System.out.print(contoh[i][j]);
            }
            System.out.println();
        }
    }
}