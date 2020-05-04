package repository;

import model.Developer;
import model.Skill;

import java.io.*;
import java.util.Set;

public class DeveloperTable {
    private final String inFileName = "resources/developers.txt";
    private final String outFileName = "resources/tmp.txt";

    // добавляем нового разработчика
    public void addNewDeveloper(Developer developer) {
        try (PrintWriter out = new PrintWriter(new FileWriter(inFileName, true))) {
            out.printf("%s\t%s\t%s\n",
                    developer.getAccount().getAccount(),
                    developer.getName(),
                    setValuesToString(developer.getSkills())
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
//                System.out.println(devInfo[0]);
                if (id.equals(devInfo[0])) {
                    return line;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "no dev with such id";
    }

    // добавляем новые скилы
    public void addNewSkill(String id, Set<Skill> skills) {
        File tmpFile = new File(outFileName);
        try {
            tmpFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName));
             PrintWriter out = new PrintWriter(new FileWriter(outFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] devData = line.split("\\t");
//                System.out.println(devData[0]);
                if (id.equals(devData[0])) {
                    String newSkills = setValuesToString(skills);
//                    System.out.println(newSkills);
                    newSkills = devData[2] + ", " + newSkills;
                    out.printf("%s\t%s\t%s\n",
                            id,
                            devData[1],
                            newSkills
                    );
                } else {
                    out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        swop();
    }

    public void deleteDev(String id) {
        File tmpFile = new File(outFileName);
        try {
            tmpFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName));
             PrintWriter out = new PrintWriter(new FileWriter(outFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] devData = line.split("\\t");
                if (!id.equals(devData[0])) {
                    out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        swop();
    }

    // удаляем текущий файл и переименовываем tmp
    private void swop() {
        File constant = new File(inFileName);
        File tmp = new File(outFileName);
        constant.delete();
        tmp.renameTo(new File(inFileName));
    }

    // Преобразуем set скилов в строку
    private String setValuesToString (Set<Skill> skills) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Skill skill : skills) {
            stringBuilder.append(skill.getSkill());
            stringBuilder.append(", ");
        }
        String allSkills = stringBuilder.toString();
        return allSkills.substring(0, allSkills.length() - 2);
    }
 }
