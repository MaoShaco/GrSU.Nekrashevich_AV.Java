package com.halloween.mao;

import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by Mao on 3/7/2015.
 */
public class Host {

	private String localHost;
	private Vector<Integer> iPv4 = new Vector<Integer>();

	public Host(String localHost) {

		this.localHost = localHost;
		if (localHost.matches("\\d+.\\d+.\\d+.\\d+")) {
			for (String item : localHost.split("\\.")) {
				iPv4.add(Integer.parseInt(item));
			}
		}
	}

	public String toString() {
		if (iPv4.isEmpty())
			return this.localHost;
		else {
			StringBuilder iPv4str = new StringBuilder();

			for (int i : iPv4) {
				iPv4str.append(String.format("[" + i + "]"));
			}
			return iPv4str.toString();
		}
	}
}
