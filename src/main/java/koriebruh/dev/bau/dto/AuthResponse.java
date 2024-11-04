package koriebruh.dev.bau.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AuthResponse {

    private String token;

    private String message;

}
