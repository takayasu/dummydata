package org.takastudy.data.dummydata.med;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.takastudy.data.dummydata.med.io.PatientReader;
import org.takastudy.data.dummydata.med.model.Patient;

public class PatientReaderTest {

	@Test
	public void test1() throws IOException {
		List<Patient> list = PatientReader.read("person.csv");
		assertThat(list.size(), is(2000));
	}

	@Test
	public void test2() throws IOException {
		List<Patient> list = PatientReader.read("data/person1.csv");
		assertThat(list.size(), is(5000));
	}
	
	@Test
	public void test3() throws IOException {
		List<Patient> list = PatientReader.readDirectory("data");
		assertThat(list.size(), is(25000));
	}
}
