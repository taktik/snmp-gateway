package org.taktik.snmp.gateway.handler;

import org.snmp4j.CommandResponderEvent;

public class HandlerWrapper implements Handler{
	protected Handler handler;

	public HandlerWrapper(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void handle(CommandResponderEvent trap) {
		handler.handle(trap);
	}
}
