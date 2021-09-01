package com.javaerhelpers.basehelper.io;

import java.io.*;
import java.util.Vector;

/**
 * @desc:<p>用途</p>
 * @createDate:2021/8/27
 * @author:王凯宁 为拷贝
 * @version:0.0.1
 */
public class VectorWriter extends PrintWriter {

    private Vector<String> vector;

    public VectorWriter() {
        super(new NullWriter());
        vector = new Vector<String>();
    }

//    @Override
//    public void print(Object o){
//        vector.addElement(o.toString());
//    }
//
//    @Override
//    public void print(char[] chars){
//        vector.addElement(new String(chars));
//    }
//
//    @Override
//    public void print(String s){
//        vector.addElement(s);
//    }
//
//    @Override
//    public void println(Object o){
//        vector.addElement(o.toString());
//    }
//
//    @Override
//    public void println(char[] chars){
//        vector.addElement(new String(chars));
//    }
//
//    @Override
//    public void println(String s){
//        vector.addElement(s);
//    }
//
//    @Override
//    public void write(char[] chars){
//        vector.addElement(new String(chars));
//    }
//
//    @Override
//    public void write(char[] chars, int off, int len){
//        vector.addElement(new String(chars, off, len));
//    }
//
//    @Override
//    public void write(String s, int off, int len){
//        vector.addElement(s.substring(off, off+len));
//    }
//
//    @Override
//    public void write(String s){
//        vector.addElement(s);
//    }

    public String[] toStringArray() {
        int len = vector.size();
        String[] sa = new String[len];
        for (int i = 0; i < len; i++) {
            sa[i] = (String) vector.elementAt(i);
        }
        return sa;
    }

    static class NullWriter extends Writer {
        @Override
        public void close() {
        }

        @Override
        public void flush() {
        }

        @Override
        public void write(char[] cbuf, int off, int len) {
        }
    }

}