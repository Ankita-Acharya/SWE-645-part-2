/* Tejambica Vadugu & Ankita Acharya
 * SWE645 - Assignment 3
 * 
 * This is a managed bean. Survey Page is directed to this bean on submission.
 * Contains a reference to Student model object, whose properties are mapped to fields on Survey page. 
 * Also has a few validator methods.
 * */

package bean;

import java.util.List;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
//import javax.persistence.Entity;

import model.Student;
import model.WinningResult;
import service.StudentService;

@ManagedBean
@RequestScoped
public class SurveyBean {
	
	// Properties
	private Student student;
	private WinningResult winningResult;
	private List<Student> studentRecords;
	
	private String currentDate, startDate;
	
	public SurveyBean() {
		this.student = new Student();
		this.winningResult = new WinningResult();
		this.studentRecords = new ArrayList<Student>();
	}
	
	// Getter-Setter methods
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	public WinningResult getWinningResult() {
		return winningResult;
	}

	public void setWinningResult(WinningResult winningResult) {
		this.winningResult = winningResult;
	}
	
	public List<Student> getStudentRecords() {
		return studentRecords;
	}

	public void setStudentRecords(List<Student> studentRecords) {
		this.studentRecords = studentRecords;
	}
	
	// Action Controller Methods
	public String submitForm() {
		try {
			System.out.print("check1");
			//StudentService ss = new StudentService();
			System.out.println("check after object");
			this.winningResult = processData(this.student.getRaffle());
			System.out.print("check2");
			//ss.save(getStudent());
			System.out.print("check4");
			if(winningResult.getMean() > 90)
				return "winner-ack";
			else 
				return "simple-ack";
		} catch(Exception e) {
			System.out.print(e);
			return "error";
		}
	}
	
	public String listSurvey() {
		try {
//			StudentService ss = new StudentService();
//			setStudentRecords(ss.getAll());
			return "list-survey";
		} catch (Exception e) {
			return "error";
		}
	}
	
	
	// Helper Methods
	
	public void currentDate(FacesContext context, UIComponent component, Object value) 
			throws ValidatorException
	{
		currentDate = value.toString();
	}
	
	public void validateStartDate(FacesContext context, UIComponent component, Object value) 
			throws ValidatorException
	{
		startDate = value.toString();
		System.out.println( currentDate + "The date2 ");
		System.out.println(startDate + "The get suvey date");
		if(currentDate.compareTo(startDate) > 0) {
			;
		}
		else  {
			FacesMessage message = new FacesMessage("Semester start date should be before Survey day");
			throw new ValidatorException(message);
		}
		
	}
	public void validateRaffle(FacesContext context, UIComponent component, Object value) 
			throws ValidatorException
	{
		String raffle = value.toString();
		String[] data = raffle.split(",");
		if(data.length < 10) {
			FacesMessage message = new FacesMessage("Enter atleast 10 numbers");
			throw new ValidatorException(message);
		}
		try {
			for (String s : data) {
				int number = Integer.parseInt(s);
				if(number < 1 || number > 100) {
					FacesMessage message = new FacesMessage("Numbers should be 1 through 100");
					throw new ValidatorException(message);
				}
			}	
		}
		catch (NumberFormatException e) {
			FacesMessage message = new FacesMessage("Enter only numbers");
			throw new ValidatorException(message);
		}
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
