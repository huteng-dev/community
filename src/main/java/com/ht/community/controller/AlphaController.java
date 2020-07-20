package com.ht.community.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayhello(){
        return "Hello,Spring Boot.";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest req, HttpServletResponse resp){
        System.out.println(req.getMethod());
        System.out.println(req.getContextPath());
        Enumeration<String> enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = req.getHeader(name);
            System.out.println(name+": "+value);
        }
        resp.setContentType("text/html;charset=utf-8");

        try(PrintWriter out = resp.getWriter();) {
            out.print("<h1>hello.</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success!!";
    }
}
