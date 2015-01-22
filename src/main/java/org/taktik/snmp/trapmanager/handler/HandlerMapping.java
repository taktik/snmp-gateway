package org.taktik.snmp.trapmanager.handler;

import org.taktik.snmp.trapmanager.selector.TrapSelector;

public class HandlerMapping {
	private Handler handler;
	private boolean processOtherHandlers;
	private TrapSelector selector;

	public HandlerMapping(Handler handler, TrapSelector selector) {
		this.handler = handler;
		this.processOtherHandlers = false;
		this.selector = selector;
	}

	public HandlerMapping(Handler handler, boolean processOtherHandlers, TrapSelector selector) {
		this.handler = handler;
		this.processOtherHandlers = processOtherHandlers;
		this.selector = selector;
	}

	public Handler getHandler() {
		return handler;
	}

	public boolean isProcessOtherHandlers() {
		return processOtherHandlers;
	}

	public TrapSelector getSelector() {
		return selector;
	}
}
