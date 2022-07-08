package firstlesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Client {
    private int id;
    private String name;
    private int old;
    private List<Telephone> telephoneList;
}
