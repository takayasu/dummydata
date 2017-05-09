package org.takastudy.data.dummydata.med.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.takastudy.data.dummydata.med.model.Patient;
import org.takastudy.data.dummydata.med.model.type.BloodType;
import org.takastudy.data.dummydata.med.model.type.Gender;

public class PatientReader {
	
	public static List<Patient> readDirectory(String dirPath) throws IOException{
		Path dir = Paths.get(dirPath);
		
		List<Patient> list = new ArrayList<>();
		
		if(!Files.isDirectory(dir)){
			return PatientReader.read(dir);
		}else{
			try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir)) {
				for(Path path:ds){
					if(path.toString().endsWith("csv")){
						list.addAll(PatientReader.read(path));						
					}
					
				}
			}
			
			return list;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Patient> read(String filepath) throws IOException{
		Path path = Paths.get(filepath);
		
		return PatientReader.read(path);
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Patient> read(Path file) throws IOException{
		
		return Files.readAllLines(file).stream().map(line -> parse(line)).filter(elm -> elm != null ? true: false).collect(Collectors.toList());
		
	}
	
	private static Patient parse(String line){
		String[] items = line.split(",");
		
		if(items[0].equals("連番")){
			return null;
		}
		
		Patient p = new Patient();
		p.setNo(Integer.parseInt(items[0]));
		p.setName(items[1]);
		p.setKana(items[2]);
		p.setGender(Gender.of(items[3]));
		p.setTel(items[4]);
		p.setCell(items[5]);
		p.setPost(items[6]);
		p.setAddress1(items[7]);
		p.setAddress2(items[8]);
		p.setAddress3(items[9]);
		p.setAddress4(items[10]);
		p.setAddress5(items[11]);
		p.setBirthDay(items[12]);
		p.setBlood(BloodType.of(items[13]));
		
		return p;
		
	}
	

}
