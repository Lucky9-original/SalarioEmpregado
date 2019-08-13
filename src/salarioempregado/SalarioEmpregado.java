package salarioempregado;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalarioEmpregado {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        
        System.out.print("How many employees will be registered? ");
        int n = tec.nextInt();
        
        List<Employee> list = new ArrayList<>();
        
        for (int i=0; i<n; i++){
            System.out.println("");
            System.out.println("Employee #" + (i+1) + ": ");
            System.out.print("Id: ");
            int id = tec.nextInt();
            tec.nextLine();
            System.out.println("Name: ");
            String name = tec.nextLine();
            System.out.println("Salary: ");
            double salary = tec.nextDouble();
            
            list.add(new Employee(id, name, salary));
        }
        
        System.out.println("");
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = tec.nextInt();
        
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        
        double percentage;
        if (emp == null){
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            percentage = tec.nextDouble();
            emp.increaseSalary(percentage);
        }
        
        System.out.println("");
        System.out.println("List of employees: ");
        for (Employee x : list){
            System.out.println(x.toString());
        }
    }
    
}
