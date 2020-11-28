package my.homework.sqlparser;

import org.springframework.util.StringUtils;

/**
 * 词法解析器
 */
public class Lexer {

    public int startPos = 0;
    public int endPos = 0;
    public String token;
    public char ch;
    public String sql;

    public Lexer(String sql) {
        this.sql = sql;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public String nextToken(){
        while(true) {
            if (startPos > sql.length() - 1) {
                return "EOF";
            }
            if (endPos <= sql.length() - 1) {
                ch = sql.charAt(endPos);
            } else {
                ch = ' ';
            }

            boolean check = check();
            if (ch == ' ') {
                endPos++;
            } else if (check) {
                endPos++;
                continue;
            }

            if (endPos <= sql.length() - 1){
                token = sql.substring(startPos, endPos).trim();
            }else{
                token = sql.substring(startPos).trim();
            }
            if("".equals(token)){
                endPos++;
            }
            startPos = endPos;
            return token;
        }
    }

    public boolean hasNext(){
        if("EOF".equals(token)){
            return false;
        }
        return true;
    }

    private boolean check(){
        switch (ch){
            case '>':
            case '<':
            case '+':
            case '-':
            case '/':
                return false;
            default:
                return true;
        }
    }

    public static void main(String[] args) {
        Lexer lexer = new Lexer("select id from t where a>1 order by a");

        String substring = "abcd".substring(0, 2);
        System.out.println(substring);
        while (lexer.hasNext()) {
            String s = lexer.nextToken();
            System.out.println(s+"结束token");

            if("EOF".equals(s)){
                return;
            }
        }
    }
}
