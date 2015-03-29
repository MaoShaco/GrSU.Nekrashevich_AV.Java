package com.halloween.mao;

import java.util.List;

/**
 * Created by Mao on 3/14/2015.
 */
public interface IWriter {
	<Type> void write(String fileName, List<Type> text);
}
