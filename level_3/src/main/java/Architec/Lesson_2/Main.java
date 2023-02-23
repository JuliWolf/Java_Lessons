package Architec.Lesson_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
//    System.out.println(encrypt("This", 2));
    System.out.println(decrypt(encrypt("This", 1), 1));
  }

  public static String encrypt(final String text, final int n) {
    if (!isArgumentsValid(text, n)) {
      return text;
    }

    String[] splittedStr = text.split("");
    List<String> encryptedStr = new ArrayList<>();
    int currentIndex = 0;

    for (int i = 0; i < splittedStr.length; i++) {
      if (i % 2 != 0) {
        encryptedStr.add(currentIndex, splittedStr[i]);
        currentIndex++;
      } else {
        encryptedStr.add(splittedStr[i]);
      }
    }

    if (n == 1) {
      return String.join("", encryptedStr);
    }

    int updatedN = n - 1;
    return encrypt(String.join("", encryptedStr), updatedN);
  }

  public static String decrypt(final String encryptedText, final int n) {
    if (!isArgumentsValid(encryptedText, n)) {
      return encryptedText;
    }

    String[] splittedStr = encryptedText.split("");
    List<String> dencryptedStr = new ArrayList<>();
    int currentIndex = 0;
    int lastindex = splittedStr.length - 1;

    for (int i = splittedStr.length - 1; i > 0; i--) {
      if (i % 2 == 0) {
        dencryptedStr.add(currentIndex, splittedStr[i]);
        currentIndex++;
      } else {
        dencryptedStr.add(lastindex, splittedStr[i]);
        lastindex--;
      }
    }

    if (n == 1) {
      return String.join("", dencryptedStr);
    }

    int updatedN = n - 1;
    return encrypt(String.join("", dencryptedStr), updatedN);
  }

  public static boolean isArgumentsValid (final String text, final int n) {
    if (text.length() == 0) {
      return false;
    }

    if (n == 0) {
      return false;
    }

    return true;
  }
}
