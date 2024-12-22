import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        linkedlist linkedList = new linkedlist();
        Stack stack = new Stack();
        Tree tree = new Tree(); 
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("========================================================");
            System.out.println("|                           Qzy                         ");
            System.out.println("========================================================");
            System.out.println("=========== Menu ===========");
            System.out.println("1. Tambah Data Antrian");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cari Antrian Berdasarkan Nama");
            System.out.println("4. Urutkan Antrian Berdasarkan Prioritas");
            System.out.println("5. Keluarkan Antrian");
            System.out.println("6. Tampilkan History");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int nomorAntrian = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Layanan: ");
                    String layanan = scanner.nextLine();
                    System.out.print("Apakah Prioritas (Iya/Tidak): ");
                    String prioritas = scanner.nextLine();
                    String waktuMasuk = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd"));                    
                    linkedList.tambahNode(nomorAntrian, nama, layanan, prioritas, waktuMasuk);
                    tree.addCustomer(nomorAntrian, nama, layanan, prioritas, waktuMasuk);
                    stack.push("Tambah Antrian - Nama: " + nama);
                    System.out.println("Data berhasil ditambahkan.");
                    break;

                case 2:
                    linkedList.display();
                    break;

                case 3:
                    System.out.print("Masukkan Nama untuk Pencarian: ");
                    String searchName = scanner.nextLine();
                    Node foundNode = linkedList.searchByName(searchName);
                    if (foundNode != null) {
                        System.out.println("Data ditemukan: \n" +
                                "Nomor Antrian: " + foundNode.nomorAntrian + "\n" +
                                "Nama: " + foundNode.nama + "\n" +
                                "Layanan: " + foundNode.layanan + "\n" +
                                "Prioritas: " + foundNode.prioritas + "\n" +
                                "Waktu Masuk: " + foundNode.waktuMasuk);
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("Menampilkan Antrian Berdasarkan Prioritas:");
                    tree.displayByPriority();
                    break;
                case 5: 
                    System.out.println("Mengeluarkan Antrian:");
                    System.out.println("========================================================");
                    Node removedNode = linkedList.dequeue(stack);
                    linkedList.display();
                    break;
                case 6:
                    System.out.println("\n=========== History ===========");
                    stack.displayHistory();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            
        } while (choice != 0);
        
        scanner.close();
    }
}
