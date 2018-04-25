#ubuntu# #smb# ubuntu配置samba


在公司扫描仪上设置自己的共享文件目录，直接就可以扫描到自己的电脑上。

```
sudo apt-get install samba
```
```
#采用用户名和密码的验证方式
security = user
[scan]
    path = /home/duanyong/scan
    comment         = duanyong's samba
    writable        = yes
    printable       = no
    public          = no
    valid users		  = @root, duanyong
    create mask 	  = 0660
    directory mask 	= 0770
    case sensitive 	= no
```


将当前用户添加到samba的用户名单中，此处设置的密码不需要和系统中一致，只是用于登录共享时的密码。
```
sudo smbpasswd -a duanyong
```

```
sudo service smbd restart
```
