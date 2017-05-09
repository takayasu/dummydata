package org.takastudy.data.dummydata.med.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.takastudy.data.dummydata.med.model.Medicine;

public class MedicineReader {
	public static List<Medicine> read(String filePath) throws IOException{
		Path path = Paths.get(filePath);
		
		return MedicineReader.read(path);
	}
	
	public static List<Medicine> read(Path path) throws IOException{
		return Files.readAllLines(path).stream().map(line -> parse(line)).collect(Collectors.toList());
	}
	
	public static Medicine parse(String line){
		String[] items = line.split(",");
		
		Medicine med = new Medicine();
		med.setCode(deleteMark(items[2]));
		med.setName(deleteMark(items[4]));
		med.setPrice(deleteMark(items[11]));
		med.setUnit(deleteMark(items[9]));
		
		return med;
	}
	
	private static String deleteMark(String value){
		return value.substring(1, value.length()-1);
	}
	

}
