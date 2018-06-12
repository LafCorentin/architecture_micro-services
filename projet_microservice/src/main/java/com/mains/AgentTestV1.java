package com.mains;

import com.logmanagement.LogSender;

public class AgentTestV1 {

	public static void main(String[] args) {
		LogSender agent = new LogSender("input.log");
		try {
			agent.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
