package kasus;

public class Main {
    public static void main(String[] args) {
        // objek dari kasir
        Kasir kasir = new Kasir();

        Baju baju = new Baju();
        baju.hargaBaju = 150000;
        baju.jumlahBaju = 15;

        Celana celana = new Celana();
        celana.hargaCelana = 235000;
        celana.jumlahCelana = 12;

        // manggil method total harga
        kasir.totalHarga();
        baju.totalHarga();
        celana.totalHarga();
    }   
}
