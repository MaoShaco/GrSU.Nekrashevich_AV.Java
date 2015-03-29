package com.halloween.mao;

/**
 * Created by Mao on 3/28/2015.
 */
public class TotalSumBytesClass {
	int Sum;

	public TotalSumBytesClass(int Sum) {
		this.Sum = Sum;
	}

	public String toString() {
		return String.format("Max amount of bytes = " + this.Sum);
	}
}
