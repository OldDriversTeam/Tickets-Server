package com.olddrivers.tickets.util;


public enum Gender {
	MALE("MALE"), FEMALE("FEMALE");

    private String type;

    public static Gender parse(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null for Gender");
        }
        if (type.toUpperCase().equals("MALE")) {
            return MALE;
        } else if (type.toUpperCase().equals("FEMALE")) {
            return FEMALE;
        }
        throw new IllegalArgumentException("Type \"" + type + "\" does not correspond to any Gender");
    }
    
    
    private Gender(String type) {
        this.type = type;
    }
    
    
    public String getType() {
        return this.type;
    }
    
    
    @Override
    public String toString() {
        return getType();
    }
}
