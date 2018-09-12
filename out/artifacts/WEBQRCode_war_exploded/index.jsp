<%--
  Created by IntelliJ IDEA.
  User: conshu
  Date: 2018/8/25
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

  <head>
     <!--
        <object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
          <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
        </object>
     -->
<script src="${pageContext.request.contextPath}/js/LodopFuncs.js"></script>
<script src="${pageContext.request.contextPath}/js/ajax.js"></script>
  </head>




  <body>

    ID: <INPUT type=text id=text_0 maxLength=50 name=text_0>
    USERNAME: <INPUT type=text id=text_1 maxLength=50 name=text_1>
    PASSWORD: <INPUT type=text id=text_2 maxLength=50 name=text_2>
    SEX: <INPUT type=text id=text_3 maxLength=50 name=text_3>
    AGE: <INPUT type=text id=text_4 maxLength=50 name=text_4>
    EMAIL: <INPUT type=text id=text_5 maxLength=50 name=text_5>

    <BUTTON onclick=CheckLodop()>打印程序安装检测</BUTTON>
    <BUTTON onclick=print_view()>打印预览</BUTTON>
    <BUTTON onclick=print()>打印</BUTTON>
    <BUTTON onclick=print_setup()>打印维护</BUTTON>
    <BUTTON onclick=print_design()>打印设计</BUTTON>


    <h1>界面选择文件提交服务端Servlet</h1>
        <form id="form1" enctype="multipart/form-data">
            选择要上传的文件：<input type="file" name="file" /><br>
            <button type="button" onclick="uploadFile()">发送</button>
        </form>
        <br>

        <div id="myDiv"><h2></h2></div>
          <!--
          <form  method="POST" action="FileLoad.jsp" id="uploadForm"  name="uploadForm"  enctype="multipart/form-data">
            <input type="file" name="attachfile" id="attachfile">
            <input type="submit" value="upload">
          </form>
          -->




    <h2>建立表单，从服务端通过Servlet获取数据过来</h2>
    <input id="get" name="getdata" value="获取数据" type="button">
    <table id="tb" border="1">
      <tr>
        <td>codeText</td>
        <td>codeType</td>
      </tr>
    </table>



  </body>
</html>
