package koriebruh.dev.bau.dto;


import lombok.*;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginRequest {

    private String username;

    private String password;

}
