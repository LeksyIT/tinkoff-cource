package lessonfirst;

import lombok.Getter;

@Getter
public enum TelephoneType {
    STATIONARY ("stationary"),
    MOBILE ("mobile");

    private final String type;

    TelephoneType(String type) {
        this.type = type;
    }
}
