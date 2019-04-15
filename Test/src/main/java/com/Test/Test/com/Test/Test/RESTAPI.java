package com.Test.Test.com.Test.Test;

import javax.ws.rs.core.MediaType;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.util.Optional;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;



public class RESTAPI {
	
	private static String url = "https://opendata-ajuntament.barcelona.cat/data/api/3/action/package_search";
	
	public static void doRequest(String language) {
		SolrQuery query = mountFilterQuery(language);
		QueryResponse qr = new QueryResponse();
		
		 		
		
		HttpSolrClient solr = new HttpSolrClient.Builder(url).build();
		solr.setParser(new XMLResponseParser());
		
		try {
			 qr = solr.query(query);
			
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SolrDocumentList sdl = qr.getResults();
		
		sdl.forEach(doc -> {
			System.out.println(doc.getFieldValue("organization.code"));
			System.out.println(doc.getFieldValue("organization.description"));
		});
		
		
	}
	private static SolrQuery mountFilterQuery(String language) {
		Optional<String> stropt = Optional.ofNullable(language);
		SolrQuery query = new SolrQuery();
		
		query.setQuery("*:*");
		
		return query;
		
		//url +="?facet.field=[" + "\"" +stropt.orElse("ca") + "\"" + "]";	
	}
}
