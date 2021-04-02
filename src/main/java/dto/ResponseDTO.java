package dto;

import lombok.Data;

@Data
public class ResponseDTO<T> {
    private String message;
    private Integer code;
    private Boolean error;
    private T value;

    public ResponseDTO() {
    }

    public ResponseDTO( T value,Integer code) {
        this.code = code;
        this.value = value;
    }

    public ResponseDTO(String message, Boolean error, T value) {
        this.message = message;
        this.error = error;
        this.value = value;
    }

    public ResponseDTO(String message, Integer code, Boolean error, T value) {
        this.message = message;
        this.code = code;
        this.error = error;
        this.value = value;
    }
}
