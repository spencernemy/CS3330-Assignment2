package assignment2;

public class Technician {
	private final String name;
	private int servicePoints;
	
	public Technician(String name) {
		if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
		
		this.name = name;
		this.servicePoints = 0;
	}
	
	public int getServicePoints() {
		return servicePoints;
	}
	
	public void addPoints(int amount) {
		if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
		servicePoints += amount;
	}
	
	@Override
	public String toString() {
		return "Technician: " + name + ", Service Points: " + servicePoints;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Technician)) return false;
		
		Technician other = (Technician) obj;
		return name.equals(other.name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
