package br.com.fiap.route;

import java.io.File;

import org.apache.camel.builder.RouteBuilder;

public class Producer extends RouteBuilder {
	
	private String path = "file:" + new File(".").getAbsolutePath() + "/inputFolder";
	private String queue = "jms:queue:camel-activemq";

	@Override
	public void configure() throws Exception {
		from(path).to(queue);
	}
}
