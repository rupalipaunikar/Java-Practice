package com.patterns.creational.builder;

import java.util.HashMap;
import java.util.Map;

class Code {
    public String className;
    public Map<String, String> fieldMap = new HashMap<>();
}

class CodeBuilder {
    private final Code code = new Code();

    public CodeBuilder(String className) {
        this.code.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        this.code.fieldMap.put(type, name);
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("public class ");
        sb.append(code.className).append("\n{\n");
        for (Map.Entry<String, String> entry : code.fieldMap.entrySet()) {
            final String type = entry.getKey();
            final String name = entry.getValue();
            sb.append("  public ").append(type).append(" ").append(name).append(";\n");
        }
        sb.append("}");
        return sb.toString();
    }
}


public class FluentBuilderDemo {

    public static void main(String[] args) {

        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}