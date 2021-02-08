package org.ayty.hatcher.api.v1.profile.service;

import java.util.List;

import org.ayty.hatcher.api.v1.profile.entity.Profile;

@FunctionalInterface
public interface ListProfile{
	public List<Profile> findAll();
}
