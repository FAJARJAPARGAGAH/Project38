public class linkedlist {
    private Nasabah head;
    private Nasabah tail; 

    public void addLast(int nomorAntrian, String nama, String layanan, int prioritas, String waktuMasuk) {
        Nasabah newNode = new Nasabah(nomorAntrian, nama, layanan, prioritas, waktuMasuk);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else { 
            tail.right = newNode;
            newNode.left = tail;
            tail = newNode;
        }
    }
}