package org.ayty.hatcher.api.v1.course.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@AllArgsConstructor
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class StandardError {

    @Getter @Setter private Integer status;
    @Getter @Setter private Long timestamp;
    @Getter @Setter private String message;

}