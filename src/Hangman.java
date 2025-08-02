public enum Hangman {
    ERROR_ZERO(0,
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      \n" +
                    "     |       \n" +
                    "     |       \n" +
                    "     |         \n" +
                    "     |\n" +
                    "  ___|___"),

    ERROR_ONE(1,
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |       \n" +
                    "     |       \n" +
                    "     |         \n" +
                    "     |\n" +
                    "  ___|___"),

    ERROR_TWO(2,
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |       |\n" +
                    "     |       |\n" +
                    "     |         \n" +
                    "     |\n" +
                    "  ___|___"),

    ERROR_THREE(3,
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |       |/\n" +
                    "     |       |\n" +
                    "     |         \n" +
                    "     |\n" +
                    "  ___|___"),

    ERROR_FOUR(4,
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |      \\|/\n" +
                    "     |       |\n" +
                    "     |         \n" +
                    "     |\n" +
                    "  ___|___"),

    ERROR_FIVE(5,
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |      \\|/\n" +
                    "     |       |\n" +
                    "     |        \\\n" +
                    "     |\n" +
                    "  ___|___"),

    ERROR_SIX(6,
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |      \\|/\n" +
                    "     |       |\n" +
                    "     |      / \\\n" +
                    "     |\n" +
                    "  ___|___");

    private final int countOfErrors;
    private final String image;

    Hangman(int countOfErrors, String image) {
        this.countOfErrors = countOfErrors;
        this.image = image;
    }

    public static String getImage(int countOfErrors) {
        for (Hangman hangman : values()) {
            if (hangman.countOfErrors == countOfErrors) {
                return hangman.image;
            }
        }
        return "";
    }
}
