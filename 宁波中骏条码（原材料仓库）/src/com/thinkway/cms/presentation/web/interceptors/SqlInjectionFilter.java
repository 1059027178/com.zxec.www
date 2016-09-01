package com.thinkway.cms.presentation.web.interceptors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
* 过滤sql关键字的Filter
* @author

*/
public class SqlInjectionFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	request.setCharacterEncoding("UTF-8");////设置request的编码
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //获得所有请求参数名
        Enumeration params = req.getParameterNames();

        String sql = "";
        while (params.hasMoreElements()) {
            //得到参数名
            String name = params.nextElement().toString();
            //System.out.println("name: " + name);
            //得到参数对应值
            if(name.equals("sort")||name.equals("dir")){ //只有动态排序才会检查SQL注入
                String[] value = req.getParameterValues(name);
                for (int i = 0; i < value.length; i++) {
                    sql = sql + value[i];
                }
            }
        }
        //System.out.println("SQL: "+sql);
        //有sql关键字，跳转到error.html
        if (sqlValidate(sql)) {
        	System.out.println("SQL-X: "+sql);
            res.sendRedirect("error.html");
            //String ip = req.getRemoteAddr();
        } else {
            chain.doFilter(req, res);
        }
    }

    
    
    public static String replace(String str, String substr, String restr) {
        String[] tmp = split(str, substr);
        String returnstr = null;
        if (tmp.length != 0) {
            returnstr = tmp[0];
            for (int i = 0; i < tmp.length - 1; i++)
                returnstr = dealNull(returnstr) + restr + tmp[i + 1];
        }
        return dealNull(returnstr);
    }

    public static String[] split(String source, String div) {
        int arynum = 0, intIdx = 0, intIdex = 0, div_length = div.length();
        if (source.compareTo("") != 0) {
            if (source.indexOf(div) != -1) {
                intIdx = source.indexOf(div);
                for (int intCount = 1;; intCount++) {
                    if (source.indexOf(div, intIdx + div_length) != -1) {
                        intIdx = source.indexOf(div, intIdx + div_length);
                        arynum = intCount;
                    } else {
                        arynum += 2;
                        break;
                    }
                }
            } else
                arynum = 1;
        } else
            arynum = 0;

        intIdx = 0;
        intIdex = 0;
        String[] returnStr = new String[arynum];

        if (source.compareTo("") != 0) {

            if (source.indexOf(div) != -1) {

                intIdx = (int) source.indexOf(div);
                returnStr[0] = (String) source.substring(0, intIdx);

                for (int intCount = 1;; intCount++) {
                    if (source.indexOf(div, intIdx + div_length) != -1) {
                        intIdex = (int) source
                                .indexOf(div, intIdx + div_length);

                        returnStr[intCount] = (String) source.substring(intIdx
                                + div_length, intIdex);

                        intIdx = (int) source.indexOf(div, intIdx + div_length);
                    } else {
                        returnStr[intCount] = (String) source.substring(intIdx
                                + div_length, source.length());
                        break;
                    }
                }
            } else {
                returnStr[0] = (String) source.substring(0, source.length());
                return returnStr;
            }
        } else {
            return returnStr;
        }
        return returnStr;
    }

    public static boolean sqlValidate(String str) {
        String inj_str = "':and:exec:insert:select:delete:update:count:*:%:chr:mid:master:truncate:char:declare:;:or:-:+:,";;//过滤掉的sql关键字，可以手动添加;
        String inj_stra[] = split(inj_str, ":");
        for (int i = 0; i < inj_stra.length; i++) {
            if (str.indexOf(inj_stra[i]) >= 0) {
            	//System.out.println(inj_stra[i]);
                return true;
            }
        }
        return false;
    }

    private static String dealNull(String str) {
        String returnstr = null;
        if (str == null)
            returnstr = "";
        else
            returnstr = str;
        return returnstr;
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}

