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
        new Updating(id, skills).updateDevSkills();
        System.out.println("Developer successfully updated");
    }

    private void updateSkill() {
        System.out.println("Please, input current skill ID");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Please, input new skill");
        String skillName = scanner.nextLine();
        new Updating(new Skill(id, skillName)).updateSkill();
        System.out.println("Skill successfully updated");
    }

    private void updateAccount() {

    }
}
