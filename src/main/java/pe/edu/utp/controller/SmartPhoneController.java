package pe.edu.utp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.utp.model.SmartPhone;
import pe.edu.utp.service.SmartPhoneService;

@Controller
public class SmartPhoneController {

    @Autowired
    private SmartPhoneService smartphoneService;

    @GetMapping("/smartphones")
    public String showDocuments(Model model) {
        List<SmartPhone> documents = smartphoneService.findAll();
        model.addAttribute("smartphones", documents);
        model.addAttribute("smartphone", new SmartPhone());
        return "smartphones";
    }

    @PostMapping("/smartphones")
    public String createDocument(@ModelAttribute SmartPhone document) {
    	smartphoneService.save(document);
        return "redirect:/smartphones";
    }

    @GetMapping("/smartphones/export/excel")
    public String exportExcel() throws IOException {
        List<SmartPhone> smartPhones = smartphoneService.findAll();
        smartphoneService.createExcel(smartPhones);
        return "redirect:/smartphones";
    }
}