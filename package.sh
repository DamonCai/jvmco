#!/bin/bash
git pull
mvn clean package -Dmaven.test.skip=true
nohup java -jar -Dspring.profiles.active=dev hatch-web/target/hatch-web-1.0.0-SNAPSHOT.jar &
  java -jar  jvmco-0.0.1-SNAPSHOT.jar &




jps -l                                                                                 java运行的进程PID
jmap -dump:format=b,file=Damon.dump 10464              打印dump文件


jstat -gcutil 10464                             监视参数与输出结果
                                                         新生代 Eden区（E，表示Eden）使用了6.2%的空间，两个Survivor区（S0、S1，表示Survivor0、Survivor1）里面都是空的，
                                                         老年代（O，表示Old）
                                                         永久代（P，表示Permanent）则分别使用了41.42%和47.20%的空间。
                                                         程序运行以来共
                                                         发生Minor GC（YGC，表示Young GC）16次，总耗时0.105秒，
                                                         发生Full GC（FGC，表示Full GC）3次，
                                                         Full GC总耗时（FGCT，表示Full GC Time）为0.472秒，
                                                         所有GC总耗时（GCT，表示GC Time）为0.577秒

jstat -gcutil 10464                             监视参数与输出结果

jhat Damon.dump                              启动dump文件（查看地址 http://localhost:7000/）



jmap -histo 进程号|head -n 20

jmap -histo 1|head -n 20