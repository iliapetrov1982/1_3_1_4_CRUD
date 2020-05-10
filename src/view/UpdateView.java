package view;

import controller.Updating;
import model.Skill;

import java.util.Scanner;
import java.util.Set;

public class UpdateView extends CreateView {
    private Scanner scanner;

    public UpdateView(Scanner scanner) {
        super(scanner);
        this.scanner = scanner;
    }

    public void main() {

        String next = "yes";
        do {
            System.out.println("What would you like to update?\n" +
                "d for Developer\n" +
                "s for Skill\n" +
                "a for Account");
            String i = scanner.nextLine();
            switch (i) {
                case "d":
                    updateDev();
                    break;
                case "s":
                    updateSkill();
                    break;
                case "a":
                    updateAccount();
                    break;
            }
            System.out.println("Would you like to update smth else? (yes / no)");
            next = scanner.nextLine();
        } while(next.equals("yes"));
    }

    private void updateDev() {
        System.out.println("Please, input current Dev ID");
        String id = scanner.nextLine();
        System.out.println("Please, input new Dev skills (type 0 to stop )");
        Set<Skill> skills = super.getSkills();
        new Updating(id, skills).updateSkils();
    }

    private void updateSkill() {

    }

    private void updateAccount() {

    }
}
