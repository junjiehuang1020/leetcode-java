package me.junjiehuang1020.string;

public class ValidParentheses {

    public static boolean solution1(String s) {

        char[] parentheses = new char[]{'(', ')'};

        char[] squareBracket = new char[]{'[', ']'};

        char[] curlyBracket = new char[]{'{', '}'};

        if (s.length() % 2 != 0) {

            return false;
        }

        while(s.length() > 0) {

            for(int i = 0; i < s.length(); i++) {


                if (i != 0 && s.charAt(i) == parentheses[1]) {

                    if (i == 0) {

                        return false;

                    } else if (s.charAt(i - 1) == parentheses[0]) {

                        s = s.substring(0, i - 1).concat(s.substring(i + 1, s.length()));
                        break;

                    } else {

                        return false;
                    }

                }

                if (i != 0 && s.charAt(i) == squareBracket[1]) {

                    if (s.charAt(i - 1) == squareBracket[0]) {

                        s = s.substring(0, i - 1).concat(s.substring(i + 1, s.length()));
                        break;

                    } else {

                        return false;
                    }
                }

                if (i != 0 && s.charAt(i) == curlyBracket[1]) {

                    if (s.charAt(i - 1) == curlyBracket[0]) {

                        s = s.substring(0, i - 1).concat(s.substring(i + 1, s.length()));
                        break;

                    } else {

                        return false;
                    }
                }

                if (i == s.length() - 1) {

                    return false;
                }

            }

        }

        return true;

    }
}
