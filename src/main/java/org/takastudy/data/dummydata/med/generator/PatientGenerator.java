package org.takastudy.data.dummydata.med.generator;

import java.io.IOException;
import java.util.List;

import org.takastudy.data.dummydata.med.io.PatientReader;
import org.takastudy.data.dummydata.med.model.Patient;

public class PatientGenerator {
	
	private List<Patient> list;
	
	public PatientGenerator(String dirPath) throws IOException{
		list = PatientReader.readDirectory(dirPath);
	}
	
	public Patient getPatient(){
		return list.get(GeneratorUtils.getIntValue(list.size()));
	}

}
