package reqresTest.Collections.positive;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.UserData;
import utils.Specifications;
import utils.api.ReqresEndPoints;
import utils.enums.URL;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


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
                new UserData(3, "tobmis.funke@reqres.in", "Tobimis", "Funkekson", "https://reqres.in/img/faces/9-image.jpg"),
                new UserData(4, "byron.fields@reqres.in", "Byron", "Fields", "https://reqres.in/img/faces/10-image.jpg"),
                new UserData(5, "byron.fields@reqres.in", "Byron", "Fiekson", "https://reqres.in/img/faces/10-image.jpg"),
                new UserData(6, "byron.fields@reqres.in", "Byron", "MAxixos", "https://reqres.in/img/faces/14-image.jpg"),
                new UserData(7, "byron.fields@reqres.in", "Byron", "Fernandos", "https://reqres.in/img/faces/18-image.jpg")
        );

        // Stream API

        // filter
        List<UserData> usersFilterList = users.stream()
                .filter(userData -> userData.getId() == 1)
                .collect(Collectors.toList()); // UserData(1, "michael.lawson@reqres.in", "Michael", "Lawson", "https://reqres.in/img/faces/7-image.jpg")

        // sort
        usersFilterList = users.stream().sorted(
                        Comparator.comparing(UserData::getFirstName)
                                .thenComparing(UserData::getFirstName)
                                .reversed())
                .collect(Collectors.toList());

        // all match

        boolean allMatch = users.stream()
                .allMatch(userData -> userData.getId() < 8);//--true
        System.out.println("allMatch " + allMatch);

        // any match
        boolean anyMatch = users.stream()
                .anyMatch(userData -> userData.getId() == 4);//true
        System.out.println("anyMatch " + anyMatch);

        // none match
        boolean noneMatch = users.stream()
                .noneMatch(userData -> userData.getId() > 8);//true
        System.out.println("noneMatch " + noneMatch);

        // max
        System.out.println("Max ");
        users.stream()
                .max(Comparator.comparing(UserData::getId))
                .ifPresent((System.out::println));//4

        // min
        System.out.println("Min ");
        users.stream()
                .min(Comparator.comparing(UserData::getId))
                .ifPresent((System.out::println));//5
        // group
        System.out.println("Group ");
        Map<String, List<UserData>> usersListMap = users.stream()
                .collect(Collectors.groupingBy(UserData::getFirstName));

        usersListMap.forEach((string, user) -> {
            System.out.println(string);
            user.forEach((System.out::println));
            System.out.println();
        });

        // Имя пользователя с самым маленьким ID c почтой byron.fields@reqres.in
        Optional<String> minIDUser = users.stream()
                .filter(userData -> userData.getEmail().equals("byron.fields@reqres.in"))
                .min(Comparator.comparing(UserData::getId))
                .map(UserData::getFirstName);

        minIDUser.stream().forEach(user ->
                System.out.println(user));

    }
}
