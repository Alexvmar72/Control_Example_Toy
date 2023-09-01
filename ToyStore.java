import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToyStore {
    private Map<Integer, Toy> toysMap;
    private PriorityQueue<Integer> queue;

    public ToyStore() {
        toysMap = new HashMap<>();
        queue = new PriorityQueue<>();
    }

    public void addToy(int id, String name, int frequency) {
        Toy toy = new Toy(id, name, frequency);
        toysMap.put(id, toy);
        for (int i = 0; i < frequency; i++) {
            queue.add(id);
        }
    }

    public int getToy() {
        int randomNum = new Random().nextInt(100) + 1;
        if (randomNum <= 20) {
            return 1;
        } else if (randomNum <= 40) {
            return 2;
        } else {
            return queue.poll();
        }
    }

    public void executeAndGetResults() {
        StringBuilder results = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int toyId = getToy();
            results.append(toyId).append(" ");
        }
        writeResultsToFile(results.toString());
    }

    private void writeResultsToFile(String results) {
        try {
            FileWriter writer = new FileWriter("results.txt");
            writer.write(results);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Toy {
        private int id;
        private String name;
        private int frequency;

        public Toy(int id, String name, int frequency) {
            this.id = id;
            this.name = name;
            this.frequency = frequency;
        }
    }
}