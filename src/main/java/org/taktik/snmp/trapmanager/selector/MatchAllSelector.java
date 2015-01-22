package org.taktik.snmp.trapmanager.selector;

import org.snmp4j.CommandResponderEvent;

public class MatchAllSelector implements TrapSelector {
	@Override
	public boolean handles(CommandResponderEvent commandResponderEvent) {
		return true;
	}
}
