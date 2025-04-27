package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao(); 
		
		System.out.println("=== TEST 1: department findById ====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: department findAll ====");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department d:list) {
			System.out.println(d);
		}
		
		System.out.println("\n=== TEST3: department insert ====");
		Department newDepartment = new Department(null, "Services");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST4: department update ====");
		dep = departmentDao.findById(1);
		dep.setName("Food");
		departmentDao.update(dep);
		System.out.println("Update completed");

	}

}
