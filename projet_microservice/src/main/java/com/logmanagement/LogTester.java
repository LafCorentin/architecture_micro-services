package com.logmanagement;

import com.logs.GeneLog;

public abstract class LogTester {

	protected ConditionOnLog condt;
	
	public boolean testLog(GeneLog log) {
		return condt.tester(log);
	}
	
	public void majCond() {
		
	}
	
	public LogTester() {
		
	}
	
}
