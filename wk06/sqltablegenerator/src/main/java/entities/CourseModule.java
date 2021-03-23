package entities;

import annotations.Check;
import lombok.AllArgsConstructor;
import lombok.Data;
import annotations.Default;
import annotations.ID;
import annotations.NotNull;
import lombok.Builder;

/**
 * Bit like a fontys course.
 * This class uses project lombok to create the standard getter/setter, equals
 * +hashCode and toString ceremony.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
@Data
@Builder
@AllArgsConstructor
public class CourseModule {

    @ID
    private Long moduleid;
    @NotNull
    String name;
    @NotNull
    @Default( value = "5" )
    @Check( value = "credits > 0" )
    Integer credits;
}
