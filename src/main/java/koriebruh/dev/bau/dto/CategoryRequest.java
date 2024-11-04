package koriebruh.dev.bau.dto;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategoryRequest {

    private String name;

    private String description;

}
