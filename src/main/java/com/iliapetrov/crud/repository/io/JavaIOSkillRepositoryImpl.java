package main.java.com.iliapetrov.crud.repository.io;

import main.java.com.iliapetrov.crud.model.Skill;
import main.java.com.iliapetrov.crud.repository.SkillRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository {
    private final String inFileName = "src/resources/skills.txt";

    // Получаем skill по ID
    public Skill getById(Long id) {
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] skillInfo = line.split("\\t");
                if (id.equals(Long.valueOf(skillInfo[0]))) {
                    return getSkillFromString(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Skill();
    }

    public int getSnth() {
        return 1;
    }

    // Получаем все скилы из файла
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                skills.add(getSkillFromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skills;
    };

    // Создаем новый skill
    public Skill save(Skill skill) {
        try (PrintWriter out = new PrintWriter(new FileWriter(inFileName, true))) {
            out.println(skill.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skill;
    }

    // Обновляем cуществующий skill
    public Skill update (Skill skill) {
        List<Skill> skills = new ArrayList<>();
        Long skillId = skill.getId();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] skillData = line.split("\\t");
                if (skillId.equals(Long.valueOf(skillData[0]))) {
                    skillData[1] = skill.getName();
                    line = String.format("%s\t%s", skillData[0], skillData[1]);
                }
                skills.add(getSkillFromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        IOUtils.writeToFile(skills, inFileName);
        return skill;
    }

    // удаляем skill
    public void deleteById(Long id) {
        List<Skill> skills = new ArrayList<>();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] skillData = line.split("\\t");
                if (!id.equals(Long.valueOf(skillData[0]))) {
                    skills.add(getSkillFromString(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        IOUtils.writeToFile(skills, inFileName);
    }

    // Получкем объект Skill из строки файла
    private Skill getSkillFromString(String skillString) {
        String[] devData = skillString.split("\\t");
        Long id = Long.valueOf(devData[0]);
        String name = devData[1];
        return new Skill(id, name);
    }
}
