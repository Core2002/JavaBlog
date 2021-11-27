package fun.fifu.blog.controller;

import cn.hutool.core.date.DateUtil;
import fun.fifu.blog.mapper.MessageMapper;
import fun.fifu.blog.pojo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    private final MessageMapper messageMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    public IndexController(MessageMapper mm) {
        this.messageMapper = mm;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "你好，世界！";
    }

    @RequestMapping("/")
    public String index(String name, String email, String message) {
        if (name != null && email != null && message != null) {
            Message mess = new Message();
            mess.setTime(DateUtil.now());
            mess.setName(name);
            mess.setEmail(email);
            mess.setMessage(message);
            messageMapper.addMessage(mess);
            return "redirect:http://localhost:8080";
        }
        return "index";
    }
}
