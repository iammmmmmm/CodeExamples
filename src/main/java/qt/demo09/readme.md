此文件夹为了实现把qt designer 设计生成的ui文件转换成java文件。
参考教程：https://github.com/OmixVisualization/qtjambi/blob/master/www/Characteristics-of-QtJambi.md

.ui文件是demo07用的

使用命令（模板）：

```
java -Djava.library.path=<path to Qt libraries>
     -cp qtjambi-6.5.3.jar:qtjambi-uic-6.5.3.jar
     io.qt.uic.Main --output=src --package=com.myapplication.widgets com/myapplication/widgets/mainwindow.ui
```

（在我的设备上,在此项目的根路径下执行 D:\code\Git_repository\CodeExamples\Java\example> ）

```
java -Djava.library.path=C:\Qt\6.6.0\msvc2019_64\bin -cp ./src/main/java/qt/demo09/qtjambi-6.6.0.jar;./src/main/java/qt/demo09/qtjambi-native-windows-x64-6.6.0.jar;./src/main/java/qt/demo09/qtjambi-uic-6.6.0.jar;./src/main/java/qt/demo09/qtjambi-uic-native-windows-x64-6.6.0.jar io.qt.uic.Main --output=./src/main/java --package=qt.demo09 src/main/java/qt/demo09/demo07.ui
```
