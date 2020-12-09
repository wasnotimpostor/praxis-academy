package inheritance;

public class PersegiPanjang extends BangunDatar {
    float panjang;
    float lebar;

    @Override
    float luas() {
        float luas = panjang * lebar;
        System.out.println("Luas persegi panjang = " + luas);
        return luas;
    }

    @Override
    float keliling() {
        float keliling = 2*panjang + 2*lebar;
        System.out.println("Keliling persegi panjang = " + keliling);
        return keliling;
    }
}
