package com.Test.Test.com.Test.Test;

import java.util.ArrayList;
import java.util.List;

public class Result {
	private List<Organization> lo;
	private List<String> url_tornada;
	
	public Result() {
		super();
		this.lo = new ArrayList<>();
		this.url_tornada = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Result [lo=" + lo + ", url_tornada=" + url_tornada + "]";
	}

	public List<Organization> getLo() {
		return lo;
	}

	public void setLo(List<Organization> lo) {
		this.lo = lo;
	}

	public List<String> getUrl_tornada() {
		return url_tornada;
	}

	public void setUrl_tornada(List<String> url_tornada) {
		this.url_tornada = url_tornada;
	}

}
