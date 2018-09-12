

function uploadFile() {
    var xmlhttp;
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
           // document.getElementById('myDiv').innerHTML=xmlhttp.responseText;
            getResult();

            function getResult(){
                if(xmlhttp.readyState==4 && xmlhttp.status==200){
                    //获取后台传递过来的字符串转换为josn
                    var responseJosn=JSON.parse(xmlhttp.responseText);
                    var tb=document.getElementById("tb");
                    var index=0;

                    for(var i in responseJosn){
                        var tr=document.createElement("tr");

                        var codeText=document.createElement("td");
                        var codeType=document.createElement("td");
                        codeText.innerHTML=responseJosn[i].codeText;
                        codeType.innerHTML=responseJosn[i].codeType;

                        tb.appendChild(tr);
                        tr.appendChild(codeText);
                        tr.appendChild(codeType);
                        createPrintPage(index,responseJosn[i].codeType,responseJosn[i].codeText);
                        index=index+1;

                    }
                }
            }
        }
    }
    var formdata = new FormData(document.getElementById('form1'));
    xmlhttp.open("POST", "./TXTJSONServlet", true);
    xmlhttp.send(formdata);


}





