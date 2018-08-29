package br.com.fiap.main;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import br.com.fiap.route.Producer;

public class MainProducer {
	
	public static void main(String[] args) {
	
		String connection = "tcp://0.0.0.0:61616";	
		
		Producer producer = new Producer();
		CamelContext ctx = new DefaultCamelContext();
		ConnectionFactory connFactory = new ActiveMQConnectionFactory(connection);
		
		ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connFactory));
		
		try {
			
			ctx.addRoutes(producer);
			ctx.start();
			
			Thread.sleep(300_000);
			
			ctx.stop();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}	
}