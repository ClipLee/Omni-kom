package mas.Models;

import java.time.LocalDate;
import java.time.Period;

import lombok.Data;

@Data
public abstract class User {
    protected LocalDate birthdate;

    public int getAge(){
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}
