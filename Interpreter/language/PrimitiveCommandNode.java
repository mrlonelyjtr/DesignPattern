package language;

// <primitive command> ::= go | left | right
public class PrimitiveCommandNode extends Node {
    private String name;
    private Executor executor;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);

        if (!name.equals("go") && !name.equals("left") && !name.equals("right"))
            throw new ParseException(name + " is undefined");

        executor = context.createExecutor(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void execute() throws ExecuteException {
        if (executor == null)
            throw new ExecuteException(name + ": is not defined");
        else
            executor.execute();
    }
}