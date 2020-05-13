package view;

import controller.Creating;
import model.Account;
import model.Developer;
import model.Skill;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CreateView {
    private Scanner scanner;

    public CreateView() {
    }

    public CreateView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void main() {

        String next = "yes";
        do {
            System.out.println("What would you like to create?\n" +
                "d for Developer\n" +
                "s for Skill\n" +
                "a for Account");
            String i = scanner.nextLine();
            switch (i) {
                case "d":
                    createDev();
                    break;
                case "s":
                    craeteSkill();
                    break;
                case "a":
                    createAccount();
                    break;
            }
            System.out.println("Would you like to create smth else? (yes / no)");
            next = scanner.nextLine();
        } while(next.equals("yes"));
    }

    private void createDev() {
        System.out.println("Please, input new Dev ID");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Please, input new Dev name");
        String name = scanner.nextLine();
        System.out.println("Please, input account ID");
        Long accountId = Long.valueOf(scanner.nextLine());
        System.out.println("Please, input new Dev skills (type 0 to stop )");
        Set<Skill> skills = getSkills();
        new Creating(new Developer(id, name, skills, new Account(accountId))).addNewDeveloper();
        System.out.println("New Dev created successfully");
    }

    private void craeteSkill() {
        System.out.println("Please, input new skill ID");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Please, input brand new skill name");
        String name = scanner.nextLine();
        new Creating(new Skill(id, name)).addNewSkilll();
        System.out.println("New Dev created successfully");
    }

    private void createAccount() {

    }

    // создаем set скилов с клавиатуры - только ID
    protected Set<Skill> getSkills() {
        Set<Skill> skills = new HashSet<>();
        while (true) {
            Long id = Long.valueOf(scanner.nextLine());
            if (id != 0) {
                skills.add(new Skill(id));
            } else {
                break;
            }
        }
        return skills;
    }
}
