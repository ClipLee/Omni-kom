package mas.Models;

import java.util.List;

import lombok.Data;

@Data
public class Chat {
    private int id;
    private String title;
    private Member host;
    private List<Member> members;
    
    public Chat(int id, String title, Member host, List<Member> members) {
        this.id = id;
        this.title = title;
        this.host = host;
        this.members = members;
    }

    void remove(){}
    void end(){}
}
