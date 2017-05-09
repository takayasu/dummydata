package org.takastudy.data.dummydata.med;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.takastudy.data.dummydata.med.generator.MedicationHistoryGenerator;
import org.takastudy.data.dummydata.med.generator.MedicineGenerator;
import org.takastudy.data.dummydata.med.generator.PatientGenerator;
import org.takastudy.data.dummydata.med.io.MedicianHistoryWriter;
import org.takastudy.data.dummydata.med.model.MedicationHistory;

public class MedicationHisotryGeneratorTest {

	
	@Test
	public void test1() throws IOException {
		MedicineGenerator mGen = new MedicineGenerator("medidata/y.csv");
		PatientGenerator pGen = new PatientGenerator("data");
		
		MedicationHistoryGenerator gen = new MedicationHistoryGenerator(pGen, mGen);
		List<MedicationHistory> result = gen.generates(10000);
		
		assertThat(result.size(),is(10000));
		
		List<String> cResult = result.stream().map(MedicianHistoryWriter::converJSon).collect(Collectors.toList());
		
		assertThat(cResult.size(),is(10000));
	}
	
	@Test
	public void test2() throws IOException{
		MedicineGenerator mGen = new MedicineGenerator("medidata/y.csv");
		PatientGenerator pGen = new PatientGenerator("data");
		
		MedicationHistoryGenerator gen = new MedicationHistoryGenerator(pGen, mGen);
		List<MedicationHistory> result = gen.generates(2);
		
		result.stream().map(MedicianHistoryWriter::converJSon).forEach(System.out::println);
	}

}
