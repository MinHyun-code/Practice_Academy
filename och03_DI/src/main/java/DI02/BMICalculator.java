package DI02;

public class BMICalculator {

	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;
	
	public void bmicalculator(double weight, double height) {
		double h = height * 0.01;
		double result = weight / (h*h);
		
		System.out.println("BMI ���� : " + (int)result);
		
		if (result > obesity) {
			System.out.println("��.");
		} else if (result > overWeight) {
			System.out.println("��ü��.");
		} else if (result > normal) {
			System.out.println("����.");
		} else {
			System.out.println("��ü��.");
		}
	}

	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
}
