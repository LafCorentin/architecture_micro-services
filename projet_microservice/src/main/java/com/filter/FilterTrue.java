package com.filter;

import com.logs.GeneLog;

public class FilterTrue extends AbstractFilter {

	@Override
	public boolean tester(GeneLog log) {
		return true;
	}
}
