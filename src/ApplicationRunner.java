public class ApplicationRunner {
    private InputOutput inputOutput;
    private Encrypter encrypter;

    public static final String START_KEY_PROMPT = "Введите ключ";
    public static final String RESULT_KEY_PROMPT = "Ключ шифрования: ";
    public static final String START_VALUE_PROMPT = "Введите введите значение для зашифровки: ";
    public static final String RESULT_VALUE_PROMPT = "Строка для шифрования: ";

    ApplicationRunner() {
        inputOutput = new InputOutput();
        encrypter = new Encrypter();
    }

    public void run() {
        String encryptKey = inputOutput.inputReader(START_KEY_PROMPT, RESULT_KEY_PROMPT);
        String toEncrypt = inputOutput.inputReader(START_VALUE_PROMPT, RESULT_VALUE_PROMPT);

        String encryptedValue = encrypter.encryptOrDecrypt(encryptKey, toEncrypt, encrypter.encrypt);
        String decryptedValue = encrypter.encryptOrDecrypt(encryptKey, encryptedValue, encrypter.decrypt);

        inputOutput.printData(encryptedValue);
        inputOutput.printData(decryptedValue);
    }

}
