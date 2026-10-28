package assignment2;

public abstract class AbstractSupportRequest implements SupportRequest {
	private final int id;
	private final String title;
	private final int basePoints;
	private boolean resolved;
	
	public AbstractSupportRequest(int id, String title, int basePoints) {
		if (id <= 0) throw new IllegalArgumentException("ID must be positive");
		if (title == null || title.isBlank()) throw new IllegalArgumentException("Title cannot be blank");
		if (basePoints <= 0) throw new IllegalArgumentException("Base points must be positive");
				
		this.id = id;
		this.title = title;
		this.basePoints = basePoints;
		this.resolved = false;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getBasePoints() {
		return basePoints;
	}
	
	public boolean isResolved() {
		return resolved;
	}
	
	protected void markResolved() {
		if (resolved) throw new IllegalStateException("Request has already been resolved");
		resolved = true;
	}
	
	@Override
	public String toString() {
		return "Request #" + id + ": " + title + " (Base Points: " + basePoints + ", Resolved: " + resolved + ")";
	}
}
