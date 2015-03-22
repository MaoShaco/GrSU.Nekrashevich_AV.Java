package com.halloween.mao;

import java.util.Date;
import java.util.List;

/**
 * Created by Mao on 3/21/2015.
 */
public interface ILogSearcher {
    int binarySearch(Date key, List<AccessLog> list, float left, float right);
}
