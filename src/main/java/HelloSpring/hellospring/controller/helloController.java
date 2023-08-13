package HelloSpring.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class helloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMVvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-templates";
    }
    @GetMapping("hello-string")
    // HTTP Message의 Body에 넣어주겠움.
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }
    // 객체를 넘긴다?? -> JSON으로 반환. NEST에서 객체로 Return해주는거.
    // 객체를 반환 + ResponseBody
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
