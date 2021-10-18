import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Integer id;
    private String status;
    private String name_task;



    @Override
    public String toString() {
        return id+"." + " " + "[" +  status + "]" + " " + name_task;
    }
}
