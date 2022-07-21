package dao;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDao {
    @Autowired
    EntityManager entityManager;
    public List<Student> getStudentList() {
        String queryStr = "SELECT s FROM Student s ";
        TypedQuery<Student> query = entityManager.createQuery(queryStr,Student.class);
        return (List<Student>) query.getResultList();
    }
    public void save(Student student){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(student);
        txn.commit();
    }
    public void edit (Student student) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(student);
        txn.commit();
    }
    public Student findById(int id ) {
        String query = "SELECT s FROM Student s where s.id =:id";
        Student student = entityManager.createQuery(query,Student.class).setParameter("id",id ).getSingleResult();
        return student;
    }
    public void delete (int id ){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(findById(id));
        txn.commit();
    }
}
