package com.ayyll.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ayyll.service.ArticleService;
import com.ayyll.service.impl.ArticleServiceImpl;

public class FileUtils {
	public static List<String> readByLine(String filePath) {
		File file=new File(filePath);
		String encoding="UTF-8";
		List<String> ans = new ArrayList<String>();
        if(file.isFile() && file.exists()){ //判断文件是否存在
        	
            InputStreamReader read = null;
			try {
				read = new InputStreamReader(
				new FileInputStream(file),encoding);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            try {
				while((lineTxt = bufferedReader.readLine()) != null){
				   // System.out.println(lineTxt);
				    ans.add(lineTxt);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				read.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return ans;
	}
	
}
