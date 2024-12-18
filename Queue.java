public class Queue {
    Node front;
    Node rear;

    public void enqueue(int nomorAntrian, String nama, String layanan, int prioritas, String waktuMasuk) {
        Node newNode = new Node(nomorAntrian, nama, layanan, prioritas, waktuMasuk);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Node dequeue() {
        if (front == null) {
            return null;
        } else {
            Node temp = front;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return temp;
        }
    }

}