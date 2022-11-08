package com.ct.util;

import java.text.DecimalFormat;
import java.util.Arrays;

public class UtilDemo {
	public static String arrToString(String[] arr) {
		String tmp = Arrays.toString(arr);
		tmp = tmp.substring(1, tmp.length() - 1);
		tmp = tmp.replaceAll(" ", "");
		return tmp;
	}

	public static String[] stringToArray(String str) {
		String[] tmp = str.split(",");
		return tmp;
	}

	public static String round(double data) {
		DecimalFormat df = new DecimalFormat("#.00");
		String s = df.format(data);
		return s;
	}
}
