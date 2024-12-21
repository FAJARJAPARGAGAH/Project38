import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        linkedlist linkedList = new linkedlist();
        Queue queue = new Queue();
        Stack stack = new Stack();
        Tree tree = new Tree(); // Membuat instance tree untuk pohon prioritas
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n=========== Menu ===========");
            System.out.println("1. Tambah Data Antrian");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cari Antrian Berdasarkan Nama");
            System.out.println("4. Urutkan Antrian Berdasarkan Prioritas");
            System.out.println("5. Hapus Antrian");
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
                    
                    // Menambahkan data ke linked list
                    linkedList.tambahNode(nomorAntrian, nama, layanan, prioritas, waktuMasuk);

                    // Menambahkan data ke tree (pohon prioritas)
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
                    
                    // Tampilkan antrian berdasarkan prioritas
                    tree.displayByPriority();
                    
                    // Konfirmasi apakah pengguna ingin mengeluarkan nasabah dengan prioritas tertinggi
                    System.out.print("\nApakah ingin mengeluarkan dari antrian? (y/n): ");
                    String dequeueChoice = scanner.nextLine();
                    
                    if (dequeueChoice.equalsIgnoreCase("y")) {
                        // Menghapus nasabah dengan prioritas tertinggi
                        PriorityTreeNode dequeuedNode = tree.removeHighestPriority();
                        if (dequeuedNode != null) {
                            System.out.println("Nasabah dengan prioritas tertinggi telah dihapus:");
                            System.out.println("Nomor Antrian: " + dequeuedNode.nomorAntrian);
                            System.out.println("Nama: " + dequeuedNode.nama);
                            stack.push("Dequeue - Nama: " + dequeuedNode.nama);
                        } else {
                            System.out.println("Antrian kosong, tidak ada yang dihapus.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n=========== History ===========");
                    stack.displayHistory();
                    System.out.println("\nIngin melakukan undo? (y/n): ");
                    String undoChoice = scanner.nextLine();
                    if (undoChoice.equalsIgnoreCase("y")) {
                        String undoneAction = stack.undo();
                        if (undoneAction != null) {
                            System.out.println("Undo berhasil: " + undoneAction);
                        }
                    }
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
