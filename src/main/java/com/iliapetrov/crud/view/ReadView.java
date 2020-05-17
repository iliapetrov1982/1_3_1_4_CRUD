package main.java.com.iliapetrov.crud.view;

import main.java.com.iliapetrov.crud.controller.Reading;

import java.util.Scanner;

public class ReadView {
    private Scanner scanner;

    public ReadView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void main() {

        String next = "yes";
        do {
            System.out.println("What would you like to read?\n" +
                "d for Developer\n" +
                "s for Skill\n" +
                "a for Account");
            String i = scanner.nextLine();
            switch (i) {
                case "d":
                    readDev();
                    break;
                case "s":
                    readSkill();
                    break;
                case "a":
                    readAccount();
                    break;
            }
            System.out.println("Would you like to read smth else? (yes / no)");
            next = scanner.nextLine();
        } while(next.equals("yes"));
    }

    private void readDev() {
        System.out.println("Please, input current Dev ID");
        String id = scanner.nextLine();
        String devInfo = new Reading(id).getDevInfoById();
        System.out.println(devInfo);
    }

    private void readSkill() {
        System.out.println("Please, input current skill ID");
        String id = scanner.nextLine();
        String devInfo = new Reading(id).getSkillById();
        System.out.println(devInfo);
    }

    private void readAccount() {
    }
}

