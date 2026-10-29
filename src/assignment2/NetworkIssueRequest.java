package assignment2;

public class NetworkIssueRequest extends AbstractSupportRequest {
	private final int affectedUsers;
	
	public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers) {
		super(id, title, basePoints);
		if (affectedUsers <= 0) throw new IllegalArgumentException("Affected users must be positive");
		this.affectedUsers = affectedUsers;
	}
	
	public int getAffectedUsers() {
		return affectedUsers;
	}
	
	@Override
	public int resolveFor(Technician technician) {
		if (technician == null) throw new IllegalArgumentException("Technician cannot be null");
		if (isResolved()) throw new IllegalStateException("Already resolved");
		
		// Linear rule was chosen for points as it is a clean and easily understandable method
		// to give points to issues based on how many users are affected
		int points = getBasePoints() + affectedUsers;
		
		technician.addPoints(points);
		markResolved();
		
		return points;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Affected Users: " + affectedUsers;
	}

}
