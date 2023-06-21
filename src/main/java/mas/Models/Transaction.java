package mas.Models;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Transaction implements Serializable {
    private int id;
    private LocalDate date;
    private Member member;
    private Product product;
    
    public Transaction(LocalDate date, Member member, Product product) {
        this.date = date;
        this.member = member;
        this.product = product;
        id = member.getTransactions().toArray().length;
    }

    public static void makeTransaction(Member member, Product product){
        Transaction transaction = new Transaction(LocalDate.now(), member, product);
        member.getTransactions().add(transaction);
        product.getTransactions().add(transaction);
    }

    void showHistory(){}
    void showTransaction(){}
    void requestRefund(){}
}
