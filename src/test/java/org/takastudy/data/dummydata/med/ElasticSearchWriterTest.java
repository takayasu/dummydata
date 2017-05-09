package org.takastudy.data.dummydata.med;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.takastudy.data.dummydata.med.generator.MedicationHistoryGenerator;
import org.takastudy.data.dummydata.med.generator.MedicineGenerator;
import org.takastudy.data.dummydata.med.generator.PatientGenerator;
import org.takastudy.data.dummydata.med.io.es.ElasticSearchWriter;
import org.takastudy.data.dummydata.med.model.MedicationHistory;

public class ElasticSearchWriterTest {

	@Test
	public void test1() throws IOException {
		MedicineGenerator mGen = new MedicineGenerator("medidata/med.csv");
		PatientGenerator pGen = new PatientGenerator("data");
		
		MedicationHistoryGenerator gen = new MedicationHistoryGenerator(pGen, mGen);
		List<MedicationHistory> result = gen.generates(10000);
		
		ElasticSearchWriter esW = new ElasticSearchWriter();
		esW.addAll(result);
		
	}

}
