/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import Facade.Facade;
import entity.Project;
import entity.ProjectUser;
import entity.Task;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RolfMoikjær
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persistence.generateSchema("StudyPoint3.examen1PU", null);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudyPoint3.examen1PU");

        Facade logic = new Facade(emf);
        List<Project> projectArr = new ArrayList();
        List<ProjectUser> contributers = new ArrayList();
        String fakeId = "1";

        //creates user 1
        ProjectUser pUser = new ProjectUser();
        pUser.setEmail("sdfdsfds");
        pUser.setUserName("hdfds");
        pUser.setCreated("12/3");
        contributers.add(pUser);

        //creates user 2
        ProjectUser pUser2 = new ProjectUser();
        pUser2.setCreated("23/4");
        pUser2.setEmail("22222one");
        pUser2.setUserName("2nd");

        //creates project
        Project project = new Project();
        project.setDiscription("dsdsfs");
        project.setLastModified("sdfdsfd");
        project.setName("sdfdsdfsdffdg");
        project.setCreated("22/2");
        project.setContributors(contributers);
        projectArr.add(project);
        pUser.setProjects(projectArr);

        //creates task
        Task task = new Task();
        task.setDescription("sdfdsfd");
        task.setHoursAssigned("44444");
        task.setHoursUsed("3333");
        task.setName("task");
        task.setProject(project);

        logic.createProject(project);
        logic.createUser(pUser);
        logic.createUser(pUser2);
        logic.createTask(task, 1);

        System.out.println(logic.findUser(1).getId());

        List<ProjectUser> users = logic.getAllUsers();

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUserName());

            //prints the project name 
            for (int j = 0; j < users.get(i).getProjects().size(); j++) {
                System.out.println(users.get(i).getProjects().get(j).getName());
            }
        }

        System.out.println(logic.findProject(1).getContributors().get(0).getUserName());

        System.out.println(logic.findTask(fakeId).getName());
        System.out.println(logic.findTask(fakeId).getProject().getName());

    }

}
