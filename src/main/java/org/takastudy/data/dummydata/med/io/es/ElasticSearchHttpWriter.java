package org.takastudy.data.dummydata.med.io.es;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.takastudy.data.dummydata.med.io.MedicianHistoryWriter;
import org.takastudy.data.dummydata.med.model.MedicationHistory;

public class ElasticSearchHttpWriter {

	private RestClient restClient;
	
	public ElasticSearchHttpWriter(){
		restClient = RestClient.builder(
		        new HttpHost("localhost", 9200, "http")).build();
	}
	
	public void send(List<MedicationHistory> list){
		list.stream().forEach(elm -> {
			HttpEntity entity = null;
			try {
				entity = new StringEntity(MedicianHistoryWriter.converJSon(elm),Charset.forName("UTF-8"));
				Header header = new BasicHeader("Content-Type", "application/json; charset=utf-8");
				restClient.performRequest("PUT", "/history/history/"+UUID.randomUUID().toString(), 
								Collections.<String,String>emptyMap(),entity,header);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	
}
