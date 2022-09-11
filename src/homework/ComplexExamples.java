package homework;

import java.util.*;

import static java.util.stream.Collectors.*;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        //Task1

        if (RAW_DATA != null) {
            Map<String, Long> sortedMap = Arrays.stream(RAW_DATA)
                    .distinct()
                    .collect(groupingBy(Person::getName, counting()));

            for (Map.Entry<String, Long> pair : sortedMap.entrySet()) {
                System.out.println("Key: " + pair.getKey());
                System.out.println("Value: " + pair.getValue());
            }
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();

        //Task2

        int[] RAW_DATA2 = {3, 4, 2, 7};
        int sum = 10;

        int[] resultArray = findPair(RAW_DATA2, sum);

        System.out.println(Arrays.toString(resultArray));

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();

        //Task3

        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true

        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key:Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */



        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */



        /*
        Task3
            Реализовать функцию нечеткого поиска
                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */
    }

    public static int[] findPair(int[] array, int sum) {
        if (array == null || sum == 0) return null;

        int[] resultArray = new int[2];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) continue;
                int guess = array[i] + array[j];
                if (guess == sum) {
                    resultArray[0] = array[j];
                    resultArray[1] = array[i];
                    break;
                }
            }
        }

        return resultArray;
    }

    public static boolean fuzzySearch(String word, String data) {
        if (word == null || data == null) return false;

        //Если слова изначально равны возвращаем true
        if (word.equals(data)) return true;

        char[] wordArray = word.toCharArray();
        char[] dataArray = data.toCharArray();

        //Проходимся по массивам и ищем совпадения
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < wordArray.length; i++) {
            for (int j = 0; j < dataArray.length; j++) {
                if (wordArray[i] == dataArray[j]) {
                    /*
                    При совпадении - добавляем индекс элемента в лист, а сам элемент
                    меняем на произвольный символ, чтобы избежать дублей
                     */
                    indexList.add(j);
                    dataArray[j] = '?';
                    break;
                }
            }
        }

        /*
        Если длина листа индексов и кол-ва букв в заданном слове
        не совпадает - возвращаем false
        */
        if (indexList.size() != wordArray.length) return false;

        /*
        Перебираем лист и проверяем, что все числа стоят друг за другом,
        то есть, по возрастанию, это подтверждает наличие заданного
        слова в необходимом порядке
         */
        boolean flag = true;
        for (int i = 1; i < indexList.size(); i++) {
            if (indexList.get(i - 1) >= indexList.get(i)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
