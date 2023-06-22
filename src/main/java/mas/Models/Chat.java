package mas.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Chat implements Serializable {
    private int id;
    private String title;
    private Member host;
    private List<Member> members;
    private List<GroupCall> groupCalls;
    
    public Chat(int id, String title, Member host, List<Member> members) {
        this.id = id;
        this.title = title;
        this.host = host;
        this.members = members;

        this.groupCalls = new ArrayList<>();
    }

    void remove(){}
    void end(){}
}
