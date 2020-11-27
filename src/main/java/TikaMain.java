import org.apache.tika.parser.txt.CharsetDetector;
import java.io.UnsupportedEncodingException;

public class TikaMain {

    static String word = "Ïđèâạ̊";
    static String utf8 = "UTF-8";
    static String windows1251 = "windows-1251";
    static String KOI8 = "KOI8-R";

    public static void main(String[] args) throws UnsupportedEncodingException {
        checkEncoding(word);
        encodingText(word, utf8);

          }

    private static void checkEncoding(String forCheck) {

        // проверка кодировки в тексте
        CharsetDetector detector = new CharsetDetector();
        detector.setText(forCheck.getBytes());
        System.out.println("Пришло слово: " + word + "\n" + "в кодировке : " + detector.detect());

    }

    private static void encodingText(String forEncodingText, String encodingFormat) {

        //перекодировка в нужный формат
        CharsetDetector detector = new CharsetDetector();
        String text = detector.getString(forEncodingText.getBytes(), encodingFormat);
        System.out.println("\n" + "передано на проверку: " + text + "\n");
        detector.setText(text.getBytes());
        System.out.println("Перекодирован текст в:  " + text + "\n" + "Новая кодировка: " + detector.detect());

    }

}
