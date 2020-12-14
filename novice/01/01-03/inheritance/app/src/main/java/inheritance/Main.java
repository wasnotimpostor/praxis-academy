package inheritance;

public class Main {
    public static void main(String[] args) {
        // membuat objek bangun datar
        BangunDatar bangunDatar = new BangunDatar();

        // membuat objek persegi
        Persegi persegi = new Persegi();
        persegi.sisi = 2;

        // membuat objek lingkaran
        Lingkaran lingkaran = new Lingkaran();
        lingkaran.r = 22;

        // membuat objek persegi panjang
        PersegiPanjang persegiPanjang = new PersegiPanjang();
        persegiPanjang.panjang = 4;
        persegiPanjang.lebar = 5;

        // membuat objek segitiga
        Segitiga mSegitiga = new Segitiga();
        mSegitiga.tinggi = 10;
        mSegitiga.alas = 2;

        // memanggil method luas dan keliling
        bangunDatar.luas();
        bangunDatar.keliling();

        persegi.luas();
        persegi.keliling();

        persegiPanjang.luas();
        persegiPanjang.keliling();

        lingkaran.luas();
        lingkaran.keliling();

        mSegitiga.luas();
        mSegitiga.keliling();
    }
}
