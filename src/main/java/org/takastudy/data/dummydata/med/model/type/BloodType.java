package org.takastudy.data.dummydata.med.model.type;

public enum BloodType {
	O("O"),
	A("A"),
	B("B"),
	AB("AB"),
	;
	
	private String type;
	
	private BloodType(String _value){
		this.type = _value;
	}
	
	public static BloodType of(String _value){
		for(BloodType blood: values()){
			if(blood.type.equals(_value)){
				return blood;
			}
		}
		
		return null;
	}
	

}
