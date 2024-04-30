package Tahap2;

import java.util.ArrayList;
import java.util.List;

// Antarmuka untuk Observer
interface Observer {
    void update(String message);
}

// Kelas subjek yang diamati
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    // Menambahkan observer baru
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Menghapus observer
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // Memberi tahu semua observer tentang perubahan
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Kelas konkrit yang mengimplementasikan Observer
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

