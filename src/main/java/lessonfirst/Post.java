package lessonfirst;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Data
public class Post{
    private String text;
    private Integer likesCount;
}
