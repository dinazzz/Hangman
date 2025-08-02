import java.util.ArrayList;
import java.util.List;

public class GameRound {
    private final String rightAnswer;
    private final List<String> incorrectLetters;
    private String maskedWord;
    private int errorCount;

    public GameRound(String rightAnswer) {
        this.rightAnswer = rightAnswer;
        this.maskedWord = maskWord(rightAnswer);
        this.errorCount = 0;
        this.incorrectLetters = new ArrayList<>();
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getMaskedWord() {
        return maskedWord;
    }

    public int getErrorCount() {
        return errorCount;
    }

    private String maskWord(String word){
        return "_".repeat(word.length());
    }

    public void checkAnswer(String inputtedString){
        if (rightAnswer.contains(inputtedString)) {
            replaceLetter(inputtedString);
        } else {
            if(!incorrectLetters.contains(inputtedString)){
                errorCount++;
                incorrectLetters.add(inputtedString);
            }
        }
    }

    private void replaceLetter(String inputtedString){ //переписать
        char inputtedSymbol = inputtedString.charAt(0);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < maskedWord.length(); i++) {
            if (maskedWord.charAt(i) != '_') {
                sb.append(maskedWord.charAt(i));
            } else if (maskedWord.charAt(i) == '_' && rightAnswer.charAt(i) == inputtedSymbol) {
                sb.append(inputtedSymbol);
            } else if (maskedWord.charAt(i) == '_' && rightAnswer.charAt(i) != inputtedSymbol) {
                sb.append('_');
            }
        }
        maskedWord = sb.toString();
    }
}
