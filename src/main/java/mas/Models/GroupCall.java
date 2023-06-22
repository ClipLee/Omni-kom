package mas.Models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class GroupCall implements Serializable {
    private int id;
    private List<Member> members;
    private Map<Integer, Member> membersOrder;
    /**
     * atrybut klasowy
     */
    public static final int maxMembers = 49;

    public GroupCall(int id, List<Member> members) {
        this.id = id;
        this.members = members;
    }

    /**
     *
     * Ordered
     */
    public void addMembers(Member member){
        if (this.members.toArray().length==49){
            System.out.println("You can't add any more members");
        }else {
            this.members.add(member);
            this.membersOrder.put(members.toArray().length, member);
        }
    }
    
    void begin(){}
    void end(){}
}
