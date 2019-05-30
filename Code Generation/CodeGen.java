import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;

public class CodeGen {
    public static void main(String[] args) throws Exception {
        /*if(args.length < 1) {
            System.err.println("No file is given!");
            return;
        }

        String inputFile = args[0];*/
        FileInputStream inputStream = new FileInputStream("helloworld.cl");
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        Lexer2 lexer = new Lexer2(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParsingParser parser = new ParsingParser(tokens);
        ParseTree tree = parser.program();
        ParsingBaseVisitor visitor = new ParsingBaseVisitor();
        visitor.visit(tree);
    }
}
