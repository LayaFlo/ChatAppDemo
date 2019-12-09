package ServerProgramming.ChatAppProject.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // to enable the WebSocket server

//below is the implementation of WebSocketMessageBrokerConfigurer interface and some of its methods
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	// register a websoket endpoint that the clients will use to connect to the
	// websocket server
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// Simple Text Oriented Messaging Protocol is a messaging protocol that defines
		// the format and rules for data exchange
		registry.addEndpoint("/ws").withSockJS(); // SockJS is used to enable fallback options for browsers that don’t
													// support websocket
	}

	@Override
	// configuring a message broker that will be used to route messages from one
	// client to another
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app"); // the messages whose destination starts with “/app” should
															// be routed to message-handling methods
		registry.enableSimpleBroker("/topic"); // the messages whose destination starts with “/topic” should be routed
												// to the simple in-memory message broker
	}
}
