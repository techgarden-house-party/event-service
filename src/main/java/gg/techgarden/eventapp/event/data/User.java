package gg.techgarden.eventapp.event.data;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User {
    private String id;
    private String name;
    private String email;
    private String phone;
}
