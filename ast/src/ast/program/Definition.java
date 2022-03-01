﻿package ast.program;

import ast.ASTNode;
import ast.Type;

public interface Definition extends ASTNode {

    String getName();
    Type getType();
}
