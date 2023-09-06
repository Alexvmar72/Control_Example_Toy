import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(int id, String name, int amount, int frequency) {
        Toy toy = new Toy(id, name, amount, frequency);
        toys.add(toy);    }

    public void updateToyFrequency(int id, int newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setFrequency(newFrequency);
                break;
            }
        }
    }
    public Toy drawToy() {
        double totalFrequency = toys.stream().mapToDouble(Toy::getFrequency).sum();
        double randomValue = Math.random() * totalFrequency;
        double frequencySum = 0;

        for (Toy toy : toys) {
            frequencySum += toy.getFrequency();
            if (randomValue <= frequencySum) {
                Toy prizeToy = new Toy(toy.getId(), toy.getName(), 1, (int) toy.getFrequency());
                toy.setFrequency(toy.getAmount() - 1);
                return prizeToy;
            }
        }

        return null;
    }
    public void savePrizeToyToFile(Toy prizeToy) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("results.txt", true))) {
            writer.println("ID: " + prizeToy.getId() + ", Name: " + prizeToy.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Toy {
    private int id;
    private String name;
    private int amount;
    private int frequency;

    public Toy(int id, String name, int amount, int frequency) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.frequency = frequency;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
