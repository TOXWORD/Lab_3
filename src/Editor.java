import java.util.*;

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


    public void chText() {

        StringTokenizer st;
        List<String> words;
        List<Integer> positions;
        List<Integer> invPosit;
        String buf;
        StringBuffer sb;
        int remPos = 1;

        for (String row : text) {

            st = new StringTokenizer(row, " .,", true);
            words = new ArrayList<>();
            positions = new ArrayList<>();

            while(st.hasMoreTokens()){
                words.add(st.nextToken());
            }

            for(String word : words){
                if(!word.equals(" ") && !word.equals(",") && !word.equals(".")){
                    positions.add(words.indexOf(word));
                }
            }

            invPosit = new ArrayList<>(positions);
            Collections.reverse(invPosit);

            for(int i = 0; i < positions.size() / 2; i++){

                buf = words.get((int)invPosit.get(i));
                words.add(invPosit.get(i), words.get((int)positions.get(i)));
                words.add(positions.get(i), buf);

                words.remove(positions.get(i) + remPos);
                words.remove(invPosit.get(i) + remPos);

            }

            sb = new StringBuffer();

            for(String word : words){
                sb.append(word);
            }
            changedText.add(sb.toString());

        }

    }


    public void printInvertedText() {
        for (int i = 0; i < changedText.size(); i++) {
            System.out.println(changedText.get(i));
        }
    }

}
