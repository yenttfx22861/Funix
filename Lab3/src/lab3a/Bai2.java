package lab3a;

import java.util.ArrayList;
import java.util.Scanner;

class Animal {
    private String name;
    private double weight;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

public class Bai2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animalList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Nhập thông tin cho Animal thứ " + (i + 1));
            System.out.print("Tên: ");
            String name = scanner.nextLine();
            System.out.print("Trọng lượng (weight): ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Đọc dòng trống để tiếp tục vòng lặp

            Animal animal = new Animal(name, weight);
            animalList.add(animal);
        }

        Animal heaviestAnimal = animalList.get(0);

        for (Animal animal : animalList) {
            if (animal.getWeight() > heaviestAnimal.getWeight()) {
                heaviestAnimal = animal;
            }
        }

        System.out.println(heaviestAnimal.getName() + " is " + heaviestAnimal.getWeight());
    }
}
