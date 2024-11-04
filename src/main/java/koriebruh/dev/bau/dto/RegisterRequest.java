package koriebruh.dev.bau.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

    private String username;

    private String password;

    private String email;

}


