package per.ja.pojo;

import java.util.ArrayList;
import java.util.List;

//级联搜素实体类
public class Option {
    //值
    String value;
    //标签
    String label;
    //子类
    List<Option> children;

    public Option(String value, String label, List<Option> children) {
        this.value = value;
        this.label = label;
        this.children = children;
    }

    public Option(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public Option() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Option> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Option> children) {
        this.children = children;
    }


    @Override
    public String toString() {
        return "Option{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
