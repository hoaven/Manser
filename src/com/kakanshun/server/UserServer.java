package com.kakanshun.server;

import java.io.IOException;

import com.kakanshun.domain.Pas;

public interface UserServer {
	public String getPassword(String username) throws IOException;
}
