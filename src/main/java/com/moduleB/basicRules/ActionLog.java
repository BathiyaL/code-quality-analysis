package com.moduleB.basicRules;

public class ActionLog {

	private String element;
	private String value;
	private String errorMssage;
	private Throwable stackTrace;
	private String stackTraceString;
	private String actionLogString;
	private String returnValue;
	private String warning;

	public String getErrorMssage() {
		return errorMssage;
	}

	public void setErrorMssage(String errorMessage) {
		this.errorMssage = errorMessage;
	}

	public Throwable getStackTrace() {
		return stackTrace;
	}

	public void setgetStackTrace(Throwable error) {
		this.stackTrace = error;
	}

	public String getStackTraceString() {
		return stackTraceString;
	}

	public void setStackTraceString(String stackTraceString) {
		this.stackTraceString = stackTraceString;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getTextValue() {
		return value;
	}

	public void setTextValue(String textValue) {
		this.value = textValue;
	}

	public String getActionLogString() {
		return actionLogString;
	}

	public void setActionLogString(String actionLogString) {
		this.actionLogString = actionLogString;
	}

	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {

		this.actionLogString = returnValue;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

}