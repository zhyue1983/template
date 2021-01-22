package com.zhyue.provider;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisPlusGenerator {


    /**
     * 项目路径  修改为你项目的实际绝对路径
     *
     */
    private static String canonicalPath = "";
    private static String projectPath = "/provider";


    /**
     * 基本包名
     */
    private static String basePackage = "com.zhyue.provider";

    /**
     * 作者
     */
    private static String authorName = "zhyue";

    /**
     * table前缀
     */
    private static  String[] prefix = {""};

    /**
     * 数据库类型
     */
    private static DbType dbType = DbType.MYSQL;

    /**
     * 数据库配置四要素
     */
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/provider?useSSL=true&requireSSL=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "sa1234";


    public static void main(String[] args) {

        String[] tables = getTables();
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        /**
         * 获取项目路径
         */
        try {
            //canonicalPath = new File("").getCanonicalPath();
            canonicalPath = new File("").getCanonicalPath();
            canonicalPath += projectPath;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
       // globalConfig.setOutputDir(canonicalPath + "/src/main/java");
        globalConfig.setOutputDir(canonicalPath + "/src/main/java");
        globalConfig.setFileOverride(false);
        globalConfig.setActiveRecord(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setOpen(true);
        globalConfig.setAuthor(authorName);
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("I%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        globalConfig.setSwagger2(true);
        mpg.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName(driverName);
        dataSourceConfig.setDbType(dbType);
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        mpg.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(basePackage);
        packageConfig.setController("controller");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("dao");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");

        mpg.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        /**
         * 注入自定义配置
         */
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig abc = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        //自定义文件输出位置（非必须）
        List<FileOutConfig> fileOutList = new ArrayList<FileOutConfig>();
        fileOutList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return canonicalPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        abc.setFileOutConfigList(fileOutList);
        mpg.setCfg(abc);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix(prefix);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(tables);

        strategyConfig.setEntityBuilderModel(true);
        strategyConfig.setRestControllerStyle(true);
        mpg.setStrategy(strategyConfig);
        mpg.execute();
    }

    public static String[] getTables()
    {
        ArrayList tables=new ArrayList();
        try
        {
            Class.forName(driverName);

            Connection conn= DriverManager.getConnection(url+"&user="+username+"&password="+password);
            Statement stmt = conn.createStatement();

            //getTableNameByCon(conn);
            ResultSet rs = stmt.executeQuery("show tables; ");

            while (rs.next()) {
                String tableName= rs.getString(1);
                tables.add(tableName);
            }
            Object[] arrayAreas= tables.toArray();
            String[] tableNames=new String[arrayAreas.length];
            for (int i=0;i<arrayAreas.length;i++)
            {
                tableNames[i]=arrayAreas[i].toString();
            }
            return  tableNames;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
