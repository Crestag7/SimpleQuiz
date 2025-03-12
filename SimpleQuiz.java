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
                // TODO: Call a function to generate a math problem
                // Store question and answer in questions[i] and answers[i]
                
            } else if (type == 1) {
                // TODO: Call a function to generate a word scramble
                // Store question and answer in questions[i] and answers[i]
                
            } else {
                // TODO: Call a function to generate a trivia question
                // Store question and answer in questions[i] and answers[i]
                
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
            
            // TODO: Compare user answer with correct answer and print Correct/Incorrect message
            
            System.out.println();
        }

        scanner.close();
    }

    // TODO: Complete this function to generate a math problem (addition or multiplication)
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

    // TODO: Complete this function to generate a scrambled word question
    public static String[] generateWordScramble() {
        try {
            String[] words = readFile("compWords.txt");
            Random rand = new Random();
            String answer = words[rand.nextInt(words.length)];
            
            // TODO: Call a function to scramble the word
            
            return new String[]{"Unscramble the following computer term: " /* + scrambled */, answer};
        } catch (IOException e) {
            return new String[]{"Error loading words.", "N/A"};
        }
    }

    // TODO: Complete this function to generate a trivia question
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

    // TODO: Complete this function to scramble a word
    public static String scrambleWord(String word) {
        // TODO: Implement word scrambling logic
        return word; // Return scrambled version of the word
    }
}
