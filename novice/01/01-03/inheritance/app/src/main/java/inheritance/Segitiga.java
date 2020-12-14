package inheritance;

public class Segitiga extends BangunDatar {
    float alas;
    float tinggi;

    @Override
    float luas() {
        float luas = (alas * tinggi) / 2;
        System.out.println("Luas segitiga : " + luas);
        return luas;
    }
}
