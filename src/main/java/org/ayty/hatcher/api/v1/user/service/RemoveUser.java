package org.ayty.hatcher.api.v1.user.service;

@FunctionalInterface
public interface RemoveUser {

	void removeUser(String login, String password);
	
}
