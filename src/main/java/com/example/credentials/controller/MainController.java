package com.example.credentials.controller;

import com.example.credentials.entity.Property;
import com.example.credentials.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private final PropertyService propertyService;

    @Autowired
    public MainController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("properties", propertyService.getAllProperties());
        return "index";
    }

    @GetMapping(value = "/", params = "query")
    public String getPropertiesByQuery(@RequestParam String query, Model model) {
        model.addAttribute("properties", propertyService.getPropertiesByQuery(query));
        return "index";
    }

    @GetMapping("/property/{id}")
    @ResponseBody
    public Property getPropertyById(@PathVariable int id) {
        return propertyService.getPropertyById(id);
    }

    @PostMapping("/property/save")
    public String saveProperty(Property property, HttpServletRequest request) {
        propertyService.save(property);
        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping("/property/delete/{id}")
    public String deletePlugin(@PathVariable int id, HttpServletRequest request) {
        propertyService.delete(id);
        return "redirect:" + request.getHeader("Referer");
    }

}
