package com.olddrivers.tickets.web.controllers.response;

import java.util.LinkedHashMap;

public class AbstractResponse extends LinkedHashMap<String, Object> {
	
	private static final long serialVersionUID = 1L;

	public AbstractResponse() {
        super();
    }

    public AbstractResponse(LinkedHashMap<String, Object> m) {
        super(m);
    }

}