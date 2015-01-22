package org.taktik.snmp.trapmanager.selector;

import org.snmp4j.smi.OID;

public class Selectors {
	public static TrapSelector startWith(OID prefix) {
		return new StartWithSelector(prefix);
	}

	public static TrapSelector matchAll() {
		return new MatchAllSelector();
	}
}
