import java.util.ArrayList;
import java.util.Iterator;

public class FileFindVisitor extends Visitor {
    private String filetype;
    private ArrayList found = new ArrayList();

    public FileFindVisitor(String filetype) {
        this.filetype = filetype;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(filetype))
            found.add(file);
    }

    @Override
    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
    }

    public Iterator getFoundFiles() {
        return found.iterator();
    }
}