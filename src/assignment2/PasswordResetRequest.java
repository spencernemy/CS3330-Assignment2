package assignment2;

public class PasswordResetRequest extends AbstractSupportRequest {
	private final String accountName;
	
	public PasswordResetRequest(int id, String title, int basePoints, String accountName) {
		super(id, title, basePoints);
		if (accountName == null || accountName.isBlank()) throw new IllegalArgumentException("Account name cannot be blank");
		this.accountName = accountName;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	@Override
	public int resolveFor(Technician technician) {
		if (technician == null) throw new IllegalArgumentException("Technician cannot be null");
		if (isResolved()) throw new IllegalStateException("Already resolved");
		
		int points = getBasePoints();
		
		technician.addPoints(points);
		markResolved();
		
		return points;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Account: " + accountName;
	}
}
