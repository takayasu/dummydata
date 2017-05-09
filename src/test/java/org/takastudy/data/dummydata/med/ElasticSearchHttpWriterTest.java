package org.takastudy.data.dummydata.med;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.takastudy.data.dummydata.med.generator.MedicationHistoryGenerator;
import org.takastudy.data.dummydata.med.generator.MedicineGenerator;
import org.takastudy.data.dummydata.med.generator.PatientGenerator;
import org.takastudy.data.dummydata.med.io.MedicianHistoryWriter;
import org.takastudy.data.dummydata.med.io.es.ElasticSearchHttpWriter;
import org.takastudy.data.dummydata.med.model.MedicationHistory;

public class ElasticSearchHttpWriterTest {

	@Test
	public void test1() throws IOException {
		MedicineGenerator mGen = new MedicineGenerator("medidata/med.csv");
		PatientGenerator pGen = new PatientGenerator("data");
		
		MedicationHistoryGenerator gen = new MedicationHistoryGenerator(pGen, mGen);

		List<MedicationHistory> list = gen.generates(1500000);
//		list.stream().map(elm -> MedicianHistoryWriter.converJSon(elm)).forEach(System.out::println);
		
		ElasticSearchHttpWriter writer = new ElasticSearchHttpWriter();
		writer.send(list);
		
		
	}

}
