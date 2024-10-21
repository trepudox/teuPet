package com.teupet.animal.core.exception.handler.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessageDTO {

    private String description;
    private String errorMessage;
    private int status;
    private LocalDateTime timestamp;

}
