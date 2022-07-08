package firstlesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Post {
    private String text;
    private Integer likesCount;
}
