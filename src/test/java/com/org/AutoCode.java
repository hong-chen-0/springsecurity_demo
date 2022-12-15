package com.org;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class AutoCode {
    public static void main(String[] args) {
        //构建一个自动生成器的对象
        //构建一个自动生成器的对象
        AutoGenerator autoGenerator=new AutoGenerator();

        //数据源配置
        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/springsecurity_test?characterEncoding=utf8&serverTimezone=UTC");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setDbType(DbType.MYSQL);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String path = System.getProperty("user.dir");//获取当前目录
        globalConfig.setOutputDir(path+"/src/main/java");  //将生成好的代码放到指定目录
        globalConfig.setAuthor("刘文鑫");  //作者信息
        globalConfig.setOpen(false);    //不打开资源管理器
        globalConfig.setFileOverride(false);    //是否覆盖
        globalConfig.setServiceName("%sService");      //去Service的I前缀
        globalConfig.setIdType(IdType.AUTO);        //主键


        //包的配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.org");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("serviceImpl");
        packageConfig.setController("controller");

        //策略设置
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setInclude("user");    //设置要映射的表名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);  //开启lombok注解
        strategyConfig.setRestControllerStyle(true);    //支持rest风格
        strategyConfig.setControllerMappingHyphenStyle(true);   //url支持下划线命名

        autoGenerator.setGlobalConfig(globalConfig);    //设置全局配置
        autoGenerator.setDataSource(dataSourceConfig);      //设置数据源
        autoGenerator.setPackageInfo(packageConfig);    //包的配置
        autoGenerator.setStrategy(strategyConfig);      //设置策略

        autoGenerator.execute();    //执行
    }
}
