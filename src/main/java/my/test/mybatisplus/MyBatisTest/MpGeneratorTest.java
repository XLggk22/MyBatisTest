package my.test.mybatisplus.MyBatisTest;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;

public class MpGeneratorTest {

	public static void main(String[] args) {
		AutoGenerator mpg = new AutoGenerator();
		
		// 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("E:\\gen");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("raobinghua");
        
        gc.setMapperName("%sDao");
        gc.setXmlName("%sDao");
        gc.setServiceName("MP%sService");
        gc.setServiceImplName("%sServiceDiy");
        gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);
        
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
        // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("dm_pcs");
        dsc.setPassword("pcs@sit");
        dsc.setUrl("jdbc:mysql://192.168.2.234:3306/pcs?characterEncoding=UTF-8");
        mpg.setDataSource(dsc);
	}
	
}
