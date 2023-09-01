public class Program {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(1, "робот", 2);
        toyStore.addToy(2, "кукла", 6);
        toyStore.addToy(3, "игрушка", 1);
        toyStore.executeAndGetResults();
    }
}
