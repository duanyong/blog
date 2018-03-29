java 的header设置host没有任何作用

设置HTTP header的Host属性时，JVM忽略此参数。
需要设置jvm的参数
```java
+        System.setProperty("sun.net.http.allowRestrictedHeaders",   "true");
         addHeader("Host",     "auto.sina.com.cn");
         addHeader("Referer",  "http://auto.sina.com.cn/reboot");
```


```java
private static final String[] restrictedHeaders = {
    /* Restricted by XMLHttpRequest2 */
    //"Accept-Charset",
    //"Accept-Encoding",
    "Access-Control-Request-Headers",
    "Access-Control-Request-Method",
    "Connection", /* close is allowed */
    "Content-Length",
    //"Cookie",
    //"Cookie2",
    "Content-Transfer-Encoding",
    //"Date",
    "Expect",
    "Host",
    "Keep-Alive",
    "Origin",
    // "Referer", 
    // "TE",
    "Trailer",
    "Transfer-Encoding",
    "Upgrade",
    //"User-Agent",
    "Via"
};
```


