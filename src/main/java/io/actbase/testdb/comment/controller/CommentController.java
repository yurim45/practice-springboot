package io.actbase.testdb.comment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CommentController {
    @GetMapping("welcome")
    public String apiWelcome() {
        System.out.println("CommentController welcome");

        return "CommentController Welcome";
    }


    @GetMapping("test")
    public String test() {
        return "CommentController Test";
    }


}
