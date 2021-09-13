package com.apiamericanas.api.resource.models;

import java.io.Serializable;
import java.util.List;

public class StarWarsList<T> implements Serializable {
    public int count;
    public String next;
    public String previous;
    public List<T> results;

    public boolean hasMore() {
        return (next != null && !next.isEmpty());
    }
}
