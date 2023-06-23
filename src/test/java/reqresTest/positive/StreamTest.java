package reqresTest.positive;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.UserData;
import utils.Specifications;
import utils.api.ReqresEndPoints;
import utils.enums.URL;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class StreamTest {

    private final String getUsersListUrl = ReqresEndPoints.GET_USERS_LIST.getEndPoint() + "?page=2";

    @BeforeAll
    public static void baseSpecSetup() {
        Specifications.intallSpec(Specifications.requestSpec(URL.REQRES.getUrl()), Specifications.responseOKSpec());
    }

    @Test
    @Description("Получение списка пользователей")
    public void getUsersList() {
        List<UserData> users = List.of(
                new UserData(1, "michael.lawson@reqres.in", "Michael", "Lawson", "https://reqres.in/img/faces/7-image.jpg"),
                new UserData(2, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson", "https://reqres.in/img/faces/8-image.jpg"),
                new UserData(3, "tobias.funke@reqres.in", "Tobias", "Funke", "https://reqres.in/img/faces/9-image.jpg"),
                new UserData(4, "byron.fields@reqres.in", "Byron", "Fields", "https://reqres.in/img/faces/10-image.jpg")
        );

        // Stream API

        // filter
        List<UserData> usersFilterList = users.stream()
                .filter(userData -> userData.getId() == 1)
                .collect(Collectors.toList()); // UserData(1, "michael.lawson@reqres.in", "Michael", "Lawson", "https://reqres.in/img/faces/7-image.jpg")

        // sort
        usersFilterList = users.stream().sorted(
                        Comparator.comparing(UserData::getFirst_name)
                                .thenComparing(UserData::getLast_name)
                                .reversed())
                .collect(Collectors.toList());

        // all match

        // any match

        // none match

        // max

        // min

        // group
    }
}
