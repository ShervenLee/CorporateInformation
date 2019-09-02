package com.vojs.common;

import com.vojs.common.constants.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class PropertyConfigurer extends PropertyPlaceholderConfigurer {
    private Logger logger = LoggerFactory.getLogger(PropertyConfigurer.class);


    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
        logger.warn("========================加载配置文件开始==================");
        super.processProperties(beanFactory, props);
        AppConstants.configProperties = props;
        AppConstants.errorCodeProperties = props;
        logger.warn("========================加载配置文件结束===================");
    }
}
