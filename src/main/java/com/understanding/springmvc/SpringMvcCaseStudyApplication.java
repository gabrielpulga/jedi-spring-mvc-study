package com.understanding.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MVC stands for Model View Controller
 * View : Front end user interface
 * Controller : Layer that serves as intermediary between the user interface (View) and the handled data (Model)
 * Model : Could be multiple layers, but basically handles the data
 */

@SpringBootApplication
public class SpringMvcCaseStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMvcCaseStudyApplication.class, args);
    }

}
