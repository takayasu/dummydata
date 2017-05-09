package org.takastudy.data.dummydata.med.generator;

import java.util.ArrayList;
import java.util.List;

import org.takastudy.data.dummydata.med.model.MedicationHistory;
import org.takastudy.data.dummydata.med.model.Medicine;
import org.takastudy.data.dummydata.med.model.Patient;

public class MedicationHistoryGenerator {
	
	private PatientGenerator pGen;
	private MedicineGenerator mGen;
	
	
	public MedicationHistoryGenerator(PatientGenerator _pGen,MedicineGenerator _mGen){
		this.pGen = _pGen;
		this.mGen = _mGen;
	}
	
	
	public List<MedicationHistory> generates(int size){
		List<MedicationHistory> result = new ArrayList<>();
		for(int i=0;i<size;i++){
			result.add(generator());
		}
		
		return result;
	}
	
	public MedicationHistory generator(){
		MedicationHistory mHistory = new MedicationHistory();
		
		Patient p = pGen.getPatient();
		mHistory.setPatientUuid(p.getUuid());
		mHistory.setPatientName(p.getName());
		
		mHistory.setEntryDate(GeneratorUtils.getDate());
		
		List<Medicine> meds = mGen.generateMedicines();
		meds.stream().forEach(item -> mHistory.addMedis(getMedicineData(item)));
		
		return mHistory;
	}
	
	private String getMedicineData(Medicine med){
		StringBuilder build = new StringBuilder();
		build.append(med.getName());
		build.append(" ");
		build.append(GeneratorUtils.getIntValueWithoutZero(5));
		build.append(med.getUnit());
		return build.toString();
	}
	
	

}
