package koriebruh.dev.bau.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admins")

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(nullable = false, length = 50)
    private String username ;

    @Column(nullable = false, length = 500)
    private String password ;

    @Column(length = 500)
    private String email ;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt ;

    @CreationTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt ;


}
