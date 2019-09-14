import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Editor {

    private List<String> text;
    private List<String> changedText;

    public Editor() {
        text = new ArrayList<String>();
        changedText = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        String tmp;
        while (!(tmp = sc.nextLine()).equals("")) {
            text.add(tmp);
        }
    }

    public void enterText() {
        text = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        String tmp;
        while (!(tmp = sc.nextLine()).equals("")) {
            text.add(tmp);
        }
    }

    public void changeText() {
        String[] words;
        String buffer;
        StringBuilder sb;
        char[] divs;
        int pos = 0;

        for (int i = 0; i < text.size(); i++) {

            buffer = text.get(i);
            words = buffer.split("\\s|\\.|\\,");
            int wSize = words.length;
            divs = new char[wSize + 1];

            for (int j = 0; j < buffer.length(); j++) {
                if (buffer.charAt(j) == ' ' || buffer.charAt(j) == '.' || buffer.charAt(j) == ',') {
                    divs[pos] = buffer.charAt(j);
                    pos++;
                }
            }

            for (int j = 0; j < wSize / 2; j++) {
                buffer = words[j];
                words[j] = words[wSize - j - 1];
                words[wSize - j - 1] = buffer;
            }

            sb = new StringBuilder();

            if (pos == wSize) {
                for (int j = 0; j < wSize; j++) {
                    sb.append(words[j]).append(divs[divs.length - 1 - pos]);
                    pos--;
                }
            }
            else {
                for (int j = 0; j < wSize - 1; j++) {
                    sb.append(words[j]).append(divs[divs.length - 1 - pos]);
                    pos--;
                }
                sb.append(words[wSize - 1]);
            }
            changedText.add(sb.toString());
        }
    }

    public void printInvertedText(){
        for(int i = 0; i < changedText.size(); i++){
            System.out.println(changedText.get(i));
        }
    }

}
