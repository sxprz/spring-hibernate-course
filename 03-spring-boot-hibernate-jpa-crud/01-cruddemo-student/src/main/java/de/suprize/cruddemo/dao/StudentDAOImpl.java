package de.suprize.cruddemo.dao;

import de.suprize.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return this.entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create query (default for sorting = asc)
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student", Student.class);

        // Return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // Create query
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student where lastName=:data", Student.class);

        // Set query params
        query.setParameter("data", lastName);

        // Return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);
    }
}
