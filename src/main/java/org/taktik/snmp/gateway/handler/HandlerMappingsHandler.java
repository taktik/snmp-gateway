package org.taktik.snmp.gateway.handler;

import java.util.ArrayList;
import java.util.List;

import org.snmp4j.CommandResponderEvent;

public class HandlerMappingsHandler implements Handler {
	private List<HandlerMapping> mappings;

	@Override
	public void handle(CommandResponderEvent trap) {
		for (HandlerMapping mapping : mappings) {
			if (mapping.getSelector().handles(trap)) {
				mapping.getHandler().handle(trap);
				if (!mapping.isProcessOtherHandlers()) {
					return;
				}
			}
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
}
