package com.halloween.mao;

import java.util.*;

/**
 * Created by Mao on 3/22/2015.
 */
public class MostOften extends PreReportGenerater implements IReportGenerater {
	public MostOften(ILogSearcher logSearcher) {
		super(logSearcher);
	}

	@Override
	public List<Host> Report(int starterData, int finalData, List<AccessLog> Logs) {
		this.Logs = Logs;

		Map<String, Integer> Dict = new HashMap<String, Integer>();
		for (AccessLog str : findByDate(starterData, finalData)) {
			if (Dict.containsKey(str.getLocalHost().toString()))
				Dict.put(str.getLocalHost().toString(), Dict.get(str.getLocalHost().toString()) + 1);
			else
				Dict.put(str.getLocalHost().toString(), 1);
		}

		List list = new ArrayList(Dict.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> b, Map.Entry<String, Integer> a) {
				return a.getValue().compareTo(b.getValue());
			}
		});
		int subListIndex = 5;
		if (list.size() < 5)
			subListIndex = list.size();

		return list.subList(0, subListIndex);
	}
}
