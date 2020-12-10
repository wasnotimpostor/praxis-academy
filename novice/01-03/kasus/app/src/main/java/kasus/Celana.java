package kasus;

public class Celana extends Kasir {
    int hargaCelana;
    int jumlahCelana;

    @Override
    int totalHarga() {
        int totalHarga = hargaCelana * jumlahCelana;
        System.out.println("Total harga celana yg harus dibayar = " + totalHarga);
        return totalHarga;
    }
}
