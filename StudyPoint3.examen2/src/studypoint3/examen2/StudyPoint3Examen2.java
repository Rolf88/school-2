/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studypoint3.examen2;

import Facade.Logic;
import entity.Employee;
import entity.PhdStudent;
import entity.Student;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RolfMoikjær
 */
public class StudyPoint3Examen2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persistence.generateSchema("StudyPoint3.examen2PU", null);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudyPoint3.examen2PU");

        try (Logic logic = new Logic(emf)) {
            
            Student student = new Student();
            student.setMatDate(new Date());
            student.setMatNr(12);
            student.setFirstName("Rolf");            
            logic.add(student);
            
            Employee employee = new Employee();
            employee.setFirstName("Bjarke");
            employee.setSoSecNr(123);
            logic.add(employee);
            
            PhdStudent phdStudent = new PhdStudent();
            phdStudent.setDissSubject("sdgsgfdgfd");
            phdStudent.setLastName("ronald");
            logic.add(phdStudent);
            
                      
        }
        
        try(Logic logic = new Logic(emf)){
            Student student = logic.find(Student.class, 1);
            
            
            System.out.println(student.getFirstName());
        }
    }

}
