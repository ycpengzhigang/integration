package com.minle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:risk_management_dubbo.xml" })
public class ResourceTest {
    
    @Test
    public void testResourceLoader() {  
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("http://www.google.com.hk");
        System.out.println(resource instanceof UrlResource);
        resource = loader.getResource("classpath*:test.txt");
        System.out.println(resource instanceof ClassPathResource);
        resource = loader.getResource("test.txt");
        System.out.println(resource instanceof ClassPathResource);
        
    }
    
    
    public static void main(String[] args) throws IOException {
        /* 在当前类下的同包下加载资源
         * 如果需要获取别的包下的资源则需要加上"/" e.g:/com/touna/credit/riskmanagement/hash/rule.json
         * 获取跟路径下的资源："/xx.txt"
         */
//        InputStream in = new ResourceTest().getClass().getResourceAsStream("/com/touna/credit/riskmanagement/hash/rule.json");
//        String str = IOUtils.toString(in, "utf-8");
//        System.out.println(str);
        
        /* 在当前类下的同包下加载资源
         * 如果需要获取别的包下的资源则不需要加上"/" e.g:com/touna/credit/riskmanagement/hash/rule.json
         * 获取跟路径下的资源："xx.txt"
         */
//        InputStream in = new ResourceTest().getClass().getClassLoader().getResourceAsStream("com/touna/credit/riskmanagement/hash/rule.json");
//        String str = IOUtils.toString(in, "utf-8");
//        System.out.println(str);
        
        /*
         * 获取文件系统中的资源
         */
        
        /*
         * 注意：File(String name) 中的name参数可以是相对路径和绝对路径, 相对路径是相对System.out.println(System.getProperty("user.dir")); 
         * 绝对路径可以直接写e.g
         * D:/workspace/risk-management/risk-management.service/src/test/java/com/touna/credit/riskmanagement/hash/rule.json
         */
        System.out.println(System.getProperty("user.dir")); 
        File file = new File("D:\\workspace\\risk-management\\risk-management.service\\src\\test\\java\\com\\touna\\credit\\riskmanagement/hash/rule.json");
        InputStream in = new FileInputStream(file); 
        String str = IOUtils.toString(in, "utf-8");
        System.out.println(str);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
}
