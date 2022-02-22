package ast.types;

import ast.AbstractASTNode;
import ast.Type;

import java.util.ArrayList;
import java.util.List;

public class Struct extends AbstractASTNode implements Type {

    private final List<RecordField> recordFields;
    private final String name;

    public Struct(String name, List<RecordField> recordFields, int column, int line) {
        super(column, line);
        this.name = name;
        this.recordFields = recordFields;
    }

    public String getName() { return name; }
    public List<RecordField> getRecordFields() { return new ArrayList<>(recordFields); }

}
