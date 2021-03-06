package com.SocietyProject.Model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="maintenance_record")
public class MaintenanceRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int recordID;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userID", referencedColumnName="userID")
	private User user;
	@Column(name="garbageCollector")
	private double garbageCollector;
	@Column(name="waterCharges")
	private double waterCharges;
	@Column(name="electricity")
	private double electricity;
	@Column(name="others")
	private double others;
	@Column(name="totalAmount")
	private double totalAmount;
	@Column(name="status")
	private String status;
	@Column(name="paymentDate")
	private Date paymentDate;
	@Column(name="month")
	private String month;
	@Column(name="year")
	private int year;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="billID", referencedColumnName="billID")
	private SocietyBillRecord bill;
	public MaintenanceRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MaintenanceRecord(int recordID, User user, double garbageCollector, double waterCharges, double electricity,
			double others, double totalAmount, String status, Date paymentDate, String month, int year,
			SocietyBillRecord bill) {
		super();
		this.recordID = recordID;
		this.user = user;
		this.garbageCollector = garbageCollector;
		this.waterCharges = waterCharges;
		this.electricity = electricity;
		this.others = others;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentDate = paymentDate;
		this.month = month;
		this.year = year;
		this.bill = bill;
	}
	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getGarbageCollector() {
		return garbageCollector;
	}
	public void setGarbageCollector(double garbageCollector) {
		this.garbageCollector = garbageCollector;
	}
	public double getWaterCharges() {
		return waterCharges;
	}
	public void setWaterCharges(double waterCharges) {
		this.waterCharges = waterCharges;
	}
	public double getElectricity() {
		return electricity;
	}
	public void setElectricity(double electricity) {
		this.electricity = electricity;
	}
	public double getOthers() {
		return others;
	}
	public void setOthers(double others) {
		this.others = others;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public SocietyBillRecord getBill() {
		return bill;
	}
	public void setBill(SocietyBillRecord bill) {
		this.bill = bill;
	}
	
}
