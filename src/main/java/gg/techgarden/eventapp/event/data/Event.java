package gg.techgarden.eventapp.event.data;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

@Document
@Data
@Builder
public class Event {
    @Id
    private String id;
    @NonNull
    private User host;
    @NonNull
    private String title;
    private String description;
    @Builder.Default
    private LocalDateTime startDateTime = LocalDateTime.now();
    private LocalDateTime endDateTime;
    private String location;
    @Builder.Default
    private Boolean isAllDay = Boolean.FALSE;
    @Builder.Default
    private Boolean isPublic = Boolean.FALSE;
    @Builder.Default
    private Set<Guest> guestList = Collections.emptySet();
}
