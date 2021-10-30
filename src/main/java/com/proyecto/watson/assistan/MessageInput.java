package com.proyecto.watson.assistan;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
 
public class MessageInput extends GenericModel {

	@JsonProperty("input")
	private Input input;

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

}
