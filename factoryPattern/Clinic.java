package factoryPattern;

import java.util.Scanner;

public class Clinic {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 1;

        do {
            System.out.println("----------------------------" +
                    "\n[1] Dog");
            System.out.println("[2] Cat");
            System.out.println("[3] Exit");
            System.out.print("\u001B[32m Choose a number: \u001B[0m");
            choice = input.nextInt();

            PetRecord petFile = new PetRecord();
            Pet pet = null;

            switch (choice) {
                case 1:
                    pet = new Dog();
                    ((Dog) pet).setBreed("German Shepperd");
                    petFile.setPetId("D01");
                    petFile.setPetName("Bantay");
                    petFile.setPet(pet);
                    break;
                case 2:
                    pet = new Cat();
                    petFile.setPetId("C01");
                    petFile.setPetName("Muning");
                    petFile.setPet(pet);
                    ((Cat) pet).setNoOfLives(9);
            }

            if (choice != 3) {
                System.out.println("Pet id is " + petFile.getPetId());
                System.out.println("Pet name is " + petFile.getPetName());
                System.out.println("Pet kind: " + petFile.getPet().getClass().getSimpleName());
                System.out.println("Communication sound: " + petFile.getPet().makeSound());
                System.out.println("Play mode: " + petFile.getPet().play());

                if (pet instanceof Dog dog) {
                    System.out.println("Dog Breed: " + dog.getBreed());
                } else if (pet instanceof Cat cat) {
                    System.out.println("No. of Lives: " + cat.getNoOfLives());
                }
            }

        } while (choice != 3);

        System.out.println("Exit Program!");
    }
}
