package fun.nnyy.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import fun.nnyy.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取工程的根目录
        String projectPath = System.getProperty("user.dir");//得到当前项目的路径
        gc.setOutputDir(projectPath + "/src/main/java");//生成文件输出根目录
        gc.setAuthor("seric");//作者
        gc.setOpen(false);//是否生成代码后打开本地目录
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setBaseResultMap(true);
        gc.setFileOverride(true);
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://nnyy.fun:3306/nnyy?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");//我的mysql是5.7版本的
        //dsc.setDriverName("com.mysql.cj.jdbc/Driver");//这是mysql8.0以上版本的
        dsc.setUsername("seric");
        dsc.setPassword("xsn@1314");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("cheng");
        pc.setParent("fun.nnyy");//设置父包

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
//         如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//表明生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(BaseEntity.class);
        strategy.setSuperEntityColumns("id", "create_by", "create_time", "update_by", "update_time");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);//controller是否使用restful风格
        mpg.setStrategy(strategy);
        mpg.execute();
    }

}