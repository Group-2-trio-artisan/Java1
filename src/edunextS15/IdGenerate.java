package edunextS15;

import java.util.concurrent.locks.ReentrantLock;

public class IdGenerate {
     static Long id = 0L;
    static ReentrantLock lock = new ReentrantLock();

    private IdGenerate(){}
}
