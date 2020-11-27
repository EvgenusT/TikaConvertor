import org.apache.tika.parser.txt.CharsetDetector;

import java.io.UnsupportedEncodingException;

public class TikaMain {


    public static void main(String[] args) throws UnsupportedEncodingException {

    }

    public void getEncoding(String forEncodingText, String encodingFormat) {
        encodingText(forEncodingText, encodingFormat);
    }

    public static String checkEncoding(String forCheck) {

        // проверка кодировки в тексте
        CharsetDetector detector = new CharsetDetector();
        detector.setText(forCheck.getBytes());
        String resultCheck = detector.detect().toString();

        return resultCheck;

    }

    public static String encodingText(String forEncodingText, String encodingFormat) {

        //перекодировка в нужный формат
        CharsetDetector detector = new CharsetDetector();
        String text = detector.getString(forEncodingText.getBytes(), encodingFormat);
        System.out.println("\n" + "передано на проверку: " + text + "\n");
        detector.setText(text.getBytes());
        System.out.println("Перекодирован текст в:  " + text + "\n" + "Новая кодировка: " + detector.detect());
        return text;
    }

}
