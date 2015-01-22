package org.taktik.snmp.trapmanager.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.CommandResponderEvent;

public class LogHandler extends HandlerWrapper {
	private static final Logger log = LoggerFactory.getLogger(LogHandler.class);

	public LogHandler(Handler handler) {
		super(handler);
	}

	@Override
	public void handle(CommandResponderEvent trap) {
		try {
			log.info("Received trap : {}", trap);
		} finally {
			super.handle(trap);
		}
	}
}
