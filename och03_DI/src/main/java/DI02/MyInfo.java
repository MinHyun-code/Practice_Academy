package DI02;

import java.util.ArrayList;

public class MyInfo {

	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbys;
	private BMICalculator bmiCalculator;

	public void bmiCalculation() {
		bmiCalculator.bmicalculator(weight, height);
	}
	
	public void getInfo() {
		System.out.println("�̸� : " + name);
		System.out.println("Ű : " + height);
		System.out.println("������ : " + weight);
		System.out.println("��� : " + hobbys);
		bmiCalculation();
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}

	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	
	
}
