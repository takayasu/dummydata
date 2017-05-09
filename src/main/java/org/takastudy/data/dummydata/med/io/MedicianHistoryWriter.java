package org.takastudy.data.dummydata.med.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.takastudy.data.dummydata.med.model.MedicationHistory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MedicianHistoryWriter {
	private static Logger log = LoggerFactory.getLogger(MedicianHistoryWriter.class);
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String converJSon(MedicationHistory mHistory) {
		String json = null;
		try {
			json = mapper.writeValueAsString(mHistory);
		} catch (JsonProcessingException e) {
			log.error(e.toString());
		}
		
		return json;
	}

}
