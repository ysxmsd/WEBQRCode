//====页面动态加载C-Lodop云打印必须的文件CLodopfuncs.js====

var head = document.head || document.getElementsByTagName("head")[0] || document.documentElement;

/*
//让其它电脑的浏览器通过本机打印（仅适用C-Lodop自带的例子）：
var oscript = document.createElement("script");
oscript.src ="/CLodopfuncs.js";
head.insertBefore(oscript,head.firstChild );

*/
//让本机的浏览器打印(更优先一点)：
oscript = document.createElement("script");
oscript.src ="http://localhost:8000/CLodopfuncs.js?priority=2";
head.insertBefore(oscript,head.firstChild );

//加载双端口(8000和18000）避免其中某个端口被占用：
oscript = document.createElement("script");
oscript.src ="http://localhost:18000/CLodopfuncs.js?priority=1";
head.insertBefore( oscript,head.firstChild );


oscript = document.createElement("script");
oscript.src ="/js/Checkjs.js";
head.insertBefore( oscript,head.firstChild );





//====获取LODOP对象的主过程：====
function getLodop(oOBJECT,oEMBED){
//    var LODOP;
    try{
        try{ 
		LODOP=getCLodop();
	} catch(err) {};

        if (!LODOP && document.readyState!=="complete") {
		alert("C-Lodop没准备好，请稍后再试！"); 
		return;
	};

	//清理原例子内的object或embed元素，避免乱提示：
	if (oEMBED && oEMBED.parentNode) oEMBED.parentNode.removeChild(oEMBED);
	if (oOBJECT && oOBJECT.parentNode) oOBJECT.parentNode.removeChild(oOBJECT);
        return LODOP;
    } catch(err) {alert("getLodop出错:"+err);};
};


function needCLodop(){
	return true;  //本例子强制所有浏览器都调用C-Lodop
};


function CheckIsInstall() {
 //   var LODOP = getLodop();
    try{
        if (LODOP.VERSION) {
            if (LODOP.CVERSION)
                alert("当前有C-Lodop云打印可用!\n C-Lodop版本:"+LODOP.CVERSION+"(内含Lodop"+LODOP.VERSION+")");
            else
                alert("本机已成功安装了Lodop控件！\n 版本号:"+LODOP.VERSION);

        };
    }catch(err){
    }
};


function CheckLodop() {
//    var LODOP = getLodop();
    try {
        if (LODOP.VERSION == null)
                document.write("<h3><font color='#FF00FF'>打印控件未安装!点击这里<a href='../src/com/application/CLodop_Setup.exe'>执行安装</a>,安装后请刷新页面.</font>;</h3>");
        else{
                var oldVersion = LODOP.VERSION;
                var newVersion = "5.0.2.3";
                if (oldVersion < newVersion) {
                    alert("当前有C-Lodop云打印可用!\n C-Lodop版本:" + LODOP.CVERSION + "(内含Lodop" + LODOP.VERSION + ")");
                    document.write("<h3><font color='#FF00FF'>打印控件需要升级!点击这里<a href='../src/com/application/CLodop_Setup.exe'>执行升级</a>,升级后请重新进入.</font>;</h3>");
                    //LODOP.PRINT_INITA(0,0,236,238,"条码打印");
            }
            else {
                alert("当前有C-Lodop云打印最新版");
                //LODOP.PRINT_INITA(0,0,236,238,"条码打印");

            }

        }

    }catch(err){
        document.write("<h3><font color='#FF00FF'>打印控件未安装!点击这里<a href='../src/com/application/CLodop_Setup.exe'>执行安装</a>,安装后请刷新页面.</font>;</h3>");
    }
}


function createPrintPage(i,codeType,codeText) {
    LODOP.SET_PRINT_PAGESIZE(1,"80mm","80mm","");//设置纸张高度
    LODOP.ADD_PRINT_BARCODE(0,0,236,238,codeType,codeText);
    LODOP.NEWPAGE();//强制分页


/*
    for (var a = 0; a < 3; a++) {
        var number = a + 1;
        LODOP.ADD_PRINT_BARCODE(0,0,236,238,"QRCode",number);
        LODOP.NEWPAGE();//强制分页
    }
    LODOP.PREVIEW(); //打印预览
 */
}

//预览方法：
function print_view(){
 //createPrintPage();
 LODOP.PREVIEW();
}

//打印方法：
function print(){
    //createPrintPage();
    LODOP.print();
}

//打印维护：
function print_setup(){
    //createPrintPage();
    LODOP.PRINT_SETUP();
}

//打印设计：
function print_design(){
    //createPrintPage();
    LODOP.PRINT_DESIGN();
}




