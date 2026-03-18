package Weekly_AssessmentTask.Weekly_AssessmentTask;


import jakarta.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("employeePU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        Employee employee = new Employee("DNS", "dns@example.com");


        IDCard idCard = new IDCard("IDC101", LocalDate.now());


        idCard.setEmployee(employee);
        employee.setIdCard(idCard);


        em.persist(employee);

        em.getTransaction().commit();

        System.out.println("Employee Created Successfully");


        Employee fetchedEmployee = em.find(Employee.class, employee.getId());

        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + fetchedEmployee.getId());
        System.out.println("Name: " + fetchedEmployee.getName());
        System.out.println("Email: " + fetchedEmployee.getEmail());

        System.out.println("\nID Card Details:");
        System.out.println("Card Number: " +
                fetchedEmployee.getIdCard().getCardNumber());
        System.out.println("Issue Date: " +
                fetchedEmployee.getIdCard().getIssueDate());


        IDCard fetchedCard = em.find(IDCard.class, idCard.getId());

        System.out.println("\nEmployee from IDCard:");
        System.out.println("Name: " +
                fetchedCard.getEmployee().getName());

        em.close();
        emf.close();
    }
}