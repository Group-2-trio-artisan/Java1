package com.example.slot15;

import java.util.concurrent.locks.ReentrantLock;

public class IdGenerate {
    private static Long id = 0L;
    private static ReentrantLock lock = new ReentrantLock();

    public static Long getNewId(){
        Long result;
        lock.lock(); //Khóa iến id ai chỉ cho duy nhất một thread được truy xuất
        //Để tránh tình trạng Data Racing!
        try{
            result = ++id; //Tăng rồi gán vào result
        }finally {
            lock.unlock(); // Tăng rồi thì mở lock cho thread khác cùng truy cấp
        }
        return result;
    }
    private IdGenerate(){}

}
