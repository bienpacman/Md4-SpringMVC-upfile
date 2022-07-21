package service;

import model.Class;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements CRUD<Student> {
    ClassService classService = new ClassService();
    public ArrayList<Student> listStudent = new ArrayList<>();



    public StudentService() {

        listStudent.add(new Student(1, "bien", "https://i.pinimg.com/564x/30/f2/33/30f233859b939353cafa2b67d1fd5df8.jpg", 18, "ha nam",false, classService.classList.get(0)));
        listStudent.add(new Student(2, "kien", "https://i.pinimg.com/564x/de/0a/c4/de0ac4cb6e85a9406e55fa7cda6a1264.jpg", 17, "ha nam",true, classService.classList.get(1)));
        listStudent.add(new Student(3, "dat", "https://i.pinimg.com/564x/9b/0d/4a/9b0d4a48beeffab13f455f6f5b0d60dd.jpg", 17, "ha nam",true, classService.classList.get(2)));

    }

    public Class getAClass(int id) {
        for (int i = 0; i < classService.classList.size(); i++) {
            if (classService.classList.get(i).getId() == id) {
                return classService.classList.get(i);
            }

        }
        return null;
    }

    public int findById(int id) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId() == id) {
                return i;
            }

        }
        return -1;
    }


    @Override
    public void create(Student student) {
        listStudent.add(student);
    }

    @Override
    public void edit(Student student, int index) {
        listStudent.set(index, student);
    }

    @Override
    public void delete(int index) {
        listStudent.remove(index);
    }

    @Override
    public List<Student> getAll() {
        return listStudent;
    }
}
