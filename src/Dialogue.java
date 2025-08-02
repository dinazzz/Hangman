import java.util.Scanner;

public class Dialogue {
    private final Scanner scanner;

    public Dialogue(){
        scanner = new Scanner(System.in);
    }

    public boolean helloDialogue(){
        System.out.println("Добро пожаловать! Сыграем в игру? (Да/нет)");
        while(true) {
            switch (scanner.next().toLowerCase()) {
                case "да":
                    return true;
                case "нет":
                    return false;
                default:
                    System.out.println("\nЯ тебя не понял... Ты хочешь сыграть в игру? (Да/нет)");
            }
        }
    }

    public GameRound startGame(String dictionaryFilePath) throws DictionaryException{
            Dictionary words = new Dictionary (dictionaryFilePath);
            String word = words.getRandomWord();
            return new GameRound(word);
    }

    public String askLetter(){
        System.out.println("\nНазови букву!");
        String inputtedString = scanner.next();
        boolean isInputCorrect = checkTheInputCorrectness(inputtedString);
        if (!isInputCorrect){
            System.out.println("\nНекорректный ввод! Ты должен ввести одну букву!");
            return askLetter();
        }
        return inputtedString.toLowerCase();
    }

    private boolean checkTheInputCorrectness(String str){
        return str.length() == 1 && Character.isLetter(str.toCharArray()[0]);
    }

    public void printRoundStatus(GameRound gameRound){
        String maskedWord = gameRound.getMaskedWord();
        String rightAnswer = gameRound.getRightAnswer();
        int errorCount = gameRound.getErrorCount();

        System.out.println("\n" + Hangman.getImage(errorCount));
        System.out.println("Количество совершенных ошибок: " + gameRound.getErrorCount());
        System.out.println(maskedWord);

        if (!maskedWord.equals(rightAnswer) && errorCount == 6) {
            System.out.println("\nТы проиграл!");
            System.out.println("Загаданное слово - " + rightAnswer);
        } else if (maskedWord.equals(rightAnswer)) {
            System.out.println("\nТы угадал слово! Поздравляю!");
        }
    }

    public boolean askRepeatGame(){
        System.out.println("\nСыграем еще? (Да/нет)");
        while(true) {
            switch (scanner.next().toLowerCase()) {
                case "да":
                    return true;
                case "нет":
                    return false;
                default:
                    System.out.println("\nЯ тебя не понял... Ты хочешь сыграть в игру еще раз? (Да/нет)");
            }
        }
    }

    public void endGame(){
        System.out.println("\nДо свидания, путник!");
    }
}
