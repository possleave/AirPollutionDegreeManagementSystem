
public class AirPollution {
	private String date;
	private String place;
	private double one;
	private double two;
	private double three;
	private double four;
	private double five;
	private double six;

	public AirPollution(String date, String place, double one, double two, double three,
			double four, double five, double six) {
		this.date=date;
		this.place=place;
		this.one=one;
		this.two=two;
		this.three=three;
		this.four=four;
		this.five=five;
		this.six=six;
	}
	
	@Override
	public String toString() {
		return "AirPollution [date=" + date + ", place=" + place + ", one=" + one + ", two=" + two + ", three=" + three
				+ ", four=" + four + ", five=" + five + ", six=" + six + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public double getOne() {
		return one;
	}

	public void setOne(double one) {
		this.one = one;
	}

	public double getTwo() {
		return two;
	}

	public void setTwo(double two) {
		this.two = two;
	}

	public double getThree() {
		return three;
	}

	public void setThree(double three) {
		this.three = three;
	}

	public double getFour() {
		return four;
	}

	public void setFour(double four) {
		this.four = four;
	}

	public double getFive() {
		return five;
	}

	public void setFive(double five) {
		this.five = five;
	}

	public double getSix() {
		return six;
	}

	public void setSix(double six) {
		this.six = six;
	}
	
}
