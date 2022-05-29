package team7.capstone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team7.capstone.service.ReplyService;
import team7.capstone.service.UserService;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService rservice;


}
