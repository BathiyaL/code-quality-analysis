package com.moduleB.basicRules;

public class RulesRelatesToIFCondition {

	String condition;
	public RulesRelatesToIFCondition(String condition) {
		this.condition = condition;
	}
	
	private boolean isConditionLenghtGreaterThan5() {
		if(condition != null && !condition.equals("")) {
			if(condition.length() > 5)
				return true;
		}
		return false;
	}
}
