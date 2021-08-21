package com.util.message.queue;

import com.util.message.queue.model.dto.RequestEmail;
import com.util.message.queue.services.rabbit.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private MessageSender sender;

	@RequestMapping(value = "send", method = RequestMethod.POST)
		public void send(@RequestBody RequestEmail emailBody) {
		sender.send(emailBody);
	}
}
