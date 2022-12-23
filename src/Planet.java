public class Planet {
	private String name, classification, radius, distance, moon, ring, period;
	
	Planet(String n, String c, String rad, String d, String m, String r, String p){
		name = n;
		classification = c;
		radius = rad;
		distance = d;
		moon = m;
		ring = r;
		period =p;
	}

	
	public final String getName() {
		return name;
	}

	
	public final String getClassification() {
		return classification;
	}

	
	public final String getRadius() {
		return radius;
	}

	
	public final String getDistance() {
		return distance;
	}

	
	public final String getMoon() {
		return moon;
	}

	
	public final String getRing() {
		return ring;
	}

	
	public final String getPeriod() {
		return period;
	}
}
