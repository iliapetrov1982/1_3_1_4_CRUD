package main.java.com.iliapetrov.crud.view;

import java.util.Scanner;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);

    public void mainCycle() {
        String next = "yes";
        do {
            System.out.println("What would you like to work with?\n" +
                    "d for Developer\n" +
                    "s for Skill\n" +
                    "a for Account");
            String i = scanner.nextLine();
            switch (i) {
                case "d":
                    new DeveloperView(scanner).main();
                    break;
                case "s":
                    new SkillView(scanner).main();
                    break;
                case "a":
                    new AccountView(scanner).main();
                    break;
            }
            System.out.println("Would you like to do smth else? (yes / no)");
            next = scanner.nextLine();
        } while (next.equals("yes"));
    }
}
