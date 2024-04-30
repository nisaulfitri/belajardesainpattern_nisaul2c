package Tahap2;

class ObserverPatternExample {
    public static void main(String[] args) {
        // Membuat subjek
        Subject subject = new Subject();

        // Menambahkan observer
        Observer observer1 = new ConcreteObserver("Observer 1");
        subject.attach(observer1);

        Observer observer2 = new ConcreteObserver("Observer 2");
        subject.attach(observer2);

        // Mengubah pesan subjek dan memberi tahu observer
        subject.setMessage("Hello World!");

        // Menghapus salah satu observer
        subject.detach(observer1);

        // Mengubah pesan lagi dan memberi tahu observer yang tersisa
        subject.setMessage("Goodbye!");
    }
}

