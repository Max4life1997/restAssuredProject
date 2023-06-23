package pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class RootData {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public ArrayList<UserData> data;
    public SupportData supportData;
}
