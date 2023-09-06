public class Program {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(1, "робот", 2, 20);
        toyStore.addToy(2, "кукла", 6, 30);
        toyStore.addToy(3, "конструктор", 1, 10);

        toyStore.updateToyFrequency(2, 40);

        // Розыгрыш игрушек
        Toy prizeToy = toyStore.drawToy();
        if (prizeToy != null) {
            System.out.println("Выигрышная игрушка: " + prizeToy.getName());
            toyStore.savePrizeToyToFile(prizeToy);
        } else {
            System.out.println("Игрушки закончились");
        }
    }
}
