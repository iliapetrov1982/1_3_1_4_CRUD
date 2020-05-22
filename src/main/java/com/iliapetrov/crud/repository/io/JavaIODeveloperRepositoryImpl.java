package main.java.com.iliapetrov.crud.repository.io;

import main.java.com.iliapetrov.crud.model.Account;
import main.java.com.iliapetrov.crud.model.Developer;
import main.java.com.iliapetrov.crud.model.Skill;
import main.java.com.iliapetrov.crud.repository.DeveloperRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {
    private final String inFileName = "src/resources/developers.txt";

    @Override
    public Developer getById(Long id) {
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] devInfo = line.split("\\t");
                if (id.equals(Long.valueOf(devInfo[0]))) {
                    return getDevFromString(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Developer();
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> developers = new ArrayList<>();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                developers.add(getDevFromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developers;
    }

    @Override
    public Developer save(Developer developer) {
        try (PrintWriter out = new PrintWriter(new FileWriter(inFileName, true))) {
            out.printf(developer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    // добавляем новые Skills
    public Developer update(Developer developer) {
        Long id = developer.getId();
        Set <Skill> skills = developer.getSkills();
        List<Developer> developers = new ArrayList<>();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] devData = line.split("\\t");
                if (id.equals(Long.valueOf(devData[0]))) {
                    String newSkills = putSetValuesToString(skills);
                    devData[2] = devData[2] + "," + newSkills;
                    line = String.format("%s\t%s\t%s\t%s\n", devData[0], devData[1], devData[2], devData[3]);
                    developer = getDevFromString(line);
                }
                developers.add(getDevFromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(developers);
        return developer;
    }

    @Override
    public void deleteById(Long id) {
        List<Developer> developers = new ArrayList<>();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] devData = line.split("\\t");
                if (!id.equals(Long.valueOf(devData[0]))) {
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

    @Override
    public void writeToFile(List<Developer> developers) {
        try (PrintWriter out = new PrintWriter(new FileWriter(inFileName))) {
            for (Developer developer : developers) {
                out.print(developer.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Преобразуем Set<Skill> в строку
    private String putSetValuesToString(Set<Skill> skills) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Skill skill : skills) {
            stringBuilder.append(skill.getId());
            stringBuilder.append(",");
        }
        String allSkills = stringBuilder.toString();
        return allSkills.substring(0, allSkills.length() - 1);
    }

    // Получкем объект Developer из строки файла
    private Developer getDevFromString(String devString) {
        String[] devData = devString.split("\\t");
        Long id = Long.valueOf(devData[0]);
        String name = devData[1];
        Set<Skill> skills = getSkillSeFromString(devData[2]);
        Account account = new Account(Long.valueOf(devData[3].strip()));
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
}
