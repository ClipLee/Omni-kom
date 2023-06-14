package mas.Models;

import java.util.List;

import lombok.Data;

@Data
public class GroupCall {
    private int id;
    private List<Member> members;

    public GroupCall(int id, List<Member> members) {
        this.id = id;
        this.members = members;
    }
    
    void begin(){}
    void end(){}
}
