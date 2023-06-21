package mas.Models;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class GroupCall implements Serializable {
    private int id;
    private List<Member> members;
    private int maxMembers = 49;

    public GroupCall(int id, List<Member> members) {
        this.id = id;
        this.members = members;
    }
    
    void begin(){}
    void end(){}
}
