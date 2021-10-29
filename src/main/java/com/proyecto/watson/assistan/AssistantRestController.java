package com.proyecto.watson.assistan;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.MessageInputStateless;
import com.ibm.watson.assistant.v2.model.MessageResponseStateless;
import com.ibm.watson.assistant.v2.model.MessageStatelessOptions;

@RestController
public class AssistantRestController {

	@Value("${ibm.assistant.apikey}")
	private String assistantApikey;

	@Value("${ibm.assistant.version.date}")
	private String assistantVersionDate;

	@Value("${ibm.assistant.service.url}")
	private String assistantServiceUrl;

	@Value("${ibm.assistant.id}")
	private String assistantId;

	private Assistant service;

	@PostConstruct
	public void init() {
		IamAuthenticator authenticator = new IamAuthenticator.Builder().apikey(assistantApikey).build();
		service = new Assistant(assistantVersionDate, authenticator);
		service.setServiceUrl(assistantServiceUrl);
	}

	@PostMapping("/api/message")
	public String message(@RequestBody MessageInput messageInput) {

		String text = messageInput.getInput() == null ? "" : messageInput.getInput().getText();

		MessageInputStateless input = new MessageInputStateless.Builder().messageType("text").text(text).build();

		MessageStatelessOptions options = new MessageStatelessOptions.Builder().assistantId(assistantId).input(input)
				.build();

		MessageResponseStateless response = service.messageStateless(options).execute().getResult();

		return response.toString();
	}

}
