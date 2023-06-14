package mas.Models;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Member extends User {
    
    private int id;
    private String name, surname, email;
    private double walletBalance;
    private List<Member> friends;
    
    public Member(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.walletBalance = 0.0;
    }
    

    void editProfile(){

    }

    void deleteAccount(){

    }

    void addFunds(double funds){
        this.walletBalance += funds;
    }
}
