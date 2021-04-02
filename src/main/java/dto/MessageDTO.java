package dto;

import com.exercise.microservice.models.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class MessageDTO {
    private UUID id;
    private String content;



    public MessageDTO(Message message) {
        this.id = message.getId();
        this.content = message.getContent();
    }
}
