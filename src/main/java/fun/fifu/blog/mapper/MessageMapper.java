package fun.fifu.blog.mapper;

import fun.fifu.blog.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    List<Message> findAll();
    Message getMessage(Long id);
    void addMessage(Message message);
}
