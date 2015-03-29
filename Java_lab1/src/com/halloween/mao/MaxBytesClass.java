package com.halloween.mao;

import java.util.StringJoiner;

/**
 * Created by Mao on 3/28/2015.
 */
public class MaxBytesClass {
	int Bytes;

	public MaxBytesClass(int bytes) {
		Bytes = bytes;
	}

	public String toString() {
		return String.format("Max amount of bytes = " + this.Bytes);
	}
}
