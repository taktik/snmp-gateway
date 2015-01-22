package org.taktik.snmp.trapmanager.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.CommandResponderEvent;

public class HandlerMappingsHandler implements Handler {
	private static final Logger log = LoggerFactory.getLogger(LogHandler.class);

	private List<HandlerMapping> mappings;
	private boolean warnIfNoHandlersFound = true;

	@Override
	public void handle(CommandResponderEvent trap) {
		boolean handled = false;
		for (HandlerMapping mapping : mappings) {
			if (mapping.getSelector().handles(trap)) {
				mapping.getHandler().handle(trap);
				handled = true;
				if (!mapping.isProcessOtherHandlers()) {
					return;
				}
			}
		}
		if (!handled && warnIfNoHandlersFound) {
			log.warn("No Handlers found for trap {}", trap);
		}
	}

	public HandlerMappingsHandler(List<HandlerMapping> mappings) {
		this.mappings = mappings;
	}

	public HandlerMappingsHandler() {
		this.mappings = new ArrayList<>();
	}

	public void addMapping(HandlerMapping mapping) {
		this.mappings.add(mapping);
	}

	public void removeMapping(HandlerMapping mapping) {
		this.mappings.remove(mapping);
	}

	public List<HandlerMapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<HandlerMapping> mappings) {
		this.mappings = mappings;
	}

	public boolean isWarnIfNoHandlersFound() {
		return warnIfNoHandlersFound;
	}

	public void setWarnIfNoHandlersFound(boolean warnIfNoHandlersFound) {
		this.warnIfNoHandlersFound = warnIfNoHandlersFound;
	}
}
