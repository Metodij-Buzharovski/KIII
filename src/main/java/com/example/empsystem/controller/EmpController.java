package com.example.empsystem.controller;

import com.example.empsystem.entity.Employee;
import com.example.empsystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @GetMapping("/")
    public String home(Model m) {
        List<Employee> emplist = service.getEMpByPaginate();
        m.addAttribute("emp", emplist);
        m.addAttribute("totalItem", emplist.stream().count());
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmpForm() {
        return "add_emp";
    }

    @PostMapping("/register")
    public String empRegister(
//            @ModelAttribute Employee e,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String email,
            @RequestParam String phno,
            @RequestParam String salary,
            HttpSession session) {
        Employee e = new Employee(name,address,email,phno,Integer.parseInt(salary));
        service.addEmp(e);
        session.setAttribute("msg", "Emplyoee Added Sucessfully..");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Employee e = service.getEMpById(id);
        m.addAttribute("emp", e);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(
//            @ModelAttribute Employee e,
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String email,
            @RequestParam String phno,
            @RequestParam String salary,
            HttpSession session) {
        service.updateEmp(Integer.parseInt(id),name,address,email,phno,Integer.parseInt(salary));
        session.setAttribute("msg", "Emp Data Update Sucessfully..");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEMp(@PathVariable int id, HttpSession session) {

        service.deleteEMp(id);
        session.setAttribute("msg", "Emp Data Delete Sucessfully..");
        return "redirect:/";
    }

    @GetMapping("/page/{pageno}")
    public String findPaginated(@PathVariable int pageno, Model m) {

        List<Employee> emplist = service.getEMpByPaginate();
        m.addAttribute("emp", emplist);
//        m.addAttribute("currentPage", pageno);
        m.addAttribute("totalItem", emplist.stream().count());
        return "index";
    }

}
