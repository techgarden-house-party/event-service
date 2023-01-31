package gg.techgarden.eventapp.event.data;

import com.mongodb.lang.NonNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Guest extends User {
    private String invitedBy;
    @Builder.Default
    private Boolean notified = Boolean.FALSE;
    private LocalDateTime notifiedDateTime;
    @Builder.Default
    private GUEST_STATUS status = GUEST_STATUS.UNKNOWN;
}
