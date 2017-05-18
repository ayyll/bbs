# -*- coding:utf8 -*-
import urllib2
import re
import time
import sys
reload(sys)
sys.setdefaultencoding('utf-8')
for page in range(1,36):
    time.sleep(1)
    url = 'http://www.qiushibaike.com/hot/page/' + str(page)
    user_agent = 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)'
    headers = { 'User-Agent' : user_agent }
    try:
        request = urllib2.Request(url = url,headers = headers)
        response = urllib2.urlopen(request)
        content = response.read().decode('utf-8')
        #正则过滤，item[0]为发布人，item[1]为段子内容,
        #item[2]为图片链接(包含图片链接),item[3]为点赞数
        pattern = re.compile(
            '<div class="author clearfix">.*?<h2>(.*?)</h2>.*?<div class="content">.*?<span>(.*?)</span>.*?</div>(.*?)<div class="stats".*?i class="number">(.*?)</i>',
            re.S)
        items = re.findall(pattern, content)
        for item in items:
            #过滤图片链接，图片在控制台无法显示
            haveImg = re.search("img",item[2])
            if not haveImg:
                #去掉<br/>
                f = file("save.txt", "a+")
                f.write(item[1].replace("<br/>","") + '\n')
                f.close()
    except urllib2.URLError, e:
        if hasattr(e,"code"):
            print e.code
        if hasattr(e,"reason"):
            print e.reason