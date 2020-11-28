package my.homework.sqlparser;

import my.homework.sqlparser.statement.SelectStatement;

public class SQLUtil {

    public static SelectStatement parse(String sql){
        Lexer lexer = new Lexer(sql);
        return new SelectStatement();
    }

    public static void main(String[] args) {
        parse("select id from t where a>1 order by a");
    }
}
