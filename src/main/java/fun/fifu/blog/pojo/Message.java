package fun.fifu.blog.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("message")
public class Message {
    Long id;
    String time;
    String name;
    String email;
    String message;
}
