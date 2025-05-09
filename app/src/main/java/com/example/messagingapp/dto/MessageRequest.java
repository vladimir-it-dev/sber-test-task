package com.example.messagingapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Запрос для обработки сообщения")
public class MessageRequest {

    @Schema(description = "Уникальный идентификатор сообщения",
            example = "550e8400-e29b-41d4-a716-446655440000")
    @NotNull(message = "Идентификатор сообщения обязателен")
    private UUID id;

    @Schema(description = "Текст сообщения",
            example = "Пример текста сообщения")
    @NotBlank(message = "Текст сообщения не может быть пустым")
    @Size(min = 1, max = 3000, message = "Длина сообщения должна быть от 1 до 3000 символов")
    private String content;

    @Schema(description = "Временная метка создания",
            example = "2023-10-25T12:00:00Z",
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    @NotNull(message = "Временная метка обязательна")
    @PastOrPresent(message = "Временная метка не может быть в будущем")
    private Instant timestamp;

}
