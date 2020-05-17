package main.java.com.iliapetrov.crud.view;

import java.util.Scanner;

public abstract class AbstractView {
    private final Scanner scanner;

    public AbstractView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void main() {
        String next = "yes";
        do {
            System.out.println("What would you like to do?\n" +
                    "c Create\n" +
                    "r Read\n" +
                    "u Update\n" +
                    "d Delete");
            String i = scanner.nextLine();
            switch (i) {
                case "c":
                    create();
                    break;
                case "r":
                    read();
                    break;
                case "u":
                    update();
                    break;
                case "d":
                    delete();
                    break;
            }
            System.out.println("Would you like to delete smth else? (yes / no)");
            next = scanner.nextLine();
        } while (next.equals("yes"));
    }

    protected abstract void create();

    protected abstract void read();

    protected abstract void update();

    protected abstract void delete();
}
