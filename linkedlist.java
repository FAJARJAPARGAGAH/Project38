public class linkedlist {
    Node head;
    Node tail;
    
    public void bar(){
        System.out.println("========================================================");
        System.out.println("|                           Qzy                         ");
        System.out.println("--------------------------------------------------------");
        System.out.println("|                 Silahkan Antri Disini                 ");
        System.out.println("========================================================");
    }

    public void tambahNode(int nomorAntrian, String nama, String layanan, int prioritas, String waktuMasuk) {
        Node newNode = new Node(nomorAntrian, nama, layanan, prioritas, waktuMasuk);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display(){
        Node current = head;
        if (head == null) {
            System.out.println("Mohon maaf, data masih kosong!");
        } else {
            System.out.println("| No. Antrian | Nama | Layanan | Prioritas | Waktu Masuk |");
            System.out.println("---------------------------------------------------------");
            while (current != null) {
                System.out.println("| " + current.nomorAntrian + " | " + current.nama + " | " + current.layanan + " | " + current.prioritas + " | " + current.waktuMasuk + " |");
                System.out.println("---------------------------------------------------------");
                current = current.next;
            }
        }
    }

    public Node searchByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.nama.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void sortByPriority() {
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            while (nextNode != null) {
                if (current.nomorAntrian > nextNode.nomorAntrian) {
                    int tempNomorAntrian = current.nomorAntrian;
                    String tempNama = current.nama;
                    String tempLayanan = current.layanan;
                    int tempPrioritas = current.prioritas;
                    String tempWaktuMasuk = current.waktuMasuk;

                    current.nomorAntrian = nextNode.nomorAntrian;
                    current.nama = nextNode.nama;
                    current.layanan = nextNode.layanan;
                    current.prioritas = nextNode.prioritas;
                    current.waktuMasuk = nextNode.waktuMasuk;

                    nextNode.nomorAntrian = tempNomorAntrian;
                    nextNode.nama = tempNama;
                    nextNode.layanan = tempLayanan;
                    nextNode.prioritas = tempPrioritas;
                    nextNode.waktuMasuk = tempWaktuMasuk;
                }
                nextNode = nextNode.next;
            }
            current = current.next;
        }
    }

    public void displaySortedQueue() {
        Node current = head;
        System.out.println("Hasil Sorting Berdasarkan Prioritas:");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-15s %-10s %-20s %-10s\n", "Nomor Antrian", "Nama", "Layanan", "Prioritas");
        System.out.println("-------------------------------------------------------");
        while (current != null) {
            System.out.printf("%-15d %-10s %-20s %-10d\n",
                    current.nomorAntrian,
                    current.nama,
                    current.layanan,
                    current.prioritas);
            current = current.next;
        }
        System.out.println("-------------------------------------------------------");
    }  

    public void sequentialSort() {
        if (head == null) return;
    
        Node current = head;
        while (current != null) {
            Node minNode = current;
            Node next = current.next;
    
            while (next != null) {
                if (next.tanggal < minNode.tanggal) {
                    minNode = next;
                }
                next = next.next;
            }
    
            if (current != minNode) {
                swapNodes(current, minNode);
            }
            current = current.next;
        }
    }
    
    public void swapNodes(Node a, Node b) {
        if (a == b) {
            return;
        }
  
        Node prevA = null, prevB = null;
        Node current = head;
    
        while (current != null) {
            if (current.next == a) {
                prevA = current;
            }
            if (current.next == b) {
                prevB = current;
            }
            current = current.next;
        }
    
        if (a == head) {
            head = b;
        }
        else if (b == head) {
            head = a;
        }
        
        if (prevA != null) {
            prevA.next = b;
        }
        if (prevB != null) {
            prevB.next = a;
        }
        
        Node temp = a.next;
        a.next = b.next;
        b.next = temp;
    }
}