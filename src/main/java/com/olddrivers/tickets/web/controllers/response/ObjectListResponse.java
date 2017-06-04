package com.olddrivers.tickets.web.controllers.response;

import java.util.ArrayList;
import java.util.Collection;

public class ObjectListResponse extends AbstractResponse {
	
	private static final long serialVersionUID = 1L;

	public <T> ObjectListResponse() {
        this(new ArrayList<T>(), "empty");
    }

    public <T> ObjectListResponse(Collection<T> list, String listName) {
        put("size", list.size());
        put(listName, list);
    }
}
