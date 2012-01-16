package com.gmail.mizuno.tamaki.tUrl.args;

import java.util.ArrayList;
import java.util.List;

public class Args {
	List<String> urls;

	public Args(List<String> urls) {
		// TODO Auto-generated constructor stub
		this.urls = urls;
	}

	public static Args parse(String[] args) {
		// TODO Auto-generated method stub
		List<String> urls = new ArrayList<String>();
		for (String url : urls) {
			urls.add(url);
		}
		return new Args(urls);
	}

}
