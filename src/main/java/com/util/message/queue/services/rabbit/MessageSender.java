package com.util.message.queue.services.rabbit;

import com.util.message.queue.model.dto.RequestEmail;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;


/**
 * Clase que envia mensaje a la cola con el contenido
 * 
 * @author fureche
 *
 */
public class MessageSender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue queue;

	@Autowired
	private Gson gson;

	public void send(RequestEmail message) {
		this.template.convertAndSend(queue.getName(), gson.toJson(message));
	}

	public void send(String message) {
		this.template.convertAndSend(queue.getName(), gson.toJson(message));
	}

}
