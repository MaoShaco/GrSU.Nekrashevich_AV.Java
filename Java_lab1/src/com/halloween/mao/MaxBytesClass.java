package com.halloween.mao;

import java.util.StringJoiner;

/**
 * Created by Mao on 3/28/2015.
 */
public class MaxBytesClass {
	String MaxReq;

	public MaxBytesClass(AccessLog maxReq) {
		MaxReq = maxReq.getRequest();
	}

}
