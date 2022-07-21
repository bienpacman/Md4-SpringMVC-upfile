package service;

import model.Class;

import java.util.ArrayList;
import java.util.List;

public class ClassService {
public List<Class> classList = new ArrayList<>();

public  ClassService () {
    classList.add(new Class(1,"C0322g1"));
    classList.add(new Class(1,"C0322i1"));
    classList.add(new Class(1,"C0322h1"));
}
public List<Class> getAll() {
    return classList;
}
}
