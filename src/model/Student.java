/* Tejambica Vadugu & Ankita Acharya
 * SWE645 - Assignment 3
 *
 *This is Student object model (Table)
 * 
 * */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.sun.tools.javac.util.List;

//import java.util.Arrays;
import java.util.List;

@Entity
@Table (name = "surveyTable2")
public class Student implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String studentID;

	private String firstName;
	private String lastName;
    private String address;
    private String zipcode;
    private String city;
    private String state;
    private String phone;
    private String email;
    private String surveyDate;
    
    private List<String> likes;
    private String interest;   
    private String comments;
    private String recommend;
    private String raffle;
    private String date2;
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "zip")
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "date1")
	public String getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(String date) {
		this.surveyDate = date;
	}
	
	@Column(name = "raffle")
	public String getRaffle() {
		return raffle;
	}
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	
	public List<String> getLikes() {
		return likes;
	}
	public void setLikes(List<String> likes) {
		this.likes = likes;
	}
	
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	
	@Override
	public String toString() {
		return
				 getFirstName() + "|" + 
				 getLastName() + "|" + 
				 getAddress() + "|" + 
				 getCity() + "|" + 
				 getState() + "|" + 
				 getZipcode() + "|" + 
				 getPhone() + "|" + 
				 getEmail() + "|" + 
				 getSurveyDate() + "|" + 
				 getRaffle() + "|" + 
				 getDate2() + "|"+
				 System.getProperty("line.separator");
	}
	
	public void getStudent(String line) {
		String[] a = line.split("\\|", -1);
		setFirstName(a[0]);
		setLastName(a[1]);
		setAddress(a[2]);
		setCity(a[3]);
		setState(a[4]);
		setZipcode(a[5]);
		setPhone(a[6]);
		setEmail(a[7]);
		setSurveyDate(a[8]);
		setRaffle(a[13]);
		setDate2(a[14]);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
