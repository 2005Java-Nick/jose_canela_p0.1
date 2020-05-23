package com.revature.Objects;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import org.postgresql.core.Utils;

public class Payment {
	@Override
	public int hashCode() {
		return Objects.hash(carId, custId, datetime, paymentAmount, paymentId, timestamp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(carId, other.carId) && Objects.equals(custId, other.custId)
				&& Objects.equals(datetime, other.datetime) && Objects.equals(paymentAmount, other.paymentAmount)
				&& Objects.equals(paymentId, other.paymentId) && Objects.equals(timestamp, other.timestamp);
	}
	private Integer paymentId;
	private Timestamp datetime;
	private Integer custId;
	private Integer carId;
	private Double paymentAmount;
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public java.sql.Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	
	
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	
	//Create Payment
	public Payment(Integer custId, Integer carId) {
		super();
		
		this.custId = custId;
		this.carId = carId;
		this.datetime  = timestamp; 
	}
	public Payment(Integer custId, Integer carId,Double paymentAmount, Timestamp datetime) {
		super();
		this.paymentAmount = paymentAmount;
		this.datetime = datetime;
		this.custId = custId;
		this.carId = carId;
	}
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
}
