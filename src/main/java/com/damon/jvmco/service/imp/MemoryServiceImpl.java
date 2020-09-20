package com.damon.jvmco.service.imp;

import com.damon.jvmco.service.MemoryService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;


@Service
public class MemoryServiceImpl implements MemoryService {


    private static final int BUFFER = 1024 * 1024;

    String data = "阿斯顿发送到发送到发送到阿斯顿发送到发送到发送到发送到发撒旦法撒旦法水电费绿壳鸡蛋算法公式代理方看结果是大法官是大法官阿斯顿发生阿什顿发是" +
            "阿斯顿发送到发送到发送到阿斯顿发送到发送到发送到发送到发撒旦法撒旦法水电费绿壳鸡蛋算法公式代理方看结果是大法官是大法官阿斯顿发生阿什顿发是" +
            "阿斯顿发送到发送到发送到阿斯顿发送到发送到发送撒旦法撒旦法发哎真是单反得预计如图代理方看结果是大法官是大法官阿斯顿发生阿什顿发是" +
            "阿斯顿发送到发送到发送到阿斯顿发送到发送到发送到发送到发撒旦法撒旦法水电费绿壳鸡蛋算法公式代理方看结果是大法官是大法官阿斯顿发生阿什顿发是" +
            "阿斯顿发送到发送到发送到阿斯顿发送到发送到发送到发送到发撒旦法撒旦法水电费绿壳鸡蛋算法公式代理方看结果是大法官是大法官阿斯顿发生阿什顿发是" +
            "阿斯顿发送到发送到发送到阿斯顿发送电饭锅好地方电饭锅好的华西村是好像好像电饭锅好地方规划下发过火鸡蛋算法公式代理方看结果是大法官是大法官阿斯顿发生阿什顿发是" +
            "阿斯顿发送到发送到发送到阿斯顿发送到发送到发送到发送到发撒旦法撒旦法水电费绿壳鸡蛋算法公式代理方看结果是大法官是大法官阿斯顿发生阿什顿发是" +
            "阿斯顿发送到发送到发送到阿斯顿发送到发电饭锅好的规范化的对方过后电饭锅好的和豆腐干对方过后官是大法官阿斯顿发生阿什顿发是" +
            "阿斯顿发送到发送到发送到阿斯顿发送到发送到发打工皇帝发和对方过后对方过后低功耗的的大法官阿斯顿发生阿什顿发是" +
            "阿斯顿发送到发送到发送到阿斯顿发送到发送到发送到发送到发撒电饭锅和对方过后大概对方过后大法官是大法官阿斯顿发生阿什顿发是";

    @Override
    public void memoryTest(int num) throws Exception {
        String dataStr = data + num;
        ByteArrayInputStream bais = new ByteArrayInputStream(dataStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 压缩
        compress(bais, baos);
        byte[] output = baos.toByteArray();
        baos.flush();
        baos.close();
        bais.close();


        System.out.println("yesy");
    }


    public static void compress(InputStream is, OutputStream os)
            throws Exception {
        GZIPOutputStream gos = new GZIPOutputStream(os);
        int count;
        byte data[] = new byte[BUFFER];
        while ((count = is.read(data, 0, BUFFER)) != -1) {
            gos.write(data, 0, count);
        }
        if(data.length>0){
            throw new RuntimeException("创造异常");
        }
        gos.finish();
        gos.flush();
        gos.close();
    }

}
