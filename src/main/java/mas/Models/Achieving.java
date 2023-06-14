package mas.Models;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Achieving implements Serializable {

    private int id;
    private LocalDate date;

    void share(){}
}
