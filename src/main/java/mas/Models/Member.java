package mas.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mas.Main;
import mas.NotUniqueException;

@Data
@EqualsAndHashCode(callSuper = false)
public class Member extends User implements Serializable {

    private int id;
    private String name, surname, email;
    private double walletBalance;
    private List<Member> friends;

    private List<Transaction> transactions;
    /**
     * Atrybut opcjonalny
     */
    private List<Achieving> achievements;

    /**
     * Unique
     */
    public Member(int id, String name, String surname, String email, LocalDate date) {
        super(date);

        if (checkForId(id)) try {
            throw new NotUniqueException();
        } catch (NotUniqueException e) {
            System.out.println("Not unique id");
        }
        else {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.walletBalance = 0.0;
            this.friends = new ArrayList<>();

            this.transactions = new ArrayList<>();
            this.achievements = new ArrayList<>();
        }
    }

    public Member(Guest guest, int id, String name, String surname, String email, LocalDate date) {
        super(date);
        if (checkForId(id)) try {
            throw new NotUniqueException();
        } catch (NotUniqueException e) {
            System.out.println("Not unique id");
        }
        else {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.walletBalance = 0.0;
            this.friends = new ArrayList<>();

            this.transactions = new ArrayList<>();
            this.achievements = new ArrayList<>();
        }
    }

    public static void addNewUser(String name, String surname, String email, String password, LocalDate date) {
        Main.userList.add(new Member(Main.userList.toArray().length, name, surname, email, date));
    }


    void editProfile() {

    }

    void deleteAccount() {

    }

    void addFunds(double funds) {
        this.walletBalance += funds;
    }

    private boolean checkForId(int id) {
        for (Member m : Main.userList) {
            if (m.getId() == id) return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return name+" "+surname;
    }
}