package com.Redis;

public interface KeyPrefix {
    public int expireSeconds();
    public String getPrefix();
}
