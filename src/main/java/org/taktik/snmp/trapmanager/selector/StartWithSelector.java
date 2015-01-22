package org.taktik.snmp.trapmanager.selector;

import org.snmp4j.CommandResponderEvent;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.VariableBinding;


public class StartWithSelector implements TrapSelector {

	private OID prefix;

	public StartWithSelector(OID prefix) {
		this.prefix = prefix;
	}

	@Override
	public boolean handles(CommandResponderEvent commandResponderEvent) {
		return commandResponderEvent.getPDU().getVariableBindings().stream().anyMatch((obj)-> ((VariableBinding)obj).getOid().startsWith(prefix));
	}

	public OID getPrefix() {
		return prefix;
	}
}
