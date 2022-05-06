package com.worthen.cody.springaop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Business1 {

	private Dao1 dao1;

	public Business1(@Qualifier("dao1") Dao1 dao1) {
		this.dao1 = dao1;
	}

	public String calculateSomething() {
		return dao1.retrieveSomething();
	}

}
