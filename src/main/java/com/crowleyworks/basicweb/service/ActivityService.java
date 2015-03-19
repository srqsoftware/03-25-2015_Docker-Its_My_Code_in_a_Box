package com.crowleyworks.basicweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.crowleyworks.basicweb.model.Activity;

public class ActivityService {
	
	private Map<Integer, Activity> activities = new HashMap<Integer, Activity>();
	int counter = 0;
	
	public void create(Activity a) throws Exception {
		counter++;
		a.setId(counter);
		activities.put(new Integer(counter), a);
	}
	
	public void update(final Activity a) throws Exception {
		Activity existing = activities.get(a.getId());
		if (existing == null) {
			throw new Exception("Existing activity doesn't exist");
		}
		activities.put(a.getId(), a);
	}
	
	public void delete(final Integer id) throws Exception {
		if (activities.remove(id) == null) {
			throw new Exception("Activity can't be deleted - it doesn't exist.");
		}
	}
	
	public Activity get(int id) throws Exception {
		Integer i = new Integer(id);
		Activity a = activities.get(i);
		if (a == null) {
			throw new Exception("Activity does not exist");
		}
		return a;
	}
	
	public List<Activity> getMany() {
		return new ArrayList<Activity>(activities.values());
	}
	

}
