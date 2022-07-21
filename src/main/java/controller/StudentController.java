package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ClassService;
import service.StudentService;

import java.io.File;
import java.io.IOException;


@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @GetMapping("/student")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("students", studentService.getAll());
        return modelAndView;
    }

    @GetMapping("/edit/{index}")
    public ModelAndView showEdit(@PathVariable int index) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("student", studentService.getAll().get(index));
        modelAndView.addObject("classes", classService.getAll());
        return modelAndView;

    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute Student student, @PathVariable int index, @RequestParam int classIndex, @RequestParam MultipartFile file) {
        String nameImg = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File("C:\\Users\\phamv\\Downloads\\Clone\\Case3\\demo4ModelAndView_Student\\src\\main\\webapp\\WEB-INF\\img\\" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        student.setImg("/img/" + nameImg);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        student.setaClass(classService.getAll().get(classIndex));
        studentService.edit(student, index);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(Model model) {
        ModelAndView modelAndView = new ModelAndView("create");
        model.addAttribute("students", studentService.listStudent);
        model.addAttribute("classes", classService.classList);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute(value = "students") Student student, @RequestParam MultipartFile file, @RequestParam int idClass) {

        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File("C:\\Users\\phamv\\Downloads\\Clone\\Case3\\demo4ModelAndView_Student\\src\\main\\webapp\\WEB-INF\\img\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        student.setImg("/img/" + fileName);
        student.setaClass(studentService.getAClass(idClass));
        studentService.create(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        return modelAndView;
    }

    @GetMapping("/delete/{index}")
    public ModelAndView delete(@PathVariable int index) {
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        studentService.delete(index);
        return modelAndView;
    }

}
