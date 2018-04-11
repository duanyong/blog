nginx转发tomcat8中的会带有cn.com.sales.leads的应用名称

```java
@GetMapping("/auto")
public String auto(
        @RequestParam(value = "by", defaultValue = "erp", required = false) String by,
        @RequestParam(value = "uri", defaultValue = "/", required = false) String uri
) {
    if (null == loginService.getUserFromCookie()) {
        switch (by) {
            case "erp": return redirectErpLogin(uri);
        }

        return redirectErpLogin(uri);
    }

    return "redirect:" + uri;
}
```
返回：http://leads.sales.sina.com.cn/cn.com.sina.sales.leads/project_new/index.html
需要去除cn.com.sina.sales.leads，直接返回：http://leads.sales.sina.com.cn/project_new/index.html