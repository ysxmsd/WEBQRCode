package com.code.service;
import com.code.bean.CodeBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * @author conshu
 * @date 2018/8/29.
 */
public class TextProcess {

    public List readTEXT(BufferedReader br){

        /**
         * 具体实现文件读取
         * @param path
         * @return
         */
            String parentkey="";
            String fieldid="";
            List list=new ArrayList();
            BufferedReader in=null;
            try{
                in=new BufferedReader(br);
                String str="";
                StringTokenizer st;
                Map line=null;
                boolean prebegin=false;
                boolean begin=false;
                while((str=in.readLine())!=null)
                {
                    //文件内容开始标志
                    if(str.indexOf("Content-Type")>-1){
                        prebegin=true;
                        continue;
                    }
                    if(prebegin){
                        prebegin=false;
                        begin=true;
                        continue;
                    }
                    //文件结算标志
                    if(str.indexOf("--")>-1){
                        begin=false;
                        continue;
                    }
                    if(begin){
                        //"#"开头的标注不导入
                        if(str.trim().substring(0,1).equalsIgnoreCase("#"))  continue;
                        System.out.println(str);
                        CodeBean cb=new CodeBean();
                        cb.setCodeText(str);
                        cb.setCodeType("QRCode");
                        //str="\"+codeText+\""
                        list.add(cb);

                        /*
                        if(str.indexOf(",")>-1){

                            //","为分隔符读取字符串
                            st=new StringTokenizer(str.trim(),",");
                            line=new HashMap();
                            //岗位编号
                            line.put("post_no", st.nextToken());
                            //物资编号
                            line.put("mat_code", st.nextToken());
                            //发放年月
                            line.put("get_date", st.nextToken());
                            //发放数量
                            line.put("use_num", st.nextToken());
                            line.put("person_id", parentkey);
                            line.put("field_id", fieldid);
                            rs.add(line);
                        }
                        */
                    }

                }
                in.close();
            }catch(Exception e){
                e.printStackTrace();
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
            if(list==null || list.size()<1){
                System.out.println("can't read file !");
                return null;
            }else{
                return list;
            }
        }
    }
