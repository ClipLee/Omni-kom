package mas.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mas.Main;

@Data
@EqualsAndHashCode(callSuper = false)
public class Member extends User implements Serializable {
    
    private int id;
    private String name, surname, email;
    private double walletBalance;
    private List<Member> friends;

    public Member(int id, String name, String surname, String email, LocalDate date) {
        super(date);
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.walletBalance = 0.0;
        this.friends = new ArrayList<>();
    }

    public static void addNewUser(String name, String surname, String email, String password, LocalDate date){
        Main.userList.add(new Member(Main.userList.toArray().length, name, surname, email, date));
    }
    

    void editProfile(){

    }

    void deleteAccount(){

    }

    void addFunds(double funds){
        this.walletBalance += funds;
    }
}
