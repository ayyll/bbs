
本项目fork自[https://github.com/Lutils/MyForum](https://github.com/Lutils/MyForum)

额，虽然是fork。。但我不怎么会pull request，所以实际上应该是copy，然后修改了一下，希望原作者勿怪。。
顾名思义，论坛就是那种论坛，注册，登陆，发帖，回帖，加精置顶(后台功能)..等等，(后来加了一个等级制度)。

演示地址:[个人论坛](http://120.25.149.118/MyForum/)

# 设计分析 #
## user表 ##
数据库总体设计4张表，一张user表，存用户信息，字段信息如下：

![](http://120.25.149.118/album/images/yh/github/1.png)

密码md5加密，头像上传到服务器存url，文件上传的时候有个小bug就是原作者是把头像上传到服务器下\resources\upload目录下，但是如果你拷贝这个项目服务器是没有这个目录的，so，上传的时候会报错，可以加上下面这句判断：

```
File tem = new File(filePath);
	if(!tem.exists()) {
		tem.mkdirs();
	}
```

上传头像时候还有一个bug就是Google Chrome浏览器点击 input file上传按钮时延迟3-5秒，当然这里主要是谷歌的问题，恩。。具体点应该是墙的问题，解决方法：[传送门](http://www.piaoyi.org/computer/Google-Chrome-input-file-delay-3-5.html)

user表后来我加了3个字段，分别代表等级，经验值，和对应的头衔。经验值初始为0，每20升一级(共18级)，发帖+5，回帖+3，楼中楼回复+2，并没有写互动。。就是别人回复你的帖子你并不会收益，理论上应该有收益的
## article表 ##
article表存帖子信息，具体字段如下：


![](http://120.25.149.118/album/images/yh/github/2.png)

title是标题，lable是帖子标签，content为帖子内容，即所谓的1楼(0楼),uid为外键(用户id)，关联user表，status为状态，0、普通 1、置顶 2、加精:3、加精且置顶
**这样的话前端(后台管理界面)可以只给两个按钮，一个加精一个置顶，在原帖status的基础值上加1或加2就可以了。**

## comment表 ##
comment表存评论信息，具体字段如下：

![](http://120.25.149.118/album/images/yh/github/3.png)

这张表比较简单，除了存评论内容，就是两个外键，uid(用户id),aid(帖子id),其他的没什么了。楼中楼同理，只不过还要多一个外键cid(评论id)，这里就不贴出来了。**楼中楼并没有分页展示，回复多了的话显得很长。。后期可以加上分页**

# 文本编辑器 #

[wangEditor](https://github.com/wangfupeng1988/wangEditor)——轻量级web富文本编辑器，配置方便，使用简单。支持IE8+浏览器。
引用wangEditor.css、jquery.js和wangEditor.js之后，即可简单生成富文本编辑器，简单易用。

官方demo：

```
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>wangEditor</title>
    <link rel="stylesheet" type="text/css" href="../dist/css/wangEditor.min.css">
    <style type="text/css">
        #div1 {
            width: 100%;
            height: 500px;
        }
    </style>
</head>
<body>
    <div id="div1">
        <p>请输入内容...</p>
    </div>

    <script type="text/javascript" src="../dist/js/lib/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../dist/js/wangEditor.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var editor = new wangEditor('div1');
            editor.create();
        });
    </script>
</body>
</html>
```

# 后话 #
论坛这种娱乐性的东西做起来确实比较好玩，后期可以好好改动一下，比如关注系统，分类系统。。等等
