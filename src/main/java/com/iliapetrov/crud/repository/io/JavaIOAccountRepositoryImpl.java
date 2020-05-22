package main.java.com.iliapetrov.crud.repository.io;

import main.java.com.iliapetrov.crud.model.Account;
import main.java.com.iliapetrov.crud.model.AccountStatus;
import main.java.com.iliapetrov.crud.model.Skill;
import main.java.com.iliapetrov.crud.repository.AccountRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOAccountRepositoryImpl implements AccountRepository {
    private final String inFileName = "src/resources/accounts.txt";

    @Override
    public Account getById(Long id) {
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] skillInfo = line.split("\\t");
                if (id.equals(Long.valueOf(skillInfo[0]))) {
                    return getAccountFromString(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Account();
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                accounts.add(getAccountFromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account save(Account account) {
        try (PrintWriter out = new PrintWriter(new FileWriter(inFileName, true))) {
            out.println(account.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account update(Account account) {
        List<Account> accounts = new ArrayList<>();
        Long accountId = account.getId();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] accountData = line.split("\\t");
                if (accountId.equals(Long.valueOf(accountData[0]))) {
                    if (AccountStatus.valueOf(accountData[2]).equals(AccountStatus.ACTIVE)) {
                        accountData[2] = AccountStatus.BANNED.toString();
                    } else if (AccountStatus.valueOf(accountData[2]).equals(AccountStatus.BANNED)) {
                        accountData[2] = AccountStatus.ACTIVE.toString();
                    }
                    line = String.format("%s\t%s\t%s", accountData[0], accountData[1], accountData[2]);
                    account = getAccountFromString(line);
                }
                accounts.add(getAccountFromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(accounts);
        return account;
    }

    @Override
    public void deleteById(Long id) {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] accountData = line.split("\\t");
                if (id.equals(Long.valueOf(accountData[0]))) {
                    accountData[2] = AccountStatus.DELETED.toString();
                    line = String.format("%s\t%s\t%s", accountData[0], accountData[1], accountData[2]);
                }
                accounts.add(getAccountFromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(accounts);
    }

    @Override
    public void writeToFile(List<Account> accounts) {
        try (PrintWriter out = new PrintWriter(new FileWriter(inFileName))) {
            for (Account account : accounts) {
                out.println(account.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Получкем объект Skill из строки файла
    private Account getAccountFromString(String accountString) {
        String[] devData = accountString.split("\\t");
        Long id = Long.valueOf(devData[0]);
        String name = devData[1];
        AccountStatus status = AccountStatus.valueOf(devData[2]);
        return new Account(id, name, status);
    }
}
