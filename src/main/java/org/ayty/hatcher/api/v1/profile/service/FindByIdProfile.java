package org.ayty.hatcher.api.v1.profile.service;

import org.ayty.hatcher.api.v1.profile.entity.Profile;

@FunctionalInterface
public interface FindByIdProfile {
	Profile findById(long id);
}
