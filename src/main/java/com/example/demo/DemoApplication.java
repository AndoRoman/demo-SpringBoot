package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

@RestController
@RequestMapping(path = "/")
class MiControladorRest{
    @GetMapping(path = "/")
    public String holaMundo(){
        return "(~^.^)~ Hola Mundo Spring Boot ~(^.^~)";
    }
}

@Controller
@RequestMapping(path = "/plantilla")
class MiControladorPlantilla{
    @GetMapping(path = "/")
    public String index(Model model, HttpServletRequest request){
        model.addAttribute("encabezado", "Mi Hola Mundo en Plantilla");
        System.out.println("PathInfo: "+request.getPathInfo());
        return "index";
    }
}