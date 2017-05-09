package org.takastudy.data.dummydata.med.model;

import java.util.UUID;

import org.takastudy.data.dummydata.med.model.type.BloodType;
import org.takastudy.data.dummydata.med.model.type.Gender;

public class Patient {
	private String uuid;
	private int no;
	private String name;
	private String kana;
	private Gender gender;
	private String tel;
	private String cell;
	private String post;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String address5;
	private String birthDay;
	private BloodType blood;
	
	public Patient(){
		this.uuid = UUID.randomUUID().toString();
	}

	public String getAddress() {
		StringBuilder builder = new StringBuilder();
		if (address1 != null) {
			builder.append(address1);
		}

		if (address2 != null) {
			builder.append(address2);
		}

		if (address3 != null) {
			builder.append(address3);
		}

		if (address4 != null) {
			builder.append(address4);
		}

		if (address5 != null) {
			builder.append(address5);
		}

		return builder.toString();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getAddress5() {
		return address5;
	}

	public void setAddress5(String address5) {
		this.address5 = address5;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public BloodType getBlood() {
		return blood;
	}

	public void setBlood(BloodType blood) {
		this.blood = blood;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
