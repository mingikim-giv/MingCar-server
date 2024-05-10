package mingCarServer.car.model;

public class Car {
	private int carCode;
	private String carName;
	private int carPrice;
	private String carType;
	private int carSeat;
	private boolean reservation;
	
	public Car(int carCode, String carName, int carPrice, String carType, int carSeat, boolean reservation) {
		super();
		this.carCode = carCode;
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
