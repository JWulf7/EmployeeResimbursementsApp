package com.revature.models;

import java.sql.Blob;
import java.util.Arrays;

public class Reimbursement {

	// fields
	private int reimId;
	
	private double amount;
	
	private String timeSubmitted;
	
	private String timeResolved;
	
	private String descript;
	
	private byte[] receipt;
	
	private int author;
	
	private int resolver;
	
	private ReimStatus status;
	
	private int statusNum;
	
	private ReimTypes type;
	
	private int typeNum;
	
	
	// constructors
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimId, double amount, String timeSubmitted, String timeResolved, String descript,
			byte[] receipt, int author, int resolver, int statusNum, int typeNum) {
		super();
		this.reimId = reimId;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.descript = descript;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	
	// getters and setters
	public int getStatusNum() {
		return statusNum;
	}

	public void setStatusNum(int statusNum) {
		this.statusNum = statusNum;
	}

	public int getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}

	
	public int getReimId() {
		return reimId;
	}

	public void setReimId(int reimId) {
		this.reimId = reimId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTimeSubmitted() {
		return timeSubmitted;
	}

	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}

	public String getTimeResolved() {
		return timeResolved;
	}

	public void setTimeResolved(String timeResolved) {
		this.timeResolved = timeResolved;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public ReimStatus getStatus() {
		return status;
	}

	public void setStatus(ReimStatus status) {
		this.status = status;
	}

	public ReimTypes getType() {
		return type;
	}

	public void setType(ReimTypes type) {
		this.type = type;
	}

	
	// otherStuff
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + author;
		result = prime * result + ((descript == null) ? 0 : descript.hashCode());
		result = prime * result + Arrays.hashCode(receipt);
		result = prime * result + reimId;
		result = prime * result + resolver;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timeResolved == null) ? 0 : timeResolved.hashCode());
		result = prime * result + ((timeSubmitted == null) ? 0 : timeSubmitted.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author != other.author)
			return false;
		if (descript == null) {
			if (other.descript != null)
				return false;
		} else if (!descript.equals(other.descript))
			return false;
		if (!Arrays.equals(receipt, other.receipt))
			return false;
		if (reimId != other.reimId)
			return false;
		if (resolver != other.resolver)
			return false;
		if (status != other.status)
			return false;
		if (timeResolved == null) {
			if (other.timeResolved != null)
				return false;
		} else if (!timeResolved.equals(other.timeResolved))
			return false;
		if (timeSubmitted == null) {
			if (other.timeSubmitted != null)
				return false;
		} else if (!timeSubmitted.equals(other.timeSubmitted))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", amount=" + amount + ", timeSubmitted=" + timeSubmitted
				+ ", timeResolved=" + timeResolved + ", descript=" + descript + ", receipt=" + Arrays.toString(receipt)
				+ ", author=" + author + ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}
}
	
	
	
	
