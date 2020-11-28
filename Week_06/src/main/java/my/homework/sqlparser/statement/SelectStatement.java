package my.homework.sqlparser.statement;

import java.util.List;

public class SelectStatement {

    private List<SQLColumn> columns;
    private SQLWhere where;
    private Boolean orderby;
    private SQLColumn orderbyCol;

    public List<SQLColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<SQLColumn> columns) {
        this.columns = columns;
    }

    public SQLWhere getWhere() {
        return where;
    }

    public void setWhere(SQLWhere where) {
        this.where = where;
    }

    public Boolean getOrderby() {
        return orderby;
    }

    public void setOrderby(Boolean orderby) {
        this.orderby = orderby;
    }

    public SQLColumn getOrderbyCol() {
        return orderbyCol;
    }

    public void setOrderbyCol(SQLColumn orderbyCol) {
        this.orderbyCol = orderbyCol;
    }
}
