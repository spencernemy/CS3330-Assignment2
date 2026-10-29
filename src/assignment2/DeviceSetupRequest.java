package assignment2;

public class DeviceSetupRequest extends AbstractSupportRequest {
	private final int deviceCount;
	
	public DeviceSetupRequest(int id, String title, int basePoints, int deviceCount) {
		super(id, title, basePoints);
		if (deviceCount <= 0) throw new IllegalArgumentException("Device count must be positive");
		this.deviceCount = deviceCount;
	}
	
	public int getDeviceCount() {
		return deviceCount;
	}
	
	@Override
	public int resolveFor(Technician technician) {
		if (technician == null) throw new IllegalArgumentException("Technician cannot be null");
		if (isResolved()) throw new IllegalStateException("Already resolved");
		
		int points = getBasePoints() * deviceCount;
		
		technician.addPoints(points);
		markResolved();
		
		return points;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Device Count: " + deviceCount;
	}

}
