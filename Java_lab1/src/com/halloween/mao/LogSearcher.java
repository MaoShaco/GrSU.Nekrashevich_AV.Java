package com.halloween.mao;

import java.util.Date;
import java.util.List;

/**
 * Created by Mao on 3/21/2015.
 */
public class LogSearcher implements ILogSearcher {
	@Override

	public int binarySearch(Date key, List<AccessLog> list, float left, float right) {

		float mid = (left + right) / 2;

		if (left == mid || mid == right)
			return (int) mid;

		if (list.get((int) mid).getTimestamp().after(key))
			return binarySearch(key, list, left, mid);
		else
			return binarySearch(key, list, mid, right);
	}
}
