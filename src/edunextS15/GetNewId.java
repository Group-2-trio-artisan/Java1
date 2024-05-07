package edunextS15;

import static edunextS15.IdGenerate.lock;
import static edunextS15.IdGenerate.id;
public class GetNewId {
    public static Long getNewId(){
        Long result;
        lock.lock();// khoa bien id lai chi cho duy nhat 1 thread duoc truy xuat cap
        //de tranh tinh trang data Racing!
        try {
            result = ++id;// tang roi gan vao bien result
        }finally {
            lock.unlock();// tang roi thi mo lock cho cac thread khac cung truy cap
            // nhieu nhu minh di nha ve sinh xong thi ra
        }
        return result;
    }
}
