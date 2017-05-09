package org.takastudy.data.dummydata.med.model.type;

public enum Gender {
	MAILE("男"),
	FAMALE("女"),
	;
	
	private String value;
	private Gender(String _value){
		this.value = _value;
	}
	
	public static Gender of(String _value){
		for(Gender gen :values()){
			if(gen.value.equals(_value)){
				return gen;
			}
		}
		
		return null;
	}

}
