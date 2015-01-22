package org.taktik.snmp.trapmanager.selector;

import org.snmp4j.CommandResponderEvent;

@FunctionalInterface
public interface TrapSelector {
	public boolean handles(CommandResponderEvent commandResponderEvent);
}
