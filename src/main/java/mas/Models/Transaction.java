package mas.Models;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Transaction implements Serializable {
    private int id ;
    private LocalDate date;
    
    public Transaction(int id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    void showHistory(){}
    void showTransaction(){}
    void requestRefund(){}
}
