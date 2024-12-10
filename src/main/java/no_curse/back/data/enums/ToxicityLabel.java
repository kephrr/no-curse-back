package no_curse.back.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ToxicityLabel {
    NotToxic(1),
    LowlyToxic(2),
    MediumlyToxic(3),
    HighlyToxic(4),
    ExtremelyToxic(5);

    private final Integer index;
}
