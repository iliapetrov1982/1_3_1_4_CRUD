package view;

import controller.Deleting;

import java.util.Scanner;

public class DeleteView {
    private Scanner scanner;

    public DeleteView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void main() {
        String next = "yes";
        do {
            System.out.println("What would you like to delete?\n" +
                    "d for Developer\n" +
                    "s for Skill\n" +
                    "a for Account");
            String i = scanner.nextLine();
            switch (i) {
                case "d":
                    deleteDev();
                    break;
                case "s":
                    deleteSkill();
                    break;
                case "a":
                    deletteAccount();
                    break;
            }
            System.out.println("Would you like to delete smth else? (yes / no)");
            next = scanner.nextLine();
        } while (next.equals("yes"));
    }

    private void deleteDev() {
        System.out.println("Please, input current Dev ID");
        Long id = Long.valueOf(scanner.nextLine());
        new Deleting(id).deleteCurrentDev();
    }

    private void deleteSkill() {
        System.out.println("Please, input current skill ID");
        Long id = Long.valueOf(scanner.nextLine());
        new Deleting(id).deleteCurrentSkill();
    }

    private void deletteAccount() {

    }
}
