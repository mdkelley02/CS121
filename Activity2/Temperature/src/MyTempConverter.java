
public class MyTempConverter {
	public static void main(String[] args) {
		System.out.println(convert(87));
	}
	public static double convert(float f) {
		float temp = (f-32) * ((float)5/9);
		return temp;
	}

}