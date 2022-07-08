package firstlesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Telephone {
    private TelephoneType type;
    private String value;
}
