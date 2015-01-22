package org.taktik.snmp.gateway.handler;

import org.snmp4j.CommandResponderEvent;

@FunctionalInterface
public interface TrapSelector {
	public boolean handles(CommandResponderEvent commandResponderEvent);
}
