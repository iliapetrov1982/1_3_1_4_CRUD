package view;

import controller.Deleting;
import controller.Reading;
import controller.Updating;
import model.Skill;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    public void mainCycle() {
        String next = "yes";
        do {
            System.out.println("Please, choose an action by typing:\n" +
                    "c for Create\n" +
                    "r for Read\n" +
                    "u for Update\n" +
                    "d for Delete");
            String i = scanner.nextLine();
            switch (i) {
                case "c":
                    new CreateView(scanner).main();
                    break;
                case "r":
                    new ReadView(scanner).main();
                    break;
                case "u":
                    new UpdateView(scanner).main();
                    break;
                case "d":
                    new DeleteView(scanner).main();
                    break;
            }
            System.out.println("Would you like to do smth else? (yes / no)");
            next = scanner.nextLine();
        } while (next.equals("yes"));
    }
}
