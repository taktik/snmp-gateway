package org.taktik.snmp.trapmanager.handler;

import org.snmp4j.CommandResponderEvent;

public interface Handler {
	public void handle(CommandResponderEvent trap);
}
