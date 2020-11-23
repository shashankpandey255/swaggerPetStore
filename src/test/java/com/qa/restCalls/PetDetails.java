package com.qa.restCalls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetDetails {
	String Status;
	Map<String,Object> petDetails=new HashMap();
	public Map<String,Object> createPet() {
		List<Map<String,Object>> tags=new ArrayList<Map<String, Object>>();
		Map<String,Object> tag=new HashMap<String,Object>();
		tag.put("id", "5656");
		tag.put("name", "string");
		tags.add(tag);
		
		List<Object> photoUrl=new ArrayList<Object>();
		photoUrl.add("string");
		
		Map<String,Object> category=new HashMap<String,Object>();
		category.put("id", "0");
		category.put("name", "string");
		
		
		petDetails.put("id", "8585");
		petDetails.put("category", category);
		petDetails.put("name", "Tommy");
		petDetails.put("photoUrls", photoUrl);
		petDetails.put("tags", tags);
		petDetails.put("status", getStatus());
		return petDetails;
	}
	public void setStatus(String status) {
		Status=status;
	}
	public String getStatus() {
		return Status;
	}

}
