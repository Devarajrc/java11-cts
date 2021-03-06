package com.cts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeTest {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Employee emp1 = new Employee(23, "Ravi", "Kumar", 34343.343);
		Employee emp3 = new Employee(3, "Amit", "Sharma", 54343.343);
		Employee emp2 = new Employee(13, "Venkat", "Raju", 44343.343);
		Employee emp4 = new Employee(43, "Karthik", "Kumar", 24343.343);
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		
		System.out.println(employees);
		
//		1. Lamda for sorting Employees by salaries (increasing)
//		Collections.sort(employees, ___ lamda ____);
		Collections.sort(employees, new Comparator<Employee>(){
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.salary.compareTo(o2.salary);
			}
			
		});
//		Sorted List
		System.out.println("-------- Printing all sorted by salaries --------- ");
		printAll(employees);
//		2. Print each Employee object
//		3. Print Employee object where first name start with "R"
		System.out.println("-------- Printing all with name starting with R--------- ");
		printConditionally(employees, new Condition(){
			@Override
			public boolean test(Employee e) {
				return e.firstName.startsWith("R");
			}
			
		});
		
//		4. Print Employee object where last name start with "R"
		System.out.println("-------- Printing all with lastname starting with R--------- ");
		printConditionally(employees, new Condition(){
			@Override
			public boolean test(Employee e) {
				return e.lastName.startsWith("R");
			}
			
		});

	}
	
	static void printAll(List<Employee> employees){
		for(Employee e: employees){
			System.out.println(e);
		}
	}

	static void printConditionally(List<Employee> employees, Condition condition){
		for(Employee e: employees){
			if(condition.test(e)) {
				System.out.println(e);
			}
//			if(e.firstName.startsWith("R")){
//				System.out.println(e);
//			}
		}
	}
}
@FunctionalInterface
interface Condition{
	boolean test(Employee e);
}
