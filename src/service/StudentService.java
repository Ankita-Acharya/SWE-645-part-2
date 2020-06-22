/* Tejambica Vadugu & Ankita Acharya
 * SWE645 - Assignment 3
 *
 * Encapsulates business logic to store and read the Survey data to/from a database table. 
 * It provides methods to save the Student Survey Form data to a database table and to retrieve the survey 
 * information from the database table.
 * 
 * */

package service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import model.Student;
import model.WinningResult;

public class StudentService{
	
	@PersistenceUnit
	private static final String PERSISTENCE_UNIT_NAME = "SWE645-Homework3";
		
	@PersistenceContext
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em;
	
	public StudentService() {
		super();
	}
	
	public static EntityManager getEntityManager() {
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	public void save(Student s) throws IOException
	{
		System.out.print("check3");
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<Student> getAll() throws IOException
	{
		List<Student> list = new ArrayList<Student>();
		return list;
	}
	
	public WinningResult processData(String s) {
		String[] data;
		WinningResult w = new WinningResult();
		data = s.split(",");
		
		int[] numbers = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			numbers[i] = Integer.parseInt(data[i]);
		}

		w.setMean(calcMean(numbers));
		w.setStandardDeviation(calcStandardDeviation(numbers));
		return w;
	}
	
	public double calcMean(int n[]) {
		double sum = 0;
		for (int i = 0; i < n.length; i++)
			sum += n[i];
		return sum / n.length;
	}

	public double calcStandardDeviation(int n[]) {
		double mean = calcMean(n);
		double sd = 0;
		for (int i = 0; i < n.length; i++)
			sd += Math.pow(n[i] - mean, 2);
		return (Math.sqrt(sd / n.length));
	}
}
