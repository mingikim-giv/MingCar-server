package mingCarServer.reservation.model;

import java.sql.Timestamp;

public class ReservationResponseDto {
	private int reserveCode;
	private String id;
	private int carCode;
	private Timestamp startDate;
	private Timestamp endDate;
	private String paymentMethod;
	private boolean payment;
	
	public ReservationResponseDto() {}

	public ReservationResponseDto(int reserveCode, String id, int carCode, Timestamp startDate, Timestamp endDate,
			String paymentMethod, boolean payment) {
		super();
		this.reserveCode = reserveCode;
		this.id = id;
		this.carCode = carCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.paymentMethod = paymentMethod;
		this.payment = payment;
	}

	public int getReserveCode() {
		return reserveCode;
	}

	public void setReserveCode(int reserveCode) {
		this.reserveCode = reserveCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCarCode() {
		return carCode;
	}

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}
	
}
