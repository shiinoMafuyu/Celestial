package com.celestial.meek.realTest_2016_08;  

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
 
public class GenEntityVO {  
      
private String packageOutPath = "com.vbm.grc.basic.busiarea";//指定实体生成�?��包的路径  
private String authorName = "lqy";//作�?名字  
private String extendVo="GrcSuperVO";
private String extendVoPath="com.grc.basic.vo.pub.GrcSuperVO;";
private String tablename = "grc_flow_list";//表名  
private String[] colnames; // 列名数组  
private String[] colTypes; //列名类型数组  
private int[] colSizes; //列名大小数组  
private boolean f_util = false; // 是否�?��导入包java.util.*  
private boolean f_sql = false; // 是否�?��导入包java.sql.*
private String pk;
/*private String sql="select 'public static final ' || 'String ' || upper(a.column_name) || '='||'"'||lower(a.column_name)||'"'||';'+
"from user_tab_cols a,user_col_comments  b +
"where a.TABLE_NAME = b.TABLE_NAME +
"and a.COLUMN_NAME = b.COLUMN_NAME+
"and a.table_name = 'FA_ASSET_APPLY';"*/
 //数据库连�? 


 private static final String URL ="jdbc:oracle:thin:@localhost:1521:orcl";
   private static final String NAME = "vbm_grc";  
    private static final String PASS = "vbm_grc";  
    private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";  
   /* 
33.     * 构�?函数 
34.     */  
    public GenEntityVO(){  
       //创建连接  
        Connection con;  
       //查要生成实体类的�? 
       String sql = "select * from " + tablename;  
        PreparedStatement pStemt = null;  
        try {  
            try {  
               Class.forName(DRIVER);  
            } catch (ClassNotFoundException e1) {  
                // TODO Auto-generated catch block  
                e1.printStackTrace();  
            }  
            con = DriverManager.getConnection(URL,NAME,PASS);  
            ResultSet rs = null;
            //String user_id=null;
            pStemt = con.prepareStatement(sql);  
            rs = pStemt.executeQuery();
        	/*while(rs.next()){
        		//user_id=rs.getString("user_id");
        	}*/
           ResultSetMetaData rsmd = pStemt.getMetaData();  
           int size = rsmd.getColumnCount();   //统计�? 
           colnames = new String[size];  
           colTypes = new String[size];  
           colSizes = new int[size];  
           for (int i = 0; i < size; i++) {  
               colnames[i] = rsmd.getColumnName(i + 1);  
               colTypes[i] = rsmd.getColumnTypeName(i + 1);  
                
                if(colTypes[i].equalsIgnoreCase("datetime")){  
                    f_util = true;  
                }  
                if(colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")){  
                    f_sql = true;  
                }  
               colSizes[i] = rsmd.getColumnDisplaySize(i + 1);  
            }  
              
            String content = parse(colnames,colTypes,colSizes);  
              
           try {  
                File directory = new File("");  
                //System.out.println("绝对路径�?+directory.getAbsolutePath());  
                //System.out.println("相对路径�?+directory.getCanonicalPath());  
                ///C:/Primeton/Platform/ide/eclipse/workspace_grc/GRC/com.vbm.grc.basic/bin/com/vbm/grc/basic/busiarea/

               String path=this.getClass().getResource("").getPath();  
                  
               System.out.println(path);  
               //src/?//com/vbm/grc/basic/busiarea/
//
               System.out.println("src/?/"+path.substring(path.lastIndexOf("/com/", path.length())) );  
//              String outputPath = directory.getAbsolutePath()+ "/src/"+path.substring(path.lastIndexOf("/com/", path.length()), path.length()) + initcap(tablename) + ".java";  
               //String outputPath = directory.getAbsolutePath()+ "/src/"+this.packageOutPath.replace(".", "/")+"/"+initcap(tablename) + ".java";  
               //C:\Primeton\Platform\ide\eclipse\workspace_grc\GRC/src/com/vbm/grc/basic/busiarea/Cap_user.java
               //C:\Primeton\Platform\ide\eclipse\workspace_grc\GRC\com.vbm.grc.basic\src\com\vbm\grc\basic\busiarea
               String outputPath= directory.getAbsolutePath()+"/com.vbm.grc.basic/"+"src/"+this.packageOutPath.replace(".", "/")+"/"+initcap(tablename).replace("_", "") + "VO"+".java";
               FileWriter fw = new FileWriter(outputPath);  
                PrintWriter pw = new PrintWriter(fw);  
               pw.println(content);  
               pw.flush();  
               pw.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
             
     } catch (SQLException e) {  
           e.printStackTrace();  
       } finally{  
//          try {  
//          } catch (SQLException e) {  
//              // TODO Auto-generated catch block  
//              e.printStackTrace();  
//          }  
        }      }  
  
   /** 
102.     * 功能：生成实体类主体代码 
103.     * @param colnames 
104.     * @param colTypes 
105.     * @param colSizes 
106.     * @return 
107.     */  
    private String parse(String[] colnames, String[] colTypes, int[] colSizes) {  
       StringBuffer sb = new StringBuffer();  
       sb.append("package " + this.packageOutPath + ";\r\n");  
       if(!this.extendVo.equals("")){
    	   sb.append("import "+this.extendVoPath+"\r\n");
       }
       //判断是否导入工具�? 
       if(f_util){  
          sb.append("import java.util.Date;\r\n");  
      }  
      if(f_sql){  
          sb.append("import java.sql.*;\r\n");  
      }  
      sb.append("\r\n");  
        //注释部分  
       sb.append("   /**\r\n");  
       sb.append("    * "+tablename+" 实体类\r\n");  
       sb.append("    * "+new Date()+" "+this.authorName+"\r\n");  
       sb.append("    */ \r\n");  
      //实体部分  
       sb.append("\r\n\r\npublic class " + initcap(tablename).replace("_", "") + "VO"+"  extends  "+this.extendVo + "{\r\n");  
        processAllAttrs(sb);//属�?  
      processAllMethod(sb);//get set方法  
      sb.append("}\r\n");  
         
       //System.out.println(sb.toString());  
      return sb.toString();  
    }
      
    /** 
     * 功能：生成所有属�?
     * @param sb 
    */  
    private void processAllAttrs(StringBuffer sb) {  
        
      for (int i = 0; i < colnames.length; i++) {  
    	  if(colnames[i].startsWith("PK"))
    		  this.pk=colnames[i].toLowerCase();
    	  if(colnames[i].equalsIgnoreCase("creater")||colnames[i].equalsIgnoreCase("createtime")||colnames[i].equalsIgnoreCase("modifier")||colnames[i].equalsIgnoreCase("modifiedtime")||colnames[i].equalsIgnoreCase("dr")||colnames[i].equalsIgnoreCase("ts"))
    		  continue;
           sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + colnames[i].toLowerCase()+ ";\r\n");  
       }  
      
      for (int i = 0; i < colnames.length; i++) {  
    	  if(colnames[i].equalsIgnoreCase("creater")||colnames[i].equalsIgnoreCase("createtime")||colnames[i].equalsIgnoreCase("modifier")||colnames[i].equalsIgnoreCase("modifiedtime")||colnames[i].equalsIgnoreCase("dr")||colnames[i].equalsIgnoreCase("ts"))
    		  continue;
           sb.append("\tprivate static final String "  + colnames[i] +"=" +'"'+colnames[i].toLowerCase()+'"'+";\r\n");  
       }  
         
   }  
  
    /** 
     * 功能：生成所有方�?
    * @param sb 
     */  
    private void processAllMethod(StringBuffer sb) {  
    	
     for (int i = 0; i < colnames.length; i++) {  
   	  if(colnames[i].equalsIgnoreCase("creater")||colnames[i].equalsIgnoreCase("createtime")||colnames[i].equalsIgnoreCase("modifier")||colnames[i].equalsIgnoreCase("modifiedtime")||colnames[i].equalsIgnoreCase("dr")||colnames[i].equalsIgnoreCase("ts"))
    		 continue;
           sb.append("\tpublic void set" + initFirst(colnames[i].toLowerCase()) + "(" + sqlType2JavaType(colTypes[i]) + " " +   
                   colnames[i].toLowerCase() + "){\r\n");  
            sb.append("\tthis." + colnames[i].toLowerCase() + "=" + colnames[i].toLowerCase() + ";\r\n");  
            sb.append("\t}\r\n");  
           sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initFirst(colnames[i].toLowerCase())  + "(){\r\n");  
            sb.append("\t\treturn " + colnames[i].toLowerCase() + ";\r\n");  
            sb.append("\t}\r\n");  
       }  
     if(this.extendVo.equals("GrcSuperVO"))
    		 this.extendVOMethod(sb);
         
   }  
      
    private String extendVOMethod(StringBuffer sb){
    	sb.append("   @Override\r\n");  
        sb.append("\tpublic String getParentPKFieldName"+"(){\r\n"); 
        sb.append("\t\treturn null;\r\n");  
        sb.append("\t}\r\n");  
        sb.append("   @Override\r\n");  
        sb.append("\tpublic String getPKFieldName"+"(){\r\n"); 
        sb.append("\t\treturn "+'"'+this.pk+'"'+";\r\n"); 
        sb.append("\t}\r\n");  
        sb.append("   @Override\r\n"); 
        sb.append("\tpublic String getTableName"+"(){\r\n");
        sb.append("\t\treturn " +'"'+this.tablename+'"'+";\r\n");
        sb.append("\t}\r\n");  
		return sb.toString();
    	
    }
    
   
    /** 
166.     * 功能：将输入字符串的首字母改成大�?
167.     * @param str 
168.     * @return 
169.     */  
    private String initcap(String str) {  
          
        char[] ch = str.toCharArray();  
        if(ch[0] >= 'a' && ch[0] <= 'z'){  
            ch[0] = (char)(ch[0] - 32);  
       }  
        for(int j=0;j<ch.length;j++){
        	if(ch[j]=='_'){
        		if(ch[j+1] >= 'a' && ch[j+1] <= 'z'){  
                    ch[j+1] = (char)(ch[j+1] - 32);  
               }  
        	}
        }
         
       return new String(ch);  
   }  
    
    private String initFirst(String str) {  
        
        char[] ch = str.toCharArray();  
        if(ch[0] >= 'a' && ch[0] <= 'z'){  
            ch[0] = (char)(ch[0] - 32);  
       }  
         
       return new String(ch);  
   } 
    
  /* private String initvoname(String str){
	   String[] a=str.split("_");
	   for(int i=0;i<a.length;i++){
		   
		   
	   }
	return str;
   }*/
 
   /** 
181.     * 功能：获得列的数据类�?
182.     * @param sqlType 
183.     * @return 
184.     */  
    private String sqlType2JavaType(String sqlType) {  
         
       if(sqlType.equalsIgnoreCase("bit")){  
           return "boolean";  
       }else if(sqlType.equalsIgnoreCase("tinyint")){  
           return "byte";  
       }else if(sqlType.equalsIgnoreCase("smallint")){  
           return "short";  
       }else if(sqlType.equalsIgnoreCase("int")||sqlType.equalsIgnoreCase("number")){  
           return "int";  
       }else if(sqlType.equalsIgnoreCase("bigint")){  
           return "long";  
      }else if(sqlType.equalsIgnoreCase("float")){  
          return "float";  
       }else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")   
               || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")   
              || sqlType.equalsIgnoreCase("smallmoney")){  
           return "double";  
        }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("varchar2")||sqlType.equalsIgnoreCase("char")   
              || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")   
              || sqlType.equalsIgnoreCase("text")){  
           return "String";  
        }else if(sqlType.equalsIgnoreCase("datetime")||sqlType.equalsIgnoreCase("date")||sqlType.equalsIgnoreCase("timestamp")){  
           return "Date";  
        }else if(sqlType.equalsIgnoreCase("image")){            return "Blod";  
        }  
          
      return null;  
    }  
     
    /** 
217.     * 出口 
218.     * TODO 
219.     * @param args 
220.     */  
    public static void main(String[] args) {  
          
        new GenEntityVO();  
         
    }  
  
}  


