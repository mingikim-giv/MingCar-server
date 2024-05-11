package mingCarServer.car.model;

public class Car {
	private int carCode;
	private String carNumber;
	private String carName;
	private int carPrice;
	private String carType;
	private int carSeat;
	private boolean reservation;
	
	public Car() {}
	
	public Car(int carCode, String carNumber, String carName, int carPrice, String carType, int carSeat,
			boolean reservation) {
		super();
		this.carCode = carCode;
		this.carNumber = carNumber;
		this.carName = carName;
		this.carPrice = carPrice;
		this.carType = carType;
		this.carSeat = carSeat;
		this.reservation = reservation;
	}

	public int getCarCode() {
		return carCode;
	}

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getCarSeat() {
		return carSeat;
	}

	public void setCarSeat(int carSeat) {
		this.carSeat = carSeat;
	}

	public boolean isReservation() {
		return reservation;
	}

	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}
}
