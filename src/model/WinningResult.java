/* Tejambica Vadugu & Ankita Acharya
 * SWE645 - Assignment 3
 *
 *This is WinningResult object model (Table)
 * 
 * */

package model;

public class WinningResult {
	private double mean;
	private double standardDeviation;
	
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
}
