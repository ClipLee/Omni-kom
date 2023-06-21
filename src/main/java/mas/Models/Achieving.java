package mas.Models;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Achieving implements Serializable {

    private int id;
    private LocalDate date;

    private Member member;
    private Achievement achievement;

    Achieving(int id, Member member, Achievement achievement, LocalDate date) {
        this.member = member;
        this.achievement = achievement;
        this.date = date;
        this.id = id;
    }

    void share() {
    }

    public static void achieve(int id, Member member, Achievement achievement) {
        Achieving achieving = new Achieving(id, member, achievement, LocalDate.now());
        member.getAchievements().add(achieving);
        achievement.getAchievings().add(achieving);
    }

    @Override
    public String toString() {
        return "";
    }
}
