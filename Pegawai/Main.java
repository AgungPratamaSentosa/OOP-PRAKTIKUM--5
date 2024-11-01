package Pegawai;

public class Main {
    public static void main(String[] args) {
        // Membuat objek Manager
        Manager manager = new Manager("Agung",1000000,1500000);
        manager.cetakInfo();
        System.out.println();

        // Membuat objek Programmer
        Programmer programmer = new Programmer("Yoga",2000000,2500000);
        programmer.cetakInfo();
    }
}
