import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private String status;
    private String name_task;



    @Override
    public String toString() {
        return "[" +  status + "]" + " " + name_task;
    }
}
