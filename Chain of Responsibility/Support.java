public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }

    public final void support(Trouble trouble) {
        Support obj = this;

        while (true) {
            if (obj.resolve(trouble)) {
                obj.done(trouble);
                break;
            }
            else if (obj.next == null) {
                obj.fail(trouble);
                break;
            }

            obj = obj.next;
        }
    }
}