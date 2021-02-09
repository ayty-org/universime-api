package org.ayty.hatcher.api.v1.competence.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ErrorDetails {

	private String code;
	private String message;
	private List<String> errors;
	
}
