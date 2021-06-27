package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BinanceRequestDto {
    private String url;
    private Rtype requestType;
    private HashMap headers;
    private String body;

    public String getRequestType() {
        return requestType.name();
    }
}
