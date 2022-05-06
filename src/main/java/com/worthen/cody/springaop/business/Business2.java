package com.worthen.cody.springaop.business;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.worthen.cody.springaop.data.Dao2;

@Service
public class Business2 {

	private Dao2 dao2;

	public Business2(@Qualifier("dao2") Dao2 dao2) {
		this.dao2 = dao2;
	}

	public String calculateSomething() {
		return dao2.retrieveSomething();
	}

}
