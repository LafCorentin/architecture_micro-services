package com.logs;

import java.util.Date;

public class LogSimpleString extends GeneLog {

	LogSimpleString(String data) {
		super(data);
	}

	@Override
	public int getID() {
		return 0;
	}

	@Override
	public Date getDate() {
		return null;
	}

	@Override
	public String getHostname() {
		return null;
	}

	@Override
	public int getFacility() {
		return 0;
	}

	@Override
	public int getSeverityLvl() {
		return 0;
	}

	@Override
	public String getMSG() {
		return null;
	}
	
	@Override
	public String toString() {
		return data;
	}
}
