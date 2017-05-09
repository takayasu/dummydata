package org.takastudy.data.dummydata.med.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicationHistory {
	
	private static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	private String patientUuid;
	private String patientName;
	private LocalDateTime entryDate;
	
	private List<String> medis;
	
	public MedicationHistory(){
		medis = new ArrayList<>();
	}

	public String getPatientUuid() {
		return patientUuid;
	}

	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getEntryDate() {
		return FORMAT.format(entryDate);
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public List<String> getMedis() {
		return medis;
	}

	public void setMedis(List<String> medis) {
		this.medis = medis;
	}
	
	public void addMedis(String medi){
		this.medis.add(medi);
	}
	

}
