package com.Test.Test.com.Test.Test;

import java.util.Iterator;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;




public class RESTAPI {
	
	private static String url = "https://opendata-ajuntament.barcelona.cat/data/api/3/action/package_search";
	private static final String CODE = "code";
	private static final String DESCRIPTION = "description";
	private static final String ORGANIZATION = "organization";
	private static final String URL_TORNADA = "url_tornada";
	private static String language;
	
	public  Result doRequest(String languagep,String urlp) {
		language = languagep;
		
		 mountFilterQuery();
		 		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		String response = target.request(MediaType.TEXT_HTML).get(String.class);
		
		Result result = getOrganizationData(new JSONObject(response).getJSONObject("result").getJSONArray("results"),0,
																													new Result());
			return result;
	}
	private  Result getOrganizationData(JSONArray results,int i,Result result) {
		
		if(i >= results.length())
			return result;
		
			JSONObject element = results.getJSONObject(i);
			runThroughKeys(element.keys(),element,result);
			
			return getOrganizationData(results,++i,result);
	}
	private  Result runThroughKeys(Iterator<String> keys, JSONObject element, Result result) {
		// TODO Auto-generated method stub
		if(!keys.hasNext()) 
			return result;
		
		Organization organization  = new Organization();				
		String k = keys.next().toString();
		
		if(k.equals(ORGANIZATION)) {
			organization.setCode(element.getJSONObject(k).getString(CODE));
			organization.setDesctiption(element.getJSONObject(k).getString(DESCRIPTION));
			result.getLo().add(organization);
		
		}		
		if(k.equals(URL_TORNADA)) {
			result.getUrl_tornada().add(element.getJSONObject(k).getString(getLanguageString()));
			
		}
		
				
		return runThroughKeys(keys,element,result);
		
		
	}
	private  String getLanguageString() {
		// TODO Auto-generated method stub
		Optional<String> stropt = Optional.ofNullable(language);
		return stropt.orElse("ca");
	}
	private  void mountFilterQuery() {
		url +="?facet.field=[" + "\"" +getLanguageString() + "\"" + "]";	
	}
	
}
