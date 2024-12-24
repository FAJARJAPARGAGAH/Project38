public class linkedlist {
    Node head = null;
    Node tail = null;

    public void tambahNode(int nomorAntrian, String nama, String layanan, String prioritas, String waktuMasuk) {
        Node newNode = new Node(nomorAntrian, nama, layanan, prioritas, waktuMasuk);
    
        if (head == null) { 
            head = newNode;
            tail = newNode;
        } else {
            if (nomorAntrian < head.nomorAntrian) { 
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null && current.next.nomorAntrian < nomorAntrian) {
                    current = current.next; 
                }
                newNode.next = current.next;
                current.next = newNode;
    
                if (current == tail) { 
                    tail = newNode;
                }
            }
        }
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("Mohon maaf, data masih kosong!");
        } else {
            System.out.println("========================================================");
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

    public void enqueue(int nomorAntrian, String nama, String layanan, String prioritas, String waktuMasuk) {
        Node newNode = new Node(nomorAntrian, nama, layanan, prioritas, waktuMasuk);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node dequeue(Stack stack) {
        if (head == null) {
            return null;
        } else {
            Node temp = head;
            head = head.next;
            if (head == null) { 
                tail = null;
            }
            stack.push("Hapus Antrian - Nama: " + temp.nama);
            System.out.println("Data dengan nama " + temp.nama + " berhasil dihapus.");
            return temp;
        }
    }
}