package com.kh.dtoSample;
// CafeDTO : ������ ���� ��ü 
public class CafeDTO {
	// model SQL �� ���Ŀ� ���� �����͸� ĸ��ȭ �ϰ� getter setter�� Ȱ���Ͽ� �����͸� �����ϰ� �������� ����
	// �ʵ� ������� �ۼ�
	private int cafeID;
	private String cafeName;
	private String address;
	private String phoneNumber;
	private String operatingHours;
	
	// ������ �ۼ�
	// 1. �⺻ ������
	public CafeDTO() {
		
	}
	// 2. �Ķ���� ���� ���� ������
	public CafeDTO(int cafeID, String cafeName, String address, String  phoneNumber, String operatingHours) {
		this.cafeID = cafeID;
		this.cafeName = cafeName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.operatingHours = operatingHours;
	}
	
	// Getter Setter �޼���
	public int getCafeID() {
		return cafeID;
	}
	public void setCafeID(int cafeID) {
		this.cafeID = cafeID;
	}
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOperatingHours() {
		return operatingHours;
	}
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}
	
	
	
	// @Override(�̹� �ۼ��� �޼��带 �����ؼ� ������ �´� �������� ���� �� ���)�� Ȱ���� toString �޼��� �߰�
	@Override
	public String toString() {
		return "CafeDTO";
	}
	
}
