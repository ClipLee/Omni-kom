package mas.Models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = true)
public class Guest extends User implements Serializable {
    
    void register(){

    }

    void login(){

    }
}
