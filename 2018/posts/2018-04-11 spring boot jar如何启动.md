#spring boot# 启动原理

tar -x 生成的jar包
```
├── META-INF
│   ├── MANIFEST.MF
├── application.properties
├── com
│   └── example
│       └── SpringBootDemoApplication.class
├── lib
│   ├── aopalliance-1.0.jar
│   ├── spring-beans-4.2.3.RELEASE.jar
│   ├── ...
└── org
    └── springframework
        └── boot
            └── loader
                ├── ExecutableArchiveLauncher.class
                ├── JarLauncher.class
                ├── JavaAgentDetector.class
                ├── LaunchedURLClassLoader.class
                ├── Launcher.class
                ├── MainMethodRunner.class
                ├── ...
```
研究MANIFEST.MF文件以下的信息，可以看得出大概的启动逻辑
```
Manifest-Version: 1.0
Start-Class: com.reaier.pay.SpringBootStartApplication
Implementation-Vendor-Id: com.example
Spring-Boot-Version: 1.3.0.RELEASE
Created-By: Apache Maven 3.3.3
Build-Jdk: 1.8.0_60
Implementation-Vendor: Pivotal Software, Inc.
Main-Class: org.springframework.boot.loader.JarLauncher
```
发现Start-Class: com.reaier.pay.SpringBootStartApplication，查看代码：
```java
public class SpringBootStartApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootStartApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
```
```java
@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
```
发现Main-Class: org.springframework.boot.loader.JarLauncher，查看代码
```java
JarLauncher extends ExecutableArchiveLauncher ExecutableArchiveLauncher extends Launcher
```
通过Start-Class得到启动类：
```java
/**
 * Launch the application given the archive file and a fully configured classloader.
 */
protected void launch(String[] args, String mainClass, ClassLoader classLoader)
        throws Exception {
    Runnable runner = createMainMethodRunner(mainClass, args, classLoader);
    Thread runnerThread = new Thread(runner);
    runnerThread.setContextClassLoader(classLoader);
    runnerThread.setName(Thread.currentThread().getName());
    runnerThread.start();
}
 
/**
 * Create the {@code MainMethodRunner} used to launch the application.
 */
protected Runnable createMainMethodRunner(String mainClass, String[] args,
        ClassLoader classLoader) throws Exception {
    Class<?> runnerClass = classLoader.loadClass(RUNNER_CLASS);
    Constructor<?> constructor = runnerClass.getConstructor(String.class,
            String[].class);
    return (Runnable) constructor.newInstance(mainClass, args);
}
```
在lauch中，得到main class开始创建新线程启动main类。
