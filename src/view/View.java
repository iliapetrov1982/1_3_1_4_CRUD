package view;

import controller.Creating;
import controller.Deleting;
import controller.Reading;
import controller.Updating;
import model.Account;
import model.Developer;
import model.Skill;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    public void mainCycle() {
        System.out.println("Please, choose an action by typing:\n" +
                "c for Create\n" +
                "r for Read\n" +
                "u for Update\n" +
                "d for Delete");
        String i = scanner.nextLine();
        switch(i) {
            case "c":
                createNewDev();
                break;
            case "r":
                readDevInfo();
                break;
            case "u":
                updateSkillInfo();
                break;
            case "d":
                deleteDevInfo();
                break;
        }
    }

    // создаем нового разработчика "c"
    private void createNewDev() {
        System.out.println("Please, input new Dev ID");
        String id = scanner.nextLine();
        System.out.println("Please, input new Dev name");
//        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Please, input new Dev skills (type 'enough' to stop )");
        Set<Skill> skills = getSkills();
        new Creating(new Developer(new Account(id), name, skills)).addNewDeveloper();
        System.out.println("New Dev created succrrsfully");
    }

    // читаем информацию о разработчике "r"
    private void readDevInfo() {
        System.out.println("Please, input current Dev ID");
        String id = scanner.nextLine();
        String devInfo = new Reading(id).getDevInfoById();
        System.out.println(devInfo);
    }

    // добавляем скилы разработчику
    private void updateSkillInfo() {
        System.out.println("Please, input current Dev ID");
        String id = scanner.nextLine();
        System.out.println("Please, input new Dev skills (type 'enough' to stop )");
        Set<Skill> skills = getSkills();
        new Updating(id, skills).updateSkils();
    }

    // удаляем разработчика "d"
    private void deleteDevInfo() {
        System.out.println("Please, input current Dev ID");
        String id = scanner.nextLine();
        new Deleting(id).deleteCurrentDev();
    }

    // создаем set скилов с клавиатуры
    private Set<Skill> getSkills() {
        Set<Skill> skills = new HashSet<>();
        while(true) {
            String skill = scanner.nextLine();
            if(!skill.equals("enough")) {
                skills.add(new Skill(skill));
            }
            else {
                break;
            }
        }
        return skills;
    }
}
