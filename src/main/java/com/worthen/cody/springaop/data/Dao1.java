package com.worthen.cody.springaop.data;

import org.springframework.stereotype.Repository;

import com.worthen.cody.springaop.aspect.TrackTime;

@Repository
public class Dao1 {

	@TrackTime // we are only tracking execution time for this specific method
	public String retrieveSomething() {
		return "Dao1";
	}

}
