package mas.Models;

import lombok.Data;

import java.io.Serializable;

public enum AgeRating implements Serializable {
    PEGI3(3), PEGI7(7), PEGI12(12), PEGI16(16), PEGI18(18);

    public final int i;
    AgeRating(int i) {
        this.i = i;
    }

}
