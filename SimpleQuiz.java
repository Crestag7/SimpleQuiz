//This program generates a random quiz with five questions (math problems, scrambled words, or trivia), collects user answers, and checks their correctness.
//Aadarsha Shrestha
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class SimpleQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] questions = new String[5]; 
        String[] answers = new String[5]; 

        // Generate 5 random questions
        for (int i = 0; i < 5; i++) {
            int type = random.nextInt(3); // 0 = Math, 1 = Word Scramble, 2 = Trivia
            if (type == 0) {
                String[] math = generateMathProblem();
                questions[i] = math[0];
                answers[i] = math[1];
            } else if (type == 1) {
                String[] word = generateWordScramble();
                questions[i] = word[0];
                answers[i] = word[1];
            } else {
                String[] trivia = generateTriviaQuestion();
                questions[i] = trivia[0];
                answers[i] = trivia[1];
            }
        }

        // Display quiz questions
        System.out.println("==== QUIZ ====");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
        }

        // Get user input
        System.out.println("\nEnter your answers:");
        String[] userAnswers = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + ". ");
            userAnswers[i] = scanner.nextLine();
        }

        // Show results
        System.out.println("\n==== RESULTS ====");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            System.out.println("Your answer: " + userAnswers[i]);
            System.out.println("Correct answer: " + answers[i]);
            if (userAnswers[i].equalsIgnoreCase(answers[i])) {
                System.out.println(" Correct!");
            } else {
                System.out.println(" Incorrect!");
            }
            System.out.println();
        }

        scanner.close();
    }

    // Generate a math problem (addition or multiplication)
    public static String[] generateMathProblem() {
        Random rand = new Random();
        int num1, num2;
        String question, answer;
        
        if (rand.nextBoolean()) { // Addition (100-999)
            num1 = rand.nextInt(900) + 100;
            num2 = rand.nextInt(900) + 100;
            question = "Calculate " + num1 + " + " + num2;
            answer = String.valueOf(num1 + num2);
        } else { // Multiplication (10-99)
            num1 = rand.nextInt(90) + 10;
            num2 = rand.nextInt(90) + 10;
            question = "Calculate " + num1 + " X " + num2;
            answer = String.valueOf(num1 * num2);
        }

        return new String[]{question, answer};
    }

    // Generate a scrambled word question
    public static String[] generateWordScramble() {
        try {
            String[] words = readFile("compWords.txt");
            Random rand = new Random();
            String answer = words[rand.nextInt(words.length)];
            String scrambled = scrambleWord(answer);
            return new String[]{"Unscramble the following computer term: " + scrambled, answer};
        } catch (IOException e) {
            return new String[]{"Error loading words.", "N/A"};
        }
    }

    // Generate a trivia question
    public static String[] generateTriviaQuestion() {
        try {
            String[] lines = readFile("trivia.txt");
            Random rand = new Random();
            String[] qaPair = lines[rand.nextInt(lines.length)].split(" - ");
            return new String[]{qaPair[0], qaPair[1]};
        } catch (IOException e) {
            return new String[]{"Error loading trivia questions.", "N/A"};
        }
    }

    // Read file contents
    public static String[] readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        return br.lines().toArray(String[]::new);
    }

    // Scramble a word
    public static String scrambleWord(String word) {
        char[] chars = word.toCharArray();
        Random rand = new Random();
        for (int i = 0; i < chars.length; i++) {
            int swapIndex = rand.nextInt(chars.length);
            char temp = chars[i];
            chars[i] = chars[swapIndex];
            chars[swapIndex] = temp;
        }
        return new String(chars);
    }
}
