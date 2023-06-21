package mas.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import lombok.Data;

@Data
public abstract class User implements Serializable {
    protected LocalDate birthdate;

    public User(){}

    public User(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge(){
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}
