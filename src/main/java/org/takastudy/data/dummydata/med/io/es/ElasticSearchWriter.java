package org.takastudy.data.dummydata.med.io.es;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.takastudy.data.dummydata.med.io.MedicianHistoryWriter;
import org.takastudy.data.dummydata.med.model.MedicationHistory;

public class ElasticSearchWriter {
	
	private TransportClient client;
	private Node node;
	
	@SuppressWarnings("resource")
	public ElasticSearchWriter(){
//		Settings settings = Settings.builder()
//			    .put("cluster.name", "elasticsearch")
//			    .put("http.port", 11547)
//			    .put("transport.tcp.port", 9300)
//			    .build();
		try {
//			node = NodeBuilder.nodeBuilder().local(true).settings(settings).node();
			client = new PreBuiltTransportClient(Settings.EMPTY)
					.addTransportAddress(new InetSocketTransportAddress(
							InetAddress.getByName("localhost"), 9300));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void addAll(List<MedicationHistory> list){
		
		if(list.size() >= 10000){
			throw new RuntimeException("Count is bigger. Use addBatch.");
		}
		
		BulkRequestBuilder bulkRequest = client.prepareBulk();
		
		list.stream().forEach(elm -> {
			bulkRequest.add(client.prepareIndex("hisotry", "history",elm.getPatientUuid()).
					setSource(MedicianHistoryWriter.converJSon(elm)));
		});
		
		BulkResponse res = bulkRequest.get();
	}
	
	public void shutdown(){
		client.close();
	}

}