public class linkedlist {
    private Nasabah head;
<<<<<<< HEAD
    private Nasabah tail;
    
    public void bar(){
        System.out.println("========================================================");
        System.out.println("|                           Qzy                         ");
        System.out.println("--------------------------------------------------------");
        System.out.println("|                 Silahkan Antri Disini                 ");
        System.out.println("========================================================");
    }
=======
    private Nasabah tail; 
>>>>>>> 6aa39f4c22a5688b65b65bd2358324d8b7fff2ef

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
<<<<<<< HEAD

    public void displayQueue(){
        Nasabah current = head;
        if (head == null) {
            System.out.println("Mohon maaf antrian masih kosong");
        } else {
            System.out.println("|No.|  Nama  |  Layanan  |  Prioritas  |  Waktu Masuk  |");
            System.out.println("--------------------------------------------------------");
            while (current != null) {
                System.out.println("| " + current.nomorAntrian + " |  " + current.nama + "  |  " + current.layanan + "  |  " + current.prioritas + "  |  " + current.waktuMasuk + "  |");
                System.out.println("--------------------------------------------------------");
            }
        }
    }
=======
>>>>>>> 6aa39f4c22a5688b65b65bd2358324d8b7fff2ef
}