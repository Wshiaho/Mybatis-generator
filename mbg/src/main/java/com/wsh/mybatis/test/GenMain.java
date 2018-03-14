package com.wsh.mybatis.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GenMain {

    private final String profilepath= this.getClass().getClassLoader().getResource("/").getPath();

    @RequestMapping("getMain")
    public Object getMain(HttpServletRequest request, Model model){
        String modelTargetPackage=request.getParameter("modelTargetPackage");//model的包名
        String mapTargetPackage=request.getParameter("mapTargetPackage");//映射文件的包名
        String daoTargetPackage=request.getParameter("daoTargetPackage");//DAO的包名
        String table=request.getParameter("table");//表名
        if (!("").equals(modelTargetPackage) && !("").equals(mapTargetPackage) && !("").equals(daoTargetPackage) && !("").equals(table)) {
            UpdateProperties updateProperties = new UpdateProperties();
            updateProperties.writeProperties("public.ModelGenerator.targetPackage", modelTargetPackage);
            updateProperties.writeProperties("public.MapGenerator.targetPackage", mapTargetPackage);
            updateProperties.writeProperties("public.ClientGenerator.targetPackage", daoTargetPackage);
            updateProperties.writeProperties("public.table", table);
            updateProperties.writeProperties("public.targetProject",profilepath);
            boolean msg = mgb();
            if (msg==true) {
                model.addAttribute("msg",profilepath);
                return "/success";
            }else {
                return "/error.jsp";
            }
        }else {
            return "/error.jsp";
        }
    }
    public boolean mgb(){
        List<String> warnings = new ArrayList<String>();
        boolean overwrite =true;
        String genCfg = "/MybatisGeneratorConfig.xml";
        File configFile = new File(GenMain.class.getResource(genCfg).getFile());
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = null;
        try{
            configuration = configurationParser.parseConfiguration(configFile);
        } catch (XMLParserException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try{
            myBatisGenerator = new MyBatisGenerator(configuration,callback,warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
            return false;
        }
        try {
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
public static void main(String[] args) {
    UpdateProperties updateProperties = new UpdateProperties();
    updateProperties.writeProperties("public.ModelGenerator.targetPackage", "com.wsh.entity");
    updateProperties.writeProperties("public.MapGenerator.targetPackage", "com.wsh.mapper");
    updateProperties.writeProperties("public.ClientGenerator.targetPackage", "com.wsh.dao");
    updateProperties.writeProperties("public.table", "Wshihao");
    List<String> warnings = new ArrayList<String>();
        boolean overwrite =true;

        String genCfg = "/MybatisGeneratorConfig.xml";
        File configFile = new File(GenMain.class.getResource(genCfg).getFile());
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = null;
        try{
            configuration = configurationParser.parseConfiguration(configFile);
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try{
            myBatisGenerator = new MyBatisGenerator(configuration,callback,warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}

}
//    public static void main(String[] args) {
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite =true;
//        String genCfg = "/MybatisGeneratorConfig.xml";
//        File configFile = new File(GenMain.class.getResource(genCfg).getFile());
//        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
//        Configuration configuration = null;
//        try{
//            configuration = configurationParser.parseConfiguration(configFile);
//        } catch (XMLParserException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = null;
//        try{
//            myBatisGenerator = new MyBatisGenerator(configuration,callback,warnings);
//        } catch (InvalidConfigurationException e) {
//            e.printStackTrace();
//        }
//        try {
//            myBatisGenerator.generate(null);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }