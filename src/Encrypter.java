import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Encrypter {

    public final BiFunction<Integer, Integer, Integer> encrypt = Integer::sum;
    public final BiFunction<Integer, Integer, Integer> decrypt = (index, key) -> index - key;

    public String encryptOrDecrypt(String key, String input, BiFunction<Integer, Integer, Integer> encryptFunction) {
        Integer keyAsInteger = null;
        try {
            keyAsInteger = Integer.parseInt(key);
        } catch (Exception exception) {
            System.out.println("Ключ должен быть целым числом!");
        }

        if (keyAsInteger == null) {
            return null;
        }

        List<Integer> indexesOfChars = convertInputDataToInt(input, keyAsInteger, encryptFunction);
        List<Character> encryptedChars = convertInputDataToCharSet(indexesOfChars);

        return encryptedChars
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private List<Character> convertInputDataToCharSet(List<Integer> indexesOfChars) {
        List<Character> encryptedChars = new ArrayList<>();

        for (Integer indexesOfChar : indexesOfChars) {
            char encryptedChar = (char) indexesOfChar.intValue();
            encryptedChars.add(encryptedChar);
        }

        return encryptedChars;
    }
    private List<Integer> convertInputDataToInt(String input, Integer key, BiFunction<Integer, Integer, Integer> encrypt) {
        List<Integer> indexesOfChars = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            Integer indexOfChar = (int) input.charAt(index);
            indexesOfChars.add(encrypt.apply(indexOfChar, key));
        }

        return indexesOfChars;
    }
}
