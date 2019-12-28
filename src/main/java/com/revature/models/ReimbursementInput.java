package com.revature.models;

public class ReimbursementInput {

	private double amount;
	
	private String descript;
	
	private byte[] receipt;
	
	private int author;
	
	private int typeNum;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public int getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}

	public ReimbursementInput(double amount, String descript, int typeNum, byte[] receipt) {
		super();
		this.amount = amount;
		this.descript = descript;
		this.typeNum = typeNum;
		this.receipt = receipt;
		
		
	}
	
	
	
	
}
