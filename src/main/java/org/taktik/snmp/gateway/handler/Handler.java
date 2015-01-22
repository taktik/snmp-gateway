package org.taktik.snmp.gateway.handler;

import org.snmp4j.CommandResponderEvent;

public interface Handler {
	public void handle(CommandResponderEvent trap);
}
