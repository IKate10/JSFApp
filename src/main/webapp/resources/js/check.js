
function imgClickHandler(ClickEvent) {
    var parrentPos = getPosition(ClickEvent.currentTarget);
    var xPos = ClickEvent.clientX - parrentPos.x;
    var yPos = ClickEvent.clientY - parrentPos.y;
    var height = ClickEvent.currentTarget.clientHeight;
    var width = ClickEvent.currentTarget.clientWidth;
    r = document.getElementById('RVal').value;
    var yVal = height / 2 - yPos;
    var xVal = xPos - width / 2;
    yVal = (10 * yVal) / height;
    xVal = (10 * xVal) / width;
    document.getElementById('mainForm:XVal').value = xVal;
    document.getElementById('mainForm:YVal').value = yVal;
    document.getElementById('mainForm:hiddenSubmit').click();
}


function drawPoints() {
    var canvas=document.getElementById("canvas");
    var context=canvas.getContext("2d");
    var r = $("#mainForm\\:RVal_input").val();
    //alert(r);
    context.clearRect(0,0,canvas.width, canvas.height);
    var align = document.getElementById("canvas").getBoundingClientRect();
    var midX=align.left+align.width/2;
    var midY=align.top+align.height/2;
    var cou = 0;
    var table = document.getElementById("mainForm:table");
    var len=table.rows.length;
    //alert(len);
    $("#mainForm\\:table").find("tr").each(function () {
        var x;
        var y;
        var isHitted;
        var c = 0;
        cou+=1;
        if(cou>1) {
            $(this).find("td").each(function () {
                if (c === 0)
                    x = $(this).text();
                if (c === 1)
                    y = $(this).text();
                if (c === 3) {
                    isHitted = $(this).text().trim();
                    if(isHitted !== "") {
                        if (isHitted==='true') {
                            context.fillStyle = "#00ff00";
                        } else {
                            context.fillStyle = "#ff0000";
                        }
                        //alert(isHitted);
                        x = x * 93 / r + 127;
                        y = y * (-93) / r + 127;
                        context.fillRect(x, y, 2, 2);
                        //alert(x + "|" + y);
                    }
                }
                c++;
            });
        }
    });

}



function addPoint() {
    var x = document.forms["mainForm"]["XVal"].value;
    var y = document.forms["mainForm"]["YVal"].value;
    var r = document.forms["mainForm"]["RVal"].value;

}

    function validateForm() {
        var x = document.forms["mainForm"]["XVal"].value;
        var y = document.forms["mainForm"]["YVal"].value;
        var r = document.forms["mainForm"]["RVal"].value;

        var error = '';

        if (y.length == 0) {
            error = error + "Введите Y.\n"
        }

        if (isNaN(y) && y.length != 0) {
            error = error + "Введите число в поле Y.\n";
        }

        if (y < -3.0 || y > 3.0) {
            error = error+"Введите число в заданном промежутке в поле Y.\n";
        }

        if (error!= '') {
            document.getElementById('MyAnchor').textContent = error;
            return false;
        }


        document.getElementById("mainForm").submit();

    }






function resetR() {
    document.getElementById('mainForm:hiddenSubmit2').click();
}


function getPosition(element) {
    var xPos = 0;
    var yPos = 0;
    while (element) {
        xPos += (element.offsetLeft - element.scrollLeft + element.clientLeft);
        yPos += (element.offsetTop - element.scrollTop + element.clientTop);
        element = element.offsetParent;
    }
    return {x: xPos, y: yPos};
}


window.onload = drawPoints;

