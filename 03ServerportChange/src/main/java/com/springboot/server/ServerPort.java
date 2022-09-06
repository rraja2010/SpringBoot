package com.springboot.server;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ServerPort implements TomcatConnectorCustomizer {

	@Override
	public void customize(Connector connector) {
		//to change the port
		connector.setPort(2050);
	}
}
