package dev.fringe.service;

import dev.fringe.atmosphere.AtmosphereResourceSupport;
import dev.fringe.domain.Message;
import org.atmosphere.config.service.ManagedService;

@ManagedService(path = "/message")
public class MessageService extends AtmosphereResourceSupport<Message> {}
