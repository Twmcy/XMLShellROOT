package com.projectkr.shell;

import android.content.Context;

import com.omarea.krscript.executor.ScriptEnvironmen;
import com.omarea.krscript.model.PageNode;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

public class KrScriptConfig {
    private static final String ASSETS_FILE = "file:///android_asset/";

    private final static String TOOLKIT_DIR = "toolkit_dir";
    private final static String TOOLKIT_DIR_DEFAULT = "file:///android_asset/kr-script/toolkit";

    private final static String EXECUTOR_CORE = "executor_core";
    private final static String PAGE_LIST_CONFIG = "page_list_config";
    private final static String FAVORITE_CONFIG = "favorite_config";
    private final static String PAGE_LIST_CONFIG_SH = "page_list_config_sh";
    private final static String XML_XML1 = "xml_xml1";
    private final static String XML_XML2 = "xml_xml2";
    private final static String XML_XML3 = "xml_xml3";
    private final static String XML_XML4 = "xml_xml4";
    private final static String XML_XML5 = "xml_xml5";
    private final static String XML_XML6 = "xml_xml6";
    private final static String XML_XML7 = "xml_xml7";
    private final static String XML_XML8 = "xml_xml8";
    private final static String XML_XML9 = "xml_xml9";
    private final static String XML_XML10 = "xml_xml10";
    private final static String XML_XML11 = "xml_xml11";
    private final static String XML_XML12 = "xml_xml12";
    private final static String XML_XML13 = "xml_xml13";
    private final static String XML_XML14 = "xml_xml14";
    private final static String XML_XML15 = "xml_xml15";
    private final static String XML_XML16 = "xml_xml16";
    private final static String XML_XML17 = "xml_xml17";
    private final static String XML_XML18 = "xml_xml18";
    private final static String XML_XML19 = "xml_xml19";
    private final static String XML_XML20 = "xml_xml20";
    private final static String XML_XML21 = "xml_xml21";
    private final static String FAVORITE_CONFIG_SH = "favorite_config_sh";
    private final static String XML_XML1_SH = "xml_xml1_sh";
    private final static String XML_XML2_SH = "xml_xml2_sh";
    private final static String XML_XML3_SH = "xml_xml3_sh";
    private final static String XML_XML4_SH = "xml_xml4_sh";
    private final static String XML_XML5_SH = "xml_xml5_sh";
    private final static String XML_XML6_SH = "xml_xml6_sh";
    private final static String XML_XML7_SH = "xml_xml7_sh";
    private final static String XML_XML8_SH = "xml_xml8_sh";
    private final static String XML_XML9_SH = "xml_xml9_sh";
    private final static String XML_XML10_SH = "xml_xml10_sh";
    private final static String XML_XML11_SH = "xml_xml11_sh";
    private final static String XML_XML12_SH = "xml_xml12_sh";
    private final static String XML_XML13_SH = "xml_xml13_sh";
    private final static String XML_XML14_SH = "xml_xml14_sh";
    private final static String XML_XML15_SH = "xml_xml15_sh";
    private final static String XML_XML16_SH = "xml_xml16_sh";
    private final static String XML_XML17_SH = "xml_xml17_sh";
    private final static String XML_XML18_SH = "xml_xml18_sh";
    private final static String XML_XML19_SH = "xml_xml19_sh";
    private final static String XML_XML20_SH = "xml_xml20_sh";
    private final static String XML_XML21_SH = "xml_xml21_sh";
    private final static String ALLOW_HOME_PAGE = "allow_home_page";
    private final static String BEFORE_START_SH = "before_start_sh";
    private static HashMap<String, String> configInfo;
    private final String EXECUTOR_CORE_DEFAULT = "file:///android_asset/kr-script/executor.sh";
    private final String PAGE_LIST_CONFIG_DEFAULT = "file:///android_asset/kr-script/pages/more.xml";
    private final String FAVORITE_CONFIG_DEFAULT = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML1 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML2 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML3 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML4 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML5 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML6 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML7 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML8 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML9 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML10 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML11 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML12 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML13 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML14 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML15 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML16 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML17 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML18 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML19 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML20 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String XML_XML_XML21 = "file:///android_asset/kr-script/pages/favorites.xml";
    private final String ALLOW_HOME_PAGE_DEFAULT = "1";
    private final String BEFORE_START_SH_DEFAULT = ""; //"file:///android_asset/kr-script/before_start.sh";

    public KrScriptConfig init(Context context) {
        if (configInfo == null) {
            configInfo = new HashMap<>();
            configInfo.put(EXECUTOR_CORE, EXECUTOR_CORE_DEFAULT);
            configInfo.put(PAGE_LIST_CONFIG, PAGE_LIST_CONFIG_DEFAULT);
            configInfo.put(FAVORITE_CONFIG, FAVORITE_CONFIG_DEFAULT);
            configInfo.put(ALLOW_HOME_PAGE, ALLOW_HOME_PAGE_DEFAULT);
            configInfo.put(TOOLKIT_DIR, TOOLKIT_DIR_DEFAULT);
            configInfo.put(BEFORE_START_SH, BEFORE_START_SH_DEFAULT);
            configInfo.put(XML_XML1, XML_XML_XML1);
            configInfo.put(XML_XML2, XML_XML_XML2);
            configInfo.put(XML_XML3, XML_XML_XML3);
            configInfo.put(XML_XML4, XML_XML_XML4);
            configInfo.put(XML_XML5, XML_XML_XML5);
            configInfo.put(XML_XML6, XML_XML_XML6);
            configInfo.put(XML_XML7, XML_XML_XML7);
            configInfo.put(XML_XML8, XML_XML_XML8);
            configInfo.put(XML_XML9, XML_XML_XML9);
            configInfo.put(XML_XML10, XML_XML_XML10);
            configInfo.put(XML_XML11, XML_XML_XML11);
            configInfo.put(XML_XML12, XML_XML_XML12);
            configInfo.put(XML_XML13, XML_XML_XML13);
            configInfo.put(XML_XML14, XML_XML_XML14);
            configInfo.put(XML_XML15, XML_XML_XML15);
            configInfo.put(XML_XML16, XML_XML_XML16);
            configInfo.put(XML_XML17, XML_XML_XML17);
            configInfo.put(XML_XML18, XML_XML_XML18);
            configInfo.put(XML_XML19, XML_XML_XML19);
            configInfo.put(XML_XML20, XML_XML_XML20);
            configInfo.put(XML_XML21, XML_XML_XML21);

            try {
                String fileName = context.getString(R.string.kr_script_config);
                if (fileName.startsWith(ASSETS_FILE)) {
                    fileName = fileName.substring(ASSETS_FILE.length());
                }
                InputStream inputStream = context.getAssets().open(fileName);
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                String[] rows = new String(bytes, Charset.defaultCharset()).split("\n");
                for (String row : rows) {
                    String rowText = row.trim();
                    if (!rowText.startsWith("#") && rowText.contains("=")) {
                        int separator = rowText.indexOf("=");
                        String key = rowText.substring(0, separator).trim();
                        String value = rowText.substring(separator + 2, rowText.length() - 1).trim();
                        configInfo.remove(key);
                        configInfo.put(key, value);
                    }
                }
            } catch (Exception ex) {
            }
            ScriptEnvironmen.init(context, getExecutorCore(), getToolkitDir());
        }

        return this;
    }

    public HashMap<String, String> getVariables() {
        return configInfo;
    }

    private String getExecutorCore() {
        if (configInfo != null && configInfo.containsKey(EXECUTOR_CORE)) {
            return configInfo.get(EXECUTOR_CORE);
        }
        return EXECUTOR_CORE_DEFAULT;
    }

    private String getToolkitDir() {
        if (configInfo != null && configInfo.containsKey(TOOLKIT_DIR)) {
            return configInfo.get(TOOLKIT_DIR);
        }
        return TOOLKIT_DIR_DEFAULT;
    }

    public PageNode getPageListConfig() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(PAGE_LIST_CONFIG_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(PAGE_LIST_CONFIG_SH));
            }
            if (configInfo.containsKey(PAGE_LIST_CONFIG)) {
                pageInfo.setPageConfigPath(configInfo.get(PAGE_LIST_CONFIG));
            }
            return pageInfo;
        }
        return null;
    }

    public PageNode getFavoriteConfig() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(FAVORITE_CONFIG_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(FAVORITE_CONFIG_SH));
            }
            if (configInfo.containsKey(FAVORITE_CONFIG)) {
                pageInfo.setPageConfigPath(configInfo.get(FAVORITE_CONFIG));
            }
            return pageInfo;
        }
        return null;
    }

    public boolean getAllowHomePage() {
        if (configInfo != null && configInfo.containsKey(ALLOW_HOME_PAGE)) {
            String value = configInfo.get(ALLOW_HOME_PAGE);
            return value != null && value.equals("1");
        }
        return ALLOW_HOME_PAGE_DEFAULT.equals("1");
    }

    public String getBeforeStartSh() {
        if (configInfo != null && configInfo.containsKey(BEFORE_START_SH)) {
            return configInfo.get(BEFORE_START_SH);
        }
        return BEFORE_START_SH_DEFAULT;
    }
    
        public PageNode getFavoriteConfig1() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML1_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML1_SH));
            }
            if (configInfo.containsKey(XML_XML1)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML1));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig2() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML2_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML2_SH));
            }
            if (configInfo.containsKey(XML_XML2)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML2));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig3() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML3_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML3_SH));
            }
            if (configInfo.containsKey(XML_XML3)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML3));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig4() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML4_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML4_SH));
            }
            if (configInfo.containsKey(XML_XML4)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML4));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig5() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML5_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML5_SH));
            }
            if (configInfo.containsKey(XML_XML5)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML5));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig6() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML6_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML6_SH));
            }
            if (configInfo.containsKey(XML_XML6)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML6));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig7() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML7_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML7_SH));
            }
            if (configInfo.containsKey(XML_XML7)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML7));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig8() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML8_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML8_SH));
            }
            if (configInfo.containsKey(XML_XML8)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML8));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig9() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML9_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML9_SH));
            }
            if (configInfo.containsKey(XML_XML9)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML9));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig10() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML10_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML10_SH));
            }
            if (configInfo.containsKey(XML_XML10)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML10));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig11() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML11_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML11_SH));
            }
            if (configInfo.containsKey(XML_XML11)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML11));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig12() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML12_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML12_SH));
            }
            if (configInfo.containsKey(XML_XML12)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML12));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig13() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML13_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML13_SH));
            }
            if (configInfo.containsKey(XML_XML13)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML13));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig14() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML14_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML14_SH));
            }
            if (configInfo.containsKey(XML_XML14)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML14));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig15() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML15_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML15_SH));
            }
            if (configInfo.containsKey(XML_XML15)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML15));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig16() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML16_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML16_SH));
            }
            if (configInfo.containsKey(XML_XML16)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML16));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig17() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML17_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML17_SH));
            }
            if (configInfo.containsKey(XML_XML17)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML17));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig18() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML18_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML18_SH));
            }
            if (configInfo.containsKey(XML_XML18)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML18));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig19() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML19_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML19_SH));
            }
            if (configInfo.containsKey(XML_XML19)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML19));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig20() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML20_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML20_SH));
            }
            if (configInfo.containsKey(XML_XML20)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML20));
            }
            return pageInfo;
        }
        return null;
    }
    
        public PageNode getFavoriteConfig21() {
        if (configInfo != null) {
            PageNode pageInfo = new PageNode("");
            if (configInfo.containsKey(XML_XML21_SH)) {
                pageInfo.setPageConfigSh(configInfo.get(XML_XML21_SH));
            }
            if (configInfo.containsKey(XML_XML21)) {
                pageInfo.setPageConfigPath(configInfo.get(XML_XML21));
            }
            return pageInfo;
        }
        return null;
    }
  }
