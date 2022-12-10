javac -cp /usr/local/lib/python3.8/dist-packages/jep/jep-4.1.0.jar -d ./ ./*.java ./test/*.java
jar -cvf CliAgent4Java.jar CliAgent/
java -cp :/usr/local/lib/python3.8/dist-packages/jep/jep-4.1.0.jar:CliAgent4Java.jar -Djava.library.path=/usr/local/lib/python3.8/dist-packages/jep/ CliAgent.test.runtests
