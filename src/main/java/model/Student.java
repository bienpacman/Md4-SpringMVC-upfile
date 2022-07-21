package model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue (strategy =   GenerationType.AUTO)
    @NonNull
    @Column(length = 200)
    private int id ;
    private String name ;
    private String img ;
    private int age ;
    private String address;
private boolean status;
@ManyToOne
    private Class aClass;


    public Student(int id, String name, String img, int age, String address, boolean status, Class aClass) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.age = age;
        this.address = address;
        this.status = status;
        this.aClass = aClass;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
