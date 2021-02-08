package org.ayty.hatcher.api.v1.profile.exception.handling;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfileStandardError implements Serializable{
	private Long timestamp;
	private Integer status;
	private String message;
	private String path;
}
