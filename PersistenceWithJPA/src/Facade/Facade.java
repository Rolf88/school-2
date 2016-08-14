package Facade;

import entity.Project;
import entity.ProjectUser;
import entity.Task;
import java.io.Closeable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RolfMoikjær
 */
public class Facade implements Closeable {

    private final EntityManager entityManager;

    public Facade(EntityManagerFactory factory) {
        this.entityManager = factory.createEntityManager();
        this.entityManager.getTransaction().begin();
    }

    public void createUser(ProjectUser user) {
        this.entityManager.persist(user);
    }

    public ProjectUser findUser(int id) {
        Query createQuery = this.entityManager.createQuery("SELECT u FROM ProjectUser u WHERE u.id = :id");
        createQuery.setParameter("id", id);

        return (ProjectUser) createQuery.getSingleResult();
    }

    public List<ProjectUser> getAllUsers() {

        Query query = this.entityManager.createQuery("SELECT p FROM ProjectUser p");

        return query.getResultList();
    }

    public void createProject(Project project) {
        this.entityManager.persist(project);
    }

    public Project findProject(int id) {
        Query query = this.entityManager.createQuery("SELECT p FROM Project p WHERE p.id = :id");
        query.setParameter("id", id);
        return (Project) query.getSingleResult();
    }

    public void createTask(Task task, int projectId) {
        task.setProject(findProject(projectId));
        this.entityManager.persist(task);
    }

    public Task findTask(String id) {
        return this.entityManager.find(Task.class, Long.parseLong(id));
    }

    @Override
    public void close() {
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

}
