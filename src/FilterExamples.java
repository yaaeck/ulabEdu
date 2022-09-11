import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * https://habr.com/ru/company/luxoft/blog/270383/ useful link
 */
public class FilterExamples {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("sasha");
        names.add("masha");
        names.add("petya");
        names.add("lesha");
        names.add("pasha");
        names.add("pasha");
        names.add("pasha");
        names.add(null);
        names.add("gosha");


//        String foundName = names.stream()
//                .filter(name -> "gosha".equalsIgnoreCase(name)) // "masha".equalsIgnoreCase(name)
//                .findFirst()
//                .orElse(null);
//        System.out.println(foundName);

//        List<String> namesList = names.stream()
//                .filter(name -> Objects.nonNull(name) && name.startsWith("p") && name.endsWith("a"))
//                .distinct()
//                .toList();
//        System.out.println(namesList);

//
//        List<String> noRepeated = names.stream()
//                .filter(name -> Objects.nonNull(name))
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(noRepeated);
//

//        List<String> nonNullNames = names.stream()
//                .filter(Objects::nonNull)
//                .toList();
//        System.out.println(nonNullNames);

    }
}
