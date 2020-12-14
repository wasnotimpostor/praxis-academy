import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        int baris, kolom;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Jumlah baris : ");
        baris = scanner.nextInt();

        System.out.print("Jumlah kolom : ");
        kolom = scanner.nextInt();
        
        int[][] matrix = new int[baris][kolom];

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print("Masukan isi baris ke " + i + " kolom ke "+j+" : ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
        System.out.println("Bentuk Matriks");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
