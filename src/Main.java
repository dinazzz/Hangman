public class Main {
    public static void main(String[] args) throws DictionaryException{
        final String FILEPATH = "resources/singular.txt";

        Dialogue dialogue = new Dialogue();
        boolean isAgreeToPlay = dialogue.helloDialogue();
        while(isAgreeToPlay){
           GameRound gameRound = dialogue.startGame(FILEPATH);
           String inputtedString;
           boolean isWordNotGuessed = true;
           dialogue.printRoundStatus(gameRound);

           while (gameRound.getErrorCount() < 6 && isWordNotGuessed) {
               inputtedString = dialogue.askLetter();
               gameRound.checkAnswer(inputtedString);
               dialogue.printRoundStatus(gameRound);
               isWordNotGuessed = !gameRound.getRightAnswer().equals(gameRound.getMaskedWord());
           }

           isAgreeToPlay = dialogue.askRepeatGame();
        }
        dialogue.endGame();
    }
}
