package per.ja.pojo;

//类型
public class Column {
    Integer ColumnID;
    String TypeName;
    Integer PTypeID;

    public Column() {
    }

    public Column(String typeName) {
        TypeName = typeName;
    }

    public Column( String typeName, Integer PTypeID) {
        TypeName = typeName;
        this.PTypeID = PTypeID;
    }

    public Column(Integer columnID, String typeName, Integer PTypeID) {
        ColumnID = columnID;
        TypeName = typeName;
        this.PTypeID = PTypeID;
    }

    public Integer getColumnID() {
        return ColumnID;
    }

    public void setColumnID(Integer columnID) {
        ColumnID = columnID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    public Integer getPTypeID() {
        return PTypeID;
    }

    public void setPTypeID(Integer PTypeID) {
        this.PTypeID = PTypeID;
    }

    @Override
    public String toString() {
        return "Column{" +
                "ColumnID=" + ColumnID +
                ", TypeName='" + TypeName + '\'' +
                ", PTypeID=" + PTypeID +
                '}';
    }
}
