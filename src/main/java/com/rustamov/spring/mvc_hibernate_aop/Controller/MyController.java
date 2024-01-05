package com.rustamov.spring.mvc_hibernate_aop.Controller;


import com.rustamov.spring.mvc_hibernate_aop.entity.Employee;
import com.rustamov.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/")
    public String showAllEmployees(Model model){
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employeeList",employeeList);

        return "all-employees";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);

        return "employee-info";
    }
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.saveEmployee(employee);
        return "redirect:/"; // we are returning the first view
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId")int id,Model model){

        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee",employee);

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId")int id,Model model){

        employeeService.deleteEmployee(id);


        return "redirect:/";
    }



}
















