package org.takastudy.data.dummydata.med;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.takastudy.data.dummydata.med.io.MedicineReader;
import org.takastudy.data.dummydata.med.model.Medicine;

public class MedicineReaderTest {

	@Test
	public void test1() throws IOException {
		List<Medicine> list = MedicineReader.read("medidata/y.csv");
		
		assertThat(list.size(),is(20437));
	}

}
