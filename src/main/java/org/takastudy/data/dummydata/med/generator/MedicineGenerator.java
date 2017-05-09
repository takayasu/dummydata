package org.takastudy.data.dummydata.med.generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.takastudy.data.dummydata.med.io.MedicineReader;
import org.takastudy.data.dummydata.med.model.Medicine;

public class MedicineGenerator {
	
	private List<Medicine> list;
	
	public MedicineGenerator(String filepath) throws IOException{
		list = MedicineReader.read(filepath);
	}
	
	public List<Medicine> generateMedicines(){
		
		List<Medicine> result = new ArrayList<>();
		
		int count = GeneratorUtils.getIntValueWithoutZero(10);
		for(int i=0;i<count;i++){
			result.add(list.get(GeneratorUtils.getIntValue(list.size())));
		}
		
		return result;
	}
	

}
