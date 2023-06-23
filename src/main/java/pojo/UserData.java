package pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserData {
    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}


