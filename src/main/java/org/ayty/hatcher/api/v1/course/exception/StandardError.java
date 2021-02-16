package org.ayty.hatcher.api.v1.course.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

    private Integer status;
    private Long timestamp;
    private String message;

}