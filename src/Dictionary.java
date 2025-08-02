import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {

    private final String filePath;
    private final List<String> dictionary;

    public Dictionary(String filePath) throws DictionaryException {

        if (filePath == null){
            System.out.println("Path to file is null");
            throw new NullPointerException("Path to file is null");
        }

        this.filePath = filePath;

        try {
            this.dictionary = readDictionary();
        } catch (FileNotFoundException e){
            throw new DictionaryException("File with words not found", e);
        } catch (IOException e) {
            throw new DictionaryException("Problems with file", e);
        }
    }

    public List<String> getAllWords(){
        return dictionary;
    }

    public String getRandomWord() throws DictionaryException{
        if (dictionary.isEmpty()){
            throw new DictionaryException("В словаре нет подходящих слов для игры.");
        }
        Random r = new Random();
        return dictionary.get(r.nextInt(dictionary.size()));
    }

    private List<String> readDictionary() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))){
            return stream.filter(line -> line.length() > 5 && !line.contains("-")).collect(Collectors.toList());
        }
    }

}
