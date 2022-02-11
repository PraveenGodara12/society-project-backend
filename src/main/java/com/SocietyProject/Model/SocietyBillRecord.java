package com.SocietyProject.Model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="society_bill_record")
public class SocietyBillRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int billID;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="adminID", referencedColumnName="adminID")
	private Admin admin;
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
	public SocietyBillRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SocietyBillRecord(int billID, Admin admin, double garbageCollector, double waterCharges, double electricity,
			double others, double totalAmount, String status, Date paymentDate, String month, int year) {
		super();
		this.billID = billID;
		this.admin = admin;
		this.garbageCollector = garbageCollector;
		this.waterCharges = waterCharges;
		this.electricity = electricity;
		this.others = others;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentDate = paymentDate;
		this.month = month;
		this.year = year;
	}
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
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
	
}
