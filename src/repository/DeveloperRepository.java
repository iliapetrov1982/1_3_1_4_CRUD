package repository;

import model.Account;
import model.Developer;
import model.Skill;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeveloperRepository {
    private final String inFileName = "src/resources/developers.txt";

    // добавляем нового разработчика
    public void addNewDeveloper(Developer developer) {
        try (PrintWriter out = new PrintWriter(new FileWriter(inFileName, true))) {
            out.printf(developer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // выводим информацию по разработчику
    public String getDevInfo (String id) {
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] devInfo = line.split("\\t");
                if (id.equals(devInfo[0])) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "no dev with such id";
    }

    // добавляем новые Skills
    public void addNewSkill(String id, Set<Skill> skills) {
        List<Developer> developers = new ArrayList<>();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] devData = line.split("\\t");
                if (id.equals(devData[0])) {
                    String newSkills = setValuesToString(skills);
                    devData[2] = devData[2] + "," + newSkills;
                    line = String.format("%s\t%s\t%s\t%s", devData[0], devData[1], devData[2], devData[3]);
                }
                developers.add(getDevFromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(developers);
    }

    // Удаляем разработчика
    public void deleteDev(String id) {
        List<Developer> developers = new ArrayList<>();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] devData = line.split("\\t");
                if (!id.equals(devData[0])) {
                    developers.add(getDevFromString(line));
                } else {
                    System.out.println("Developer erased");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(developers);
    }

    // Получкем объект Developer из строки файла
    private Developer getDevFromString(String devString) {
        String[] devData = devString.split("\\t");
        Long id = Long.valueOf(devData[0]);
        String name = devData[1];
        Set<Skill> skills = getSkillSeFromString(devData[2]);
        Account account = new Account(Long.valueOf(devData[3]));
        return new Developer(id, name, skills, account);
    }

    // Получаем Set<Skill> из строки
    private Set<Skill> getSkillSeFromString(String skillString) {
        Set<Skill> skillSet = new HashSet<>();
        String[] skills = skillString.split(",");
        for (String skill : skills) {
            skillSet.add(new Skill(Long.valueOf(skill)));
        }
        return skillSet;
    }

    // Преобразуем Set<Skill> в строку
    private String setValuesToString (Set<Skill> skills) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Skill skill : skills) {
            stringBuilder.append(skill.getId());
            stringBuilder.append(",");
        }
        String allSkills = stringBuilder.toString();
        return allSkills.substring(0, allSkills.length() - 1);
    }

    // Пишем List<Developer> в файл
    public void writeToFile(List<Developer> developers) {
        try (PrintWriter out = new PrintWriter(new FileWriter(inFileName))) {
            for (Developer developer : developers) {
                out.println(developer.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }
