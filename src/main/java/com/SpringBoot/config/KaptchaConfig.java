package com.SpringBoot.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@Component
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha getDDefaultKaptcha() {
    	
    	//DefaultKaptcha最关键的核心，图片实现类
        DefaultKaptcha dk = new DefaultKaptcha();
        
        /*
         * properties文件配置参数
         * 也可以自己创建一个properties文件读取
         */
        
        Properties properties = new Properties();
        // 图片边框
        properties.setProperty("kaptcha.border", "yes");
        // 边框颜色
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "red");
        // 图片宽
        properties.setProperty("kaptcha.image.width", "110");
        // 图片高
        properties.setProperty("kaptcha.image.height", "40");
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        // session key
        properties.setProperty("kaptcha.session.key", "code");
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "6");
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names", "Arial, Courier");
        
        //配置参数修改
        Config config = new Config(properties);
        dk.setConfig(config);

        return dk;
    }
}
