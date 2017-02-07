# ShJpushSdk
封装极光推送
##使用方法  

* 导入module（jpush_sdk）
* 替换string.xml里的jpush_appkey
* 替换AndroidManifest.xml里所有的com.sh.zsh.code.jpushsdk 为你的appid
* 在项目的 Application 里调用JpushHelper.initJpush(this);
* 在项目的 AndroidManifest.xml 里注册广播MyReceiver 继承JpushReceiver  如demo
