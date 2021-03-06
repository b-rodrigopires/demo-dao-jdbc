package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n==== TEST 3: seller findAll ====");
		List<Seller> list2 = sellerDao.findAll();
		
		for (Seller s : list2) {
			System.out.println(s);
		}
		
		System.out.println("\n==== TEST 4: seller insert ====");
		
		Date d = new Date();
		Department dep =  new Department(1, "Computers");
		Seller s = new Seller(null, "Teste", "Teste@", d, 5000.0, dep);
		
		sellerDao.insert(s);
		
		System.out.println("Inserted! New id = "+s.getId());
		
		System.out.println("\n==== TEST 5: seller update ====");
		
		s = sellerDao.findById(1);
		s.setName("Martha Waine");
		sellerDao.update(s);
		
		System.out.println(s);
		
		System.out.println("\n==== TEST 6: seller delete ====");
		
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);
		
		System.out.println("Deleted!");
		
		
		sc.close();
	}

}
