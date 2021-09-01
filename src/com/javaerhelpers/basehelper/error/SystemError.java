package com.javaerhelpers.basehelper.error;

import com.javaerhelpers.basehelper.date.DatePatterns;
import com.javaerhelpers.basehelper.date.DateUtils;
import com.javaerhelpers.basehelper.exception.ExceptionStack;
import com.javaerhelpers.basehelper.io.OutputStreamUtils;
import com.javaerhelpers.basehelper.path.PathPool;
import com.javaerhelpers.basehelper.string.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @desc:<p>用途</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:0.0.1
 */
public class SystemError {

    protected static final Object _lock = new Object();
    protected static long stopTime = 0;
    protected static boolean isError = false;

    public static void printSystemError(Throwable e) {
        synchronized (_lock) {
            if (isError) {
                return;
            }
            isError = true;
        }
        OutputStream os = null;
        try {
            stopTime = System.currentTimeMillis();
            String fileName = PathPool.getLogFilePath() + "freeze.dump.log";
            os = new FileOutputStream(new File(fileName), true);
            String s = "\n\n\n" + DateUtils.toString(new Date(), DatePatterns.yyyyMMdd_HHmmss) + ":系统产生了不可恢复的错误\n";
            os.write(s.getBytes());
            writeSystem(os);
            writeException(os, e);
            listThread(os);
            dumpStack(os);
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            isError = false;
            OutputStreamUtils.close(os);
        }
    }

    private static void writeSystem(OutputStream os) throws IOException {
        String msg = "maximum amount of memory ：" + Runtime.getRuntime().maxMemory() / 1024 + "K\n"
                + "total amount of memory ：" + Runtime.getRuntime().totalMemory() / 1024 + "K\n"
                + "amount of free memory ：" + Runtime.getRuntime().freeMemory() / 1024 + "K\n"
                + "number of processors ：" + Runtime.getRuntime().availableProcessors() + "\n";
        os.write(msg.getBytes());
    }

    private static void writeException(OutputStream os, Throwable e) throws IOException {
        String msg = e.getMessage();
        if (StringUtils.isNotEmpty(msg)) {
            os.write(msg.getBytes());
            os.write('\n');
        }
        ExceptionStack exceptionStack = new ExceptionStack(e);
        String[] rep = exceptionStack.getThrowableStrRep();
        for (String s : rep) {
            os.write(s.getBytes());
            os.write('\n');
        }
    }

    private static void listThread(OutputStream os) throws IOException {
    }

    private static final void dumpStack(OutputStream os) throws IOException {
        os.write("堆栈信息：\n".getBytes());
        Map<Thread, StackTraceElement[]> stacks = Thread.getAllStackTraces();
        Set<Map.Entry<Thread, StackTraceElement[]>> set = stacks.entrySet();
        for (Map.Entry<Thread, StackTraceElement[]> item : set) {
            os.write(("线程编号：" + item.getKey() + "\n").getBytes());
            StackTraceElement se[] = item.getValue();
            for (StackTraceElement s : se) {
                boolean isNativeMethod = s.isNativeMethod();
                int lineNumber = s.getLineNumber();
                String msg = s.getClassName() + "." + s.getMethodName() +
                        (isNativeMethod ? "(Native Method)" :
                                (lineNumber >= 0 ? "(" + lineNumber + ")" : "(Unknown Source)")) + "\n";
                os.write(msg.getBytes());
            }
        }
    }
}
