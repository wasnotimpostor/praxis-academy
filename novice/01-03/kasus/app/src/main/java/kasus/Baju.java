package kasus;
import java.util.Arrays;

public class Baju extends Kasir {
    int hargaBaju;
    int jumlahBaju;

    @Override
    int totalHarga() {
        int totalHarga = hargaBaju * jumlahBaju;
        System.out.println("Total harga baju yg harus dibayar = " + totalHarga);
        return totalHarga;
    }
}
