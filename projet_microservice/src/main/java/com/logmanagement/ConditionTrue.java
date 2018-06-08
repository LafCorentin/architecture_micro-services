package com.logmanagement;

import com.logs.GeneLog;

public class ConditionTrue implements ConditionOnLog {

	@Override
	public boolean tester(GeneLog log) {
		return true;
	}
}
